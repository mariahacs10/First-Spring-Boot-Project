package com.example.cardatabase.firstapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.
 AuthenticationException;
import org.springframework.security.web.
 AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class AuthEntryPoint implements AuthenticationEntryPoint{
	
	//implement the commence method, which gets an exception
	//as a parameter. In case of an exception, we set the response
	//status to 401 Unauthorized and write an exception message to the
	//response body

	 @Override
	  public void commence(
	    HttpServletRequest request, HttpServletResponse response,
	    AuthenticationException authException) throws IOException, 
	    ServletException {
	        response.setStatus (HttpServletResponse.SC_UNAUTHORIZED);
	        response.setContentType (MediaType.APPLICATION_JSON_VALUE);
	        PrintWriter writer = response.getWriter();
	        writer.println("Error: " + authException.getMessage());
	  }
	

}
