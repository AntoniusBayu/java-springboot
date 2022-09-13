package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.model.customer;
import com.example.producer.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customerkafka")
public class customerController {

	@Autowired
	private ICustomerService _service;
	
	@PostMapping("/producer")
    public String sendMessage(@RequestBody customer user)
    {
		_service.send(user);
        return "Message sent successfully to the Kafka topic customer-topics";
    }
}
