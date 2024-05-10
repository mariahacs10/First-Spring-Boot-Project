package com.example.cardatabase.firstapp.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.firstapp.domain.Car;
import com.example.cardatabase.firstapp.model.CarRepository;

//@RestController annotation identifies that this class will be the controller
//for the RESTful web service
@RestController
@CrossOrigin("http://192.168.68.115:3000")

public class CarController {
	
	//To be able to return cars from the database, we have to inject CarRepository into the 
	//controller. Then, we can use the findAll() method that the repository provides to fetch 
	//all cars. Due to the @RestController annotation, the data is now serialized to JSON format 
	//in the response.
	private final CarRepository repository;
    public CarController(CarRepository repository) {
        this.repository = repository;
    }
	
	
	//@GetMapping annotation, defines the endpoint that the method is mapped to.
	//Now the getCars() method handels only GET requests from the /cars endpoint
	//because we are using the @GetMapping annotation. There are other annotations
	//for the different HTTP Methods such as @GetMapping, @PostMapping, @DeleteMapping
	//and so on.
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		//fetch and return cars
        return repository.findAll();
	}

}
