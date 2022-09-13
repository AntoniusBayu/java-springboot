package com.example.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.producer.model.customer;

@Service
public class customerservice implements ICustomerService{

	@Autowired
    private KafkaTemplate<String, customer> kafkaTemplate;
	
	String kafkaTopic = "customer-topics";
	
	@Override
	public void send(customer data) {
		kafkaTemplate.send(kafkaTopic, data);
	}

}
