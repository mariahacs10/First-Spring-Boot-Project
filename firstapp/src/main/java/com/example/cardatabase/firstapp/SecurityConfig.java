package com.example.cardatabase.firstapp;


import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.
 EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.cardatabase.firstapp.service.UserDetailsServiceImpl;

//The @Configuration and @EnableWebSecurity annotations switch off the default web se
//curity configuration, and we can define our own configuration in this class. Inside the 
//filterChain(HttpSecurity http) method that we will see in action later, we can define which 
//endpoints in our application are secure and which are not. We don’t actually need this method 
//yet because we can use the default settings where all the endpoints are secured.
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
   private final UserDetailsServiceImpl userDetailsService;
 
   private final ApiKeyFilter apiKeyFilter;
   
   public SecurityConfig(UserDetailsServiceImpl userDetailsService, ApiKeyFilter apiKeyFilter) {
		  this.userDetailsService = userDetailsService;
	      this.apiKeyFilter = apiKeyFilter;
   }

   
   // Delete the userDetailsService() method 
   //from the SecurityConfig class to disable in-memory users. Add a new configureGlobal 
   // method to enable users from the database
   public void configureGlobal (AuthenticationManagerBuilder auth)
	throws Exception {
	     auth.userDetailsService(userDetailsService)
	     .passwordEncoder(new BCryptPasswordEncoder());
   }
   
   // Now, the password must be hashed using bcrypt before it’s saved to the database.
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   
   @Bean
   public AuthenticationManager authenticationManager(
     AuthenticationConfiguration authConfig) throws Exception {
       return authConfig.getAuthenticationManager();
   }
  
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.csrf((csrf) -> csrf.disable())
           .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .addFilterAfter(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
           .authorizeHttpRequests((authorizeHttpRequests) ->
               authorizeHttpRequests
                   .requestMatchers("/cars/**", "/boats/**").hasAuthority("apiKey")
                   .requestMatchers("/artWork/**").hasAnyAuthority("apiKey")
                   .requestMatchers("/api/search/**").permitAll() // Add this line to allow public access
                   .anyRequest().authenticated())
           .cors(withDefaults());

       return http.build();
   }
   
   
   
   // Define the CorsConfigurationSource bean
   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Arrays.asList("*"));
	    config.setAllowedMethods(Arrays.asList("*"));
	    config.setAllowedHeaders(Arrays.asList("*"));
	    config.setAllowCredentials(false);
	    config.applyPermitDefaultValues();
	
	    source.registerCorsConfiguration("/**", config);
	    return source;
   }
  
}
