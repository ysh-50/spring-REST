package com.jspider.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	//ADD CAR
	@PostMapping(path="/car")
	public ResponseEntity<ResponseStructure<Car>> addCar(@RequestBody Car car){
		Car addedCar = carService.addCar(car);  //MCS
		
		ResponseStructure<Car> resposeStructure = new ResponseStructure<>();
		resposeStructure.setMessage("Car Added!");
		resposeStructure.setData(addedCar);
		resposeStructure.setStatus(HttpStatus.OK.value());   //to convert in int
		return new ResponseEntity<ResponseStructure<Car>>(resposeStructure, HttpStatus.OK);
		
	}
	
	//FIND ALL CARS
	@GetMapping(path="/cars")
	public ResponseEntity<ResponseStructure<List<Car>>> findAllCars(){
		List<Car> cars = carService.findAllCars();
		ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
		if (cars != null) {
			responseStructure.setMessage("Car found!");
			responseStructure.setData(cars);
			responseStructure.setStatus(HttpStatus.FOUND.value());       //convert in int
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.FOUND);
			
		}else {
			responseStructure.setMessage("Car not found!");
			responseStructure.setData(cars);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.NOT_FOUND);
		}
	}

}
