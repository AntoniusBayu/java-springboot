package com.example.controller;

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
import com.example.model.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	@Autowired
	ICustomerservice _service;
	
	@GetMapping("/customer")
	public String customer() {
		return "Hello Customer";
	}
	
	@GetMapping("/helloworld")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping("/getcustomer")
	public String getcustomer() {
		var x = _service.GetFirstCustomer();
		
		return x.getCustomername();
	}
	
	@PostMapping("/postcustomer")
	public String postcustomer(@RequestBody customer data) {
		_service.saveCustomer(data);
		
		return "berhasil di post";
	}
	
	@PutMapping("/putcustomer")
	public String putcustomer(@RequestBody customer data) {
		_service.updateCustomer(data);
		
		return "berhasil di put";
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletecustomer(@PathVariable("id") String id) {
		_service.deleteCustomer(id);
		
		return "berhasil di dedelete";
	}
}
