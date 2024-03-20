package com.example.cardatabase.firstapp.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
