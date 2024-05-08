package com.example.cardatabase.firstapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cardatabase.firstapp.domain.Boats;
import com.example.cardatabase.firstapp.domain.Car;
import com.example.cardatabase.firstapp.model.BoatRepository;
import com.example.cardatabase.firstapp.model.CarRepository;

@Service
public class SearchService {
    private final CarRepository carRepository;
    private final BoatRepository boatRepository;

    public SearchService(CarRepository carRepository, BoatRepository boatRepository) {
        this.carRepository = carRepository;
        this.boatRepository = boatRepository;
    }

    public List<Car> searchCars(String brand, String model, String color, String registrationNumber,
            Integer modelYear, Integer price) {
	return carRepository.searchCars(brand, model, color, registrationNumber, modelYear, price);
	}

    public List<Boats> searchBoats(String boatBrand, String boatModel, String boatColor,
            Integer boatModelYear, Integer boatPrice) {
	return boatRepository.searchBoats(boatBrand, boatModel, boatColor, boatModelYear, boatPrice);
	}
    
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}