package com.example.cardatabase.firstapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.firstapp.domain.ArtWork;
import com.example.cardatabase.firstapp.model.ArtWorkRepository;

@RestController
@CrossOrigin("http://192.168.68.115:3000")
public class ArtWorkController {
	
	private final ArtWorkRepository repository;
    
    public ArtWorkController(ArtWorkRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/artWork")
	public Iterable<ArtWork> getArtWork(){
		//fetch and return cars
        return repository.findAll();
	}
    
}
