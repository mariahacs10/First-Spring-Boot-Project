package com.example.cardatabase.firstapp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cardatabase.firstapp.domain.AppUser;
import com.example.cardatabase.firstapp.domain.ArtWork;
import com.example.cardatabase.firstapp.domain.Boats;
import com.example.cardatabase.firstapp.domain.Car;
import com.example.cardatabase.firstapp.domain.Owner;
import com.example.cardatabase.firstapp.model.AppUserRepository;
import com.example.cardatabase.firstapp.model.ArtWorkRepository;
import com.example.cardatabase.firstapp.model.BoatRepository;
import com.example.cardatabase.firstapp.model.CarRepository;
import com.example.cardatabase.firstapp.model.OwnerRepository;
import com.example.cardatabase.firstapp.service.ApiKeyService;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;


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
	private final BoatRepository boatrepository;
	private final ArtWorkRepository artWorkRepository;

	//Finally, we can save a couple of test users to the database using the CommandLineRunner 
	//interface.
	private final AppUserRepository urepository;
	
    private final ApiKeyService apiKeyService;
   
    
	public FirstappApplication(CarRepository repository, OwnerRepository orepository, ApiKeyService apiKeyService, BoatRepository boatrepository,
			AppUserRepository urepository,
			ArtWorkRepository artWorkRepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.boatrepository = boatrepository;
		this.urepository = urepository;
		this.apiKeyService = apiKeyService;
		this.artWorkRepository = artWorkRepository;
	}
	
	
	public static void main(String[] args) {
		Dotenv.load();
		
		SpringApplication.run(FirstappApplication.class, args);
	}
	
	@PostConstruct
	 public void initApiKeys() {
	      String apiKey = apiKeyService.generateArtworkApiKey();
	      System.out.println("Generated ART api key: " + apiKey);
	      
	      String apiKey2 = apiKeyService.generateApiKey();
	      System.out.println("Generated API key: " + apiKey2);
	 }
	 
    // FirstappApplication.java run method
	@Override
	public void run(String... args) throws Exception {
		
		//Modify the run method to save owners and link owners and cars
		Owner owner1 = new Owner("Satoru", "Gojo");
		Owner owner2 = new Owner("Megumi", "Fushiguro");
	    orepository.saveAll(Arrays.asList(owner1, owner2));
	    
	    /**API IMAGES */
		
	    String imageUrlFord =   "https://i.ibb.co/gwrm4wb/fordmustang.jpg";
	    String imageUrlNissan = "https://i.ibb.co/VWSBKht/nissanleafwhite.jpg";
	    String imageUrlToyota = "https://i.ibb.co/BKWCchF/toyotapriussilver.jpg";
	    String imageUrlBmw7Series = "https://i.ibb.co/wN6yT9z/bmw7series.jpg";
	    String imageUrlHondaCivicEX = "https://i.ibb.co/8MZLMRJ/hondacivic-EX.jpg";
	    String imageUrlMercedesBENZ = "https://i.ibb.co/ZNbWDTH/mercedes-BENZ.jpg";
	    String imageUrlTeslaModelS = "https://i.ibb.co/Vp6hdxK/tesla-Model-S.jpg";
	    String imageUrlVolkswagenID = "https://i.ibb.co/rb9h2tR/volkswagen-ID.jpg";
	    
	    
	    String imageUrlSeaDancer = "https://i.postimg.cc/CLsSxJyL/searaysundancer.jpg";
	    String imageUrlBoston = "https://i.postimg.cc/GhkWj7Ds/bostonwhaler.jpg";
	    String imageUrlChaparral = "https://i.postimg.cc/W1TQYGmY/chaparral.jpg";
	    
	    String imageUrlAzimut = "https://i.ibb.co/RpX9Fdb/azimut.jpg";
	    String imageUrlBertram = "https://i.ibb.co/MfQVp8Q/bertram.jpg";
	    String imageUrlCruiserYatch = "https://i.ibb.co/7YpTRH2/cruiser-Yatch.jpg";
	    String imageUrlEverGlades = "https://i.ibb.co/kHGLRXZ/everglades.jpg";
	    String imageUrlMalibu = "https://i.ibb.co/Dp0m12C/malibu.jpg";
	    
	    
	    String jjkImage1 = "https://i.postimg.cc/3rtbd3v4/jjkimage1.jpg";
	    String jjkImage2 = "https://i.postimg.cc/MKX3Bg7s/jjkimage2.jpg";
	    String jjkImage3 = "https://i.postimg.cc/m2qXyVVT/jjkimage3.jpg";
	    String jjkImage4 = "https://i.postimg.cc/pLF0G81z/jjkimage4.jpg";
	    String jjkImage5 = "https://i.postimg.cc/g0bgfJf5/jjkimage5.jpg";
	    String jjkImage6 = "https://i.postimg.cc/NMgpjnGk/jjkimage6.jpg";
	    String jjkImage7 = "https://i.postimg.cc/3Rn94Zd5/jjkimage7.jpg";
	    String jjkImage8 = "https://i.postimg.cc/ZnnHryd9/jjkimage8.jpg";
	    String jjkImage9 = "https://i.postimg.cc/nLK3ZxxL/jjkimage9.jpg";
	    String jjkImage10 = "https://i.postimg.cc/X7ZxqdWm/jjkimage10.jpg";
	    String jjkImage11 = "https://i.postimg.cc/ZYsVJjG6/jjkimage11.jpg";
	    String jjkImage12 = "https://i.postimg.cc/1XdHM5Gv/jjkimage12.jpg";
	    String jjkImage13 = "https://i.postimg.cc/c4VhnC4H/jjkimage13.jpg";
		
		
	   repository.save(new Car("Ford", "Mustang", "Red","ADF-1121", 2023, 59000, imageUrlFord, owner2));
	   repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, imageUrlNissan, owner1));
       repository.save(new Car("Toyota", "Prius","Silver", "KKO-0212", 2022, 39000, imageUrlToyota, owner1));
       repository.save(new Car("BMW", "7 Series","Alpine White", "BMW789", 2024, 95000, imageUrlBmw7Series, owner2));
       repository.save(new Car("Honda", "Civic EX", "Modern Steel Metallic", "HONDA012", 2021, 25000, imageUrlHondaCivicEX, owner2)); 
       repository.save(new Car("Mercedes-Benz", "E-Class","Obsidian Black", "MBZ345", 2023, 70000, imageUrlMercedesBENZ, owner1));
       repository.save(new Car("Tesla", "Model S","Midnight Blue", "TSLA123", 2023, 85000, imageUrlTeslaModelS, owner1));
       repository.save(new Car("Volkswagen", "ID.4","Manganese Gray Metallic", "VW005", 2024, 39900, imageUrlVolkswagenID, owner1));
       
       
       boatrepository.save(new Boats("Sea Ray Sundancer 350 Coupe Brand", "Sea Ray", "White", 2023, 600000, imageUrlSeaDancer));
       boatrepository.save(new Boats("Boston Whaler 320 Vantage", "Boston Whaler", "White", 2022, 450000 , imageUrlBoston));
       boatrepository.save(new Boats("Chaparral 337 SSX", "Chaparral", "Navy", 2021, 400000 , imageUrlChaparral));
       boatrepository.save(new Boats("Azimut", "Magellano 25 METRI", "Blue-White", 2021, 400000 , imageUrlAzimut));
       boatrepository.save(new Boats("Bertram", "39CC", "White", 2023, 89990000 , imageUrlBertram));
       boatrepository.save(new Boats("Cruisers yachts", "42 GLS outboard", "black", 2023, 161954700 , imageUrlCruiserYatch));
       boatrepository.save(new Boats("Everglades", "Everglades", "blue", 2024, 90000, imageUrlEverGlades));
       boatrepository.save(new Boats("Malibu", "M-SERIES M240", "red", 2022, 184995 , imageUrlMalibu));
       
       
       
       artWorkRepository.save(new ArtWork("Erika Allen", "Gojo", "blank", jjkImage1));
       artWorkRepository.save(new ArtWork("Erika Allen", "Gojo", "blank", jjkImage2));
       artWorkRepository.save(new ArtWork("Erika Allen", "Sukuna", "blank", jjkImage3));
       artWorkRepository.save(new ArtWork("Erika Allen", "Sukuna", "blank", jjkImage4));
       artWorkRepository.save(new ArtWork("Erika Allen", "Yuji", "blank", jjkImage5));
       artWorkRepository.save(new ArtWork("Erika Allen", "Yuji", "blank", jjkImage6));
       artWorkRepository.save(new ArtWork("Erika Allen", "Megumi Sukuna", "blank", jjkImage7));
       artWorkRepository.save(new ArtWork("Erika Allen", "Yuji", "blank", jjkImage8));
       artWorkRepository.save(new ArtWork("Erika Allen", "Gojo", "blank", jjkImage9));
       artWorkRepository.save(new ArtWork("Erika Allen", "Yuji/Megumi", "blank", jjkImage10));
       artWorkRepository.save(new ArtWork("Erika Allen", "Megumi", "blank", jjkImage11));
       artWorkRepository.save(new ArtWork("Erika Allen", "Toji", "blank", jjkImage12));
       artWorkRepository.save(new ArtWork("Erika Allen", "Toji", "blank", jjkImage13));
       
       
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
