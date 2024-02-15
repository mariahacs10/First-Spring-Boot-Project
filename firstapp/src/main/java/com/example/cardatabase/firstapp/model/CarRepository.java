package com.example.cardatabase.firstapp.model;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cardatabase.firstapp.domain.Car;

/*Set up the CarRepositoryThe CarRepository interface in your Spring Boot project is 
similar to a DAO (Data Access Object) in Android.It provides access to database/persistence
operations for the Car entity. */
public interface CarRepository extends JpaRepository<Car,Long>  {

}
