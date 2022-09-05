package com.example.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.logic.ICarManager;
import dataaccess.model.car_0;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
	
	@Autowired
	ICarManager _CarMan;
	
	@GetMapping("/getCar2")
	public String getCar2() {
		var x = _CarMan.getAllCar();
		
		return x.get(0).getCarname();
	}
	
	@PostMapping("/postcar")
	public String postcar(@RequestBody car_0 data) {
		data.setCarname("Anjay");
		data.setIsactive(true);
		var x = _CarMan.createCar(data);
		
		return x;
	}
}
