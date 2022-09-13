package com.example.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consumer.model.customer;
import com.example.consumer.repo.customerRepository;

@Service
public class CustomerService implements ICustomer {

	@Autowired
	private customerRepository repo;
	@Override
	public void saveCustomer(customer data) {
		repo.save(data);
	}

}
