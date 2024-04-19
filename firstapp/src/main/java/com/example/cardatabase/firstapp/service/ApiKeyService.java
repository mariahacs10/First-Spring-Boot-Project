package com.example.cardatabase.firstapp.service;

import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {
   //private static final Logger log = LoggerFactory.getLogger(ApiKeyService.class);
	
	//this is getting the information form the .env file
	public static final String API_KEY = System.getenv("API_KEY");

	public static final String ART_API_KEY = System.getenv("ARTWORK_API_KEY");

	//This is the method to generate the api key
    public String generateApiKey() {
    	return API_KEY;
    }

    //this is the method to generate the artwork api key
    public String generateArtworkApiKey() {
        return ART_API_KEY;
    }

    //this is the method to validate the api key
    public boolean validateApiKey(String apiKey) {
        return API_KEY.contains(apiKey);
    }

    //this is the method to validate the artworkapikey
    public boolean validateArtworkApiKey(String apiKey) {
        return ART_API_KEY.contains(apiKey);
    }
}