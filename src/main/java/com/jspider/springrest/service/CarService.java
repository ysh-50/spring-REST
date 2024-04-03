package com.jspider.springrest.service;

import java.util.List;

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
	
	//method
	public List<Car> findAllCars(){
		List<Car> cars = carRepository.findAllCars();
		if (cars != null && cars.size() > 0) {
			return cars;
		}else {
			return null;
		}
	}

}
