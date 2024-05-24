package com.example.cardatabase.firstapp.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.firstapp.domain.Boats;
import com.example.cardatabase.firstapp.model.BoatRepository;

@RestController
//@CrossOrigin("http://192.168.68.114:3000")
@CrossOrigin("https://react-carsandboats.onrender.com/")
public class BoatController {
	
	private final BoatRepository repository;
	public BoatController(BoatRepository repository) {
	      this.repository = repository;
	}
		

	@GetMapping("/boats")
	public Iterable<Boats> getBoats(){
		//fetch and return cars
      return repository.findAll();
	}

}