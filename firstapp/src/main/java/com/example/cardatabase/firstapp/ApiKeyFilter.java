package com.example.cardatabase.firstapp;

import java.io.IOException;
import java.util.Collections;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.cardatabase.firstapp.service.ApiKeyService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//This declares the ApiKeyFilter class as a spring component,
//which means it will be managed by the Spring container
@Component
//The class extends OncePerRequestFilter, which is a base class provided by
//spring Security for implementing filters that should execute once per request
public class ApiKeyFilter extends OncePerRequestFilter {
	//This line declares a private final instance variable of type
	//ApiKeyService. It will be used to access the methods for generating
	//and validating apikeys
    private final ApiKeyService apiKeyService;

    //This line creates a static logger instance using the LoggerFactory from
    //the SLF4J logging framework. the logger will be used to log messages
    //related to the ApiKeyFilter class
    private static final Logger log = (Logger) LoggerFactory.getLogger(ApiKeyFilter.class);
    //This line declares a constant APIKEYPARAM that holds the name of the request
    //parameter used to pass the apikey
    private static final String API_KEY_PARAM = "apiKey";

    public ApiKeyFilter(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    //This method overrides the doFilterInternal method from the 
    //OncePerRequestFilter class. It is the Main method that will be executed
    //for each incomming request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	
    	//this line retrieves the value of the request parameter with the name
    	//specified by APIKEYPARAM and assigns it to the apikey variable
        String apiKey = request.getParameter(API_KEY_PARAM);
        log.info("Received API key: {}", apiKey);

        //This block checks if the apiKey variable is not null and
        //not an empty string. If the condition is true, it proceeds to the
        //next step; otherwise, it skips to the end of the method.
        if (apiKey != null && !apiKey.isEmpty()) {
        	//This block checks if the incoming request is for the Artwork 
        	//entity by calling the isArtworkRequest method.
            if (isArtworkRequest(request)) {
            	//If it is an Artwork request, it calls the validateArtworkApiKey method
            	//from the ApiKeyService to validate the provided API key.
                if (apiKeyService.validateArtworkApiKey(apiKey)) {
                	//If the API key is valid, it calls the setAuthentication
                	//method to set the appropriate authentication in the SecurityContext,
                	//and then calls filterChain.doFilter to continue processing the request.
                    setAuthentication(apiKey);
                    filterChain.doFilter(request, response);
                    return;
                }
            } else {
                if (apiKeyService.validateApiKey(apiKey)) {
                    setAuthentication(apiKey);
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        //If the API key is not valid (either for Artwork or other entities), these lines set the response status code to 401 (Unauthorized)
        //and write the message "Invalid API key." to the response body.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Invalid API key.");
    }

    //This is a private helper method that checks if the incoming request is for the
    //Artwork entity by examining the request URL. If the URL starts
    //with "/artwork", it returns true; otherwise, it returns false.
    private boolean isArtworkRequest(HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        return requestUrl.startsWith("/artWork");
    }

    private void setAuthentication(String apiKey) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(apiKey, null, Collections.singletonList(new SimpleGrantedAuthority("apiKey")));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}