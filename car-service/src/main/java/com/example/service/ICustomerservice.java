package com.example.service;

import com.example.model.customer;

public interface ICustomerservice {
	customer GetFirstCustomer();
	void saveCustomer(customer data);
	void updateCustomer(customer data);
	void deleteCustomer(String id);
}
