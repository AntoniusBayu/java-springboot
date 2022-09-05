package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerRepository;
import com.example.model.customer;

@Service
@Transactional
public class customerservice implements ICustomerservice {

	@Autowired
	private CustomerRepository repo;
	@Override
	public customer GetFirstCustomer() {
		var x = repo.findAll();
		return x.get(0);
	}
	@Override
	public void saveCustomer(customer data) {
		repo.save(data);
	}
	@Override
	public void updateCustomer(customer data) {
		repo.save(data);
		
	}
	@Override
	public void deleteCustomer(String id) {
		repo.deleteById(id);
	}

}
