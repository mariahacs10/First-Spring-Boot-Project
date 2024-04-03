package com.example.cardatabase.firstapp;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.cardatabase.firstapp.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.cardatabase.firstapp.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//The AuthenticationFilter class extends Spring securitys onceperrequestfilter interface,
//which provides a doFilterInternal method where we implement our authentication.\
@Component
public class AuthenticationFilter extends OncePerRequestFilter{
	
	//We have to inject a JWTservice instance into the filter class because it is
	//needed to verify a token from the requesxt.
	private final JwtService jwtService;
	
	public AuthenticationFilter(JwtService jwtService)
	{
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get token form the Authorization header
		String jws = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(jws != null)
		{
			//Verify token and get user
			String user = jwtService.getAuthUser(request);
			
			//Authenticate
			Authentication authentication = new UsernamePasswordAuthenticationToken(user,null,java.util.Collections.emptyList());
			
			//The SecurityContentHolder is wqhere spring security stores the details of the
			//authenticaed user.
			 SecurityContextHolder.getContext()
             .setAuthentication(authentication);
			
		}
        filterChain.doFilter(request, response);

		
	}

}
