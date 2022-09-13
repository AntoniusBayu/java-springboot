package com.example.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.consumer.model.customer;


@Repository
public interface customerRepository extends JpaRepository<customer, String>{

}
