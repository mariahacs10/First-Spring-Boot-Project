package com.example.cardatabase.firstapp.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.cardatabase.firstapp.domain.Car;

/*Set up the CarRepositoryThe CarRepository interface in your Spring Boot project is 
similar to a DAO (Data Access Object) in Android.It provides access to database/persistence
operations for the Car entity. */
@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long>  {
	
	 // Fetch cars by brand
	 List<Car> findByBrand(@Param("brand") String brand);
	 // Fetch cars by color
	 List<Car> findByColor(@Param("color") String color);
	 
	 @Query("SELECT c FROM Car c WHERE " +
	            "(:brand IS NULL OR LOWER(c.brand) LIKE LOWER(CONCAT('%', :brand, '%'))) AND " +
	            "(:model IS NULL OR LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%'))) AND " +
	            "(:color IS NULL OR LOWER(c.color) LIKE LOWER(CONCAT('%', :color, '%'))) AND " +
	            "(:registrationNumber IS NULL OR LOWER(c.registrationNumber) LIKE LOWER(CONCAT('%', :registrationNumber, '%'))) AND " +
	            "(:modelYear IS NULL OR c.modelYear = :modelYear) AND " +
	            "(:price IS NULL OR c.price = :price)")
	    List<Car> searchCars(@Param("brand") String brand,
	                         @Param("model") String model,
	                         @Param("color") String color,
	                         @Param("registrationNumber") String registrationNumber,
	                         @Param("modelYear") Integer modelYear,
	                         @Param("price") Integer price);
}
