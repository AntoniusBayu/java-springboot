package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.customer;

@Repository
public interface CustomerRepository extends JpaRepository<customer, String>{

}
