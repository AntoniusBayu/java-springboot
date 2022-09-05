package com.example.springboot.repository;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.example.springboot.*;

public class CarRepository {
	public List<Car> GetListCar()
	{
		List<Car> _car = new ArrayList<Car>();
		
		Instant _now = Instant.now();
		
		Car _car1 = new Car();
		_car1.setCarID(1);
		_car1.setCarName("Test Nih");
		_car1.setCreatedDate(_now);
		_car1.setCreatedDateUS(_now.atZone(ZoneId.of("America/Sao_Paulo")));
		_car1.setIsActive(true);
		_car.add(_car1);
		
		Car _car2 = new Car();
		_car2.setCarID(2);
		_car2.setCarName("Test Nih 2");
		_car2.setCreatedDate(_now);
		_car2.setCreatedDateUS(_now.atZone(ZoneId.of("America/Sao_Paulo")));
		_car2.setIsActive(true);
		_car.add(_car2);
		
		Car _car3 = new Car();
		_car3.setCarID(3);
		_car3.setCarName("Test Nih 3");
		_car3.setCreatedDate(_now);
		_car3.setCreatedDateUS(_now.atZone(ZoneId.of("America/Sao_Paulo")));
		_car3.setIsActive(false);
		_car.add(_car3);
		
		Car _car4 = new Car(4,"Test Nih 4",_now,_now.atZone(ZoneId.of("America/Sao_Paulo")), true);
		_car.add(_car4);
		
		return _car;
	}
	
	public Boolean SaveCar(Car data)
	{
		try {
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
}
