package com.example.myfirstproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<car_0> getCar2() {
		var x = _CarMan.getAllCar();
		
		return x;
	}
	
	@PostMapping("/postcar")
	public String postcar(@RequestBody car_0 data) {
		var x = _CarMan.createCar(data);
		
		return x;
	}
	
	@PutMapping("/putcar")
	public String putcar(@RequestBody car_0 data) {
		var x = _CarMan.updateCar(data);
		
		return x;
	}
	
	@DeleteMapping("/deletecar")
	public String deletecar(@RequestBody car_0 data) {
		var x = _CarMan.deleteCar(data);
		
		return x;
	}
}
