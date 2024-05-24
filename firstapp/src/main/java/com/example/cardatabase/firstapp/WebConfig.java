package com.example.cardatabase.firstapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//This annotation is used with Spring Framework to mark a class as a configuration class.
//It signifies that this class provides bean definitions for the application.
//@Configuration
//
////This annotation enables Cross-Origin Resource Sharing (CORS) for requests originating from the specified URL 
////(http://192.168.68.115:3000 in this case). 
//@CrossOrigin("http://192.168.68.114:3000")
////This interface provides methods for configuring various aspects of Spring MVC.
////This class, WebConfig, implements this interface to provide its own configurations.
//public class WebConfig implements WebMvcConfigurer {
//
//	 // This line comments out the @Override annotation
//	 // This annotation indicates that the following method is overriding
//	 // a method from the WebMvcConfigurer interface.
//	 @Override
//	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	     // This line is the  resource handling this method maps requests to static resources within the application.
//	      registry.addResourceHandler("/**")
//	             .addResourceLocations("classpath:/static/");
//	http://192.168.68.114:3000
//	 }
//}

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        		.allowedOrigins("https://react-carsandboats.onrender.com/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}