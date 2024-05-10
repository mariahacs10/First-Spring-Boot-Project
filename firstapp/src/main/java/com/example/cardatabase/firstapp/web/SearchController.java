package com.example.cardatabase.firstapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.firstapp.domain.Boats;
import com.example.cardatabase.firstapp.domain.Car;
import com.example.cardatabase.firstapp.service.SearchService;

@RestController
@RequestMapping("/api/search")
@CrossOrigin("http://192.168.68.115:3000")

public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/cars")
    public List<Car> searchCars(@RequestParam(value = "brand", required = false) String brand,
                                 @RequestParam(value = "model", required = false) String model,
                                 @RequestParam(value = "color", required = false) String color,
                                 @RequestParam(value = "registrationNumber", required = false) String registrationNumber,
                                 @RequestParam(value = "modelYear", required = false) Integer modelYear,
                                 @RequestParam(value = "price", required = false) Integer price) {
        if (brand == null && model == null && color == null && registrationNumber == null && modelYear == null && price == null) {
            // No parameters provided, return all cars
            return searchService.getAllCars();
        } else {
            return searchService.searchCars(brand, model, color, registrationNumber, modelYear, price);
        }
    }

    @GetMapping("/boats")
    public List<Boats> searchBoats(@RequestParam(value = "boatBrand", required = false) String boatBrand,
                                   @RequestParam(value = "boatModel", required = false) String boatModel,
                                   @RequestParam(value = "boatColor", required = false) String boatColor,
                                   @RequestParam(value = "boatModelYear", required = false) Integer boatModelYear,
                                   @RequestParam(value = "boatPrice", required = false) Integer boatPrice) {
        return searchService.searchBoats(boatBrand, boatModel, boatColor, boatModelYear, boatPrice);
    }
}