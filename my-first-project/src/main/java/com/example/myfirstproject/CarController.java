package com.example.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import business.logic.ICarManager;

@RestController
public class CarController {
	
	@Autowired
	ICarManager _CarMan;
	
	@GetMapping("/getCar2")
	public String getCar2() {
		var x = _CarMan.getAllCar();
		
		return x.get(2).getCarName();
	}
}
