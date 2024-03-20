package com.example.cardatabase.firstapp.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cardatabase.firstapp.domain.AppUser;
import com.example.cardatabase.firstapp.model.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	//We have to inject the AppUserRepository class into the UserDetailsServiceImpl class 
	//because it is needed to fetch the user from the database when Spring Security handles au
	//the authentication.
	private final AppUserRepository repository;
 
public UserDetailsServiceImpl(AppUserRepository repository) {
   this.repository = repository;
}
   @Override
   //The loadUserByUsername method returns the UserDetails object, which is required for authentication. We are using 
   //the Spring Security UserBuilder class to build the user for the authentication.
   public UserDetails loadUserByUsername(String username) throws
   UsernameNotFoundException {
	   //The findByUsername method that we implemented earlier returns Optional, 
	   //therefore we can use the isPresent() method to check if the user exists. If the user doesn’t 
	   //exist, we throw a UsernameNotFoundException exception. 
       Optional<AppUser> user = repository.findByUsername(username);
       UserBuilder builder = null;
       if (user.isPresent()) {
           AppUser currentUser = user.get();
           builder = org.springframework.security.core.userdetails.
                     User.withUsername(username);
           builder.password(currentUser.getPassword());
           builder.roles(currentUser.getRole());
       } else {
           throw new UsernameNotFoundException("User not found.");
       }
       return builder.build();
   }
}