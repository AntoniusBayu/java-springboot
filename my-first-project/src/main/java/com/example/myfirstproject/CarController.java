package com.example.myfirstproject;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import business.logic.ICarManager;
import dataaccess.model.car_0;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
	private static final Logger _logger = Logger.getLogger(CarController.class.getName());
	private ObjectMapper _obj = new ObjectMapper();
	@Autowired
	ICarManager _CarMan;
	
	@GetMapping("/getCar2")
	public List<car_0> getCar2() {
		_logger.info("Masuk ke endpoint getCar2");
		var x = _CarMan.getAllCar();
		
		return x;
	}
	
	@PostMapping("/postcar")
	public String postcar(@RequestBody car_0 data) {
		_logger.info("Masuk ke endpoint postcar");
		String y = "";
		
		try {
			y = _obj.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(y);
		var x = _CarMan.createCar(data);
		
		return x;
	}
	
	@PutMapping("/putcar")
	public String putcar(@RequestBody car_0 data) {
		_logger.info("Masuk ke endpoint putcar");
		String y = "";
		
		try {
			y = _obj.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(y);
		var x = _CarMan.updateCar(data);
		
		return x;
	}
	
	@DeleteMapping("/deletecar")
	public String deletecar(@RequestBody car_0 data) {
		_logger.info("Masuk ke endpoint deletecar");
		String y = "";
		
		try {
			y = _obj.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		_logger.info(y);
		var x = _CarMan.deleteCar(data);
		
		return x;
	}
}
