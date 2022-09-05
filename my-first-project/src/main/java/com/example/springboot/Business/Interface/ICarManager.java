package com.example.springboot.Business.Interface;

import java.util.List;

import com.example.springboot.*;

public interface ICarManager {
	public List<Car> GetCar();
	public Boolean Save(Car data);
}
