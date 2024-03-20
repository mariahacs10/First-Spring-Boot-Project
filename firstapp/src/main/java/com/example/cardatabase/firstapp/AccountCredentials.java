package com.example.cardatabase.firstapp;

// The record has two fields: username and password. we dont have to write
//getters and setters when using it.
public record AccountCredentials(String username, String password) {

}
