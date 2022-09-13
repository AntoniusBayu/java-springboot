package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.consumer.model.customer;
import com.example.consumer.service.ICustomer;

@SpringBootApplication
@EntityScan("com.example.consumer.model")
@EnableJpaRepositories(basePackages = "com.example.consumer.repo")
public class ConsumerApplication {

	@Autowired
	private ICustomer _service;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@KafkaListener(topics = "customer-topics", groupId = "customer")
    public void listen(customer data) {

        System.out.println("Received customer information : " + data);
        _service.saveCustomer(data);
    }
}
