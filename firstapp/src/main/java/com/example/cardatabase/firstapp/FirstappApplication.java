package com.example.cardatabase.firstapp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cardatabase.firstapp.domain.AppUser;
import com.example.cardatabase.firstapp.domain.Car;
import com.example.cardatabase.firstapp.domain.Owner;
import com.example.cardatabase.firstapp.model.AppUserRepository;
import com.example.cardatabase.firstapp.model.CarRepository;
import com.example.cardatabase.firstapp.model.OwnerRepository;


/*The CommandLineRunner interface allows us to execute additional code before
 * the application has fully started. Therefore it is a good point to add
 * demo data to your database. 
 *
 * Your Spring boot applications main class implements the commandLinerunnger
 * interface. therefore we should implement the run method as shown in the following
 * FirstAppApplication.java code
*/
@SpringBootApplication
public class FirstappApplication implements CommandLineRunner
{
	/*We have to inject our cap repository into the main class to be able
	 * to save new car objects to the database. We use constructor injection to
	 * CarRepository. We will also adda logger*/
	private static final Logger logger = 
			LoggerFactory.getLogger(FirstappApplication.class);

	private final CarRepository repository;
	private final OwnerRepository orepository;
	//Finally, we can save a couple of test users to the database using the CommandLineRunner 
	//interface.
	private final AppUserRepository urepository;

	
	public FirstappApplication(CarRepository repository, OwnerRepository orepository, AppUserRepository urepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(FirstappApplication.class, args);
	}
	
	
    // FirstappApplication.java run method
	@Override
	public void run(String... args) throws Exception {
		
		//Modify the run method to save owners and link owners and cars
		Owner owner1 = new Owner("Satoru", "Gojo");
		Owner owner2 = new Owner("Megumi", "Fushiguro");
	    orepository.saveAll(Arrays.asList(owner1, owner2));
		
	    String imageUrlFord =   "https://drive.google.com/file/d/1_MSnH0c7VRorEN1DYDk9ZmXIdPazi77X/view";
	    String imageUrlNissan = "https://drive.google.com/file/d/1Zro7ZhMXywjv8pmzjVY53yL4619ZYKNL/view";
	    String imageUrlToyota = "https://drive.google.com/file/d/19FvfUyJ1ucPwqeUAw9lG1pVOkd1-vVgA/view";
		
		
		//this saves the newly created car objects to the repository
		//the spring data jpa repository that can save entites
		repository.save(new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2023, 59000, imageUrlFord, owner2));
		//like this one this saves the newly created car objects to the repository
		//the spring data jpa repository that can save entites
		 repository.save(new Car("Nissan", "Leaf", "White",
                 "SSJ-3002", 2020, 29000, imageUrlNissan, owner1));
	   //And this One saves the newly created car objects to the repository
			//the spring data jpa repository that can save entites	 
       repository.save(new Car("Toyota", "Prius",
                 "Silver", "KKO-0212", 2022, 39000, imageUrlToyota, owner1));
         
       //fetch all cars and log to console
       for(Car car : repository.findAll())
       {
    	   logger.info("brand: {}, model: {}",
                   car.getBrand(), car.getModel());
       }
       
       //Let’s save two users to the database with bcrypt hashed passwords. You can find bcrypt 
       // calculators or generators on the internet. These generators allow you to input a plaintext 
       //password, and they will produce the corresponding bcrypt hash
   
       urepository.save(new AppUser("user", 
               "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
       
       // Username: admin, password: admin
       urepository.save(new AppUser("admin", 
           "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
		
	}
	
}
