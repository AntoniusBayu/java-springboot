package com.example.controller;


import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ICustomerservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.model.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	private static final Logger _logger = Logger.getLogger(CustomerController.class.getName());
	private ObjectMapper _obj = new ObjectMapper();
	@Autowired
	private ICustomerservice _service;
	
	@GetMapping("/customer")
	public String customer() {
		_logger.info("Masuk ke endpoint customer");
		return "Hello Customer";
	}
	
	@GetMapping("/helloworld")
	public String helloworld() {
		_logger.info("Masuk ke endpoint helloworld");
		return "Hello World";
	}
	
	@GetMapping("/getcustomer")
	public String getcustomer() {
		_logger.info("Masuk ke endpoint getcustomer");
		var x = _service.GetFirstCustomer();
		
		return x.getCustomername();
	}
	
	@PostMapping("/postcustomer")
	public String postcustomer(@RequestBody customer data) {
		_logger.info("Masuk ke endpoint postcustomer");
		String x = "";
		
		try {
			x = _obj.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(x);
		_service.saveCustomer(data);
		
		return "berhasil di post";
	}
	
	@PutMapping("/putcustomer")
	public String putcustomer(@RequestBody customer data) {
		_logger.info("Masuk ke endpoint putcustomer");
		String x = "";
		
		try {
			x = _obj.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(x);
		_service.updateCustomer(data);
		
		return "berhasil di put";
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletecustomer(@PathVariable("id") String id) {
		_logger.info("Masuk ke endpoint deletecustomer");
		String x = "";
		
		try {
			x = _obj.writeValueAsString(id);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(x);
		_service.deleteCustomer(id);
		
		return "berhasil di dedelete";
	}
}
