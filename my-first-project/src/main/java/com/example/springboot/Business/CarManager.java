package com.example.springboot.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.springboot.*;
import com.example.springboot.repository.*;
import com.example.springboot.Business.Interface.*;

@Service
@Transactional
public class CarManager implements ICarManager{

	CarRepository _repo = null;
	
	public CarManager()
	{
		this._repo = new CarRepository();
	}
	
	@Override
	public List<Car> GetCar() {
		return _repo.GetListCar();
	}

	@Override
	public Boolean Save(Car data) {
		return _repo.SaveCar(data);
	}

}
