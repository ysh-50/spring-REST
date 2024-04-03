package com.jspider.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.springrest.pojo.Car;
import com.jspider.springrest.response.ResponseStructure;
import com.jspider.springrest.service.CarService;

@RestController
public class CarController {
	
	@Autowired                       //dependency
	private CarService carService;
	
	
	//add car
	@PostMapping(path="/car")
	public ResponseEntity<ResponseStructure<Car>> addCar(@RequestBody Car car){
		Car addedCar = carService.addCar(car);  //MCS
		
		ResponseStructure<Car> resposeStructure = new ResponseStructure<>();
		resposeStructure.setMessage("Car Added!");
		resposeStructure.setData(addedCar);
		resposeStructure.setStatus(HttpStatus.OK.value());   //to convert in int
		return new ResponseEntity<ResponseStructure<Car>>(resposeStructure, HttpStatus.OK);
		
		
		
	}

}
