package com.jspider.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springrest.pojo.Car;
import com.jspider.springrest.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired                     //dependency
	private CarRepository carRepository;
	
	
	//method
	public Car addCar(Car car) {
		return carRepository.addCar(car);      //MCS
	}

}
