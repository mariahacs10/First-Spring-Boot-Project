package com.example.cardatabase.firstapp;

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

import com.example.cardatabase.firstapp.service.UserDetailsServiceImpl;
import java.util.Arrays;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;

//The @Configuration and @EnableWebSecurity annotations switch off the default web se
//curity configuration, and we can define our own configuration in this class. Inside the 
//filterChain(HttpSecurity http) method that we will see in action later, we can define which 
//endpoints in our application are secure and which are not. We don’t actually need this method 
//yet because we can use the default settings where all the endpoints are secured.

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
   private final UserDetailsServiceImpl userDetailsService;
   private final AuthenticationFilter authenticationFilter;
   
   //Then we have to configure Spring Security for the exception handling.
   //Inject our AuthEntryPoint class into the SecurityConfig class
   private final AuthEntryPoint exceptionHandler;

   
   public SecurityConfig(UserDetailsServiceImpl userDetailsService,AuthenticationFilter authenticationFilter, AuthEntryPoint exceptionHandler) {
		  this.userDetailsService = userDetailsService;
		  this.authenticationFilter = authenticationFilter;
		  this.exceptionHandler = exceptionHandler;
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
   public AuthenticationManager uthenticationManager(
     AuthenticationConfiguration authConfig) throws Exception {
       return authConfig.getAuthenticationManager();
   }
   
   
  
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws  
    Exception {
      http.csrf((csrf) -> csrf.disable())
      	
          .sessionManagement((sessionManagement) -> sessionManagement. 
              sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .authorizeHttpRequests((authorizeHttpRequests) -> 
              authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated())
          .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
      http.exceptionHandling((exceptionHandling) -> exceptionHandling. 
                  authenticationEntryPoint(exceptionHandler))
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
