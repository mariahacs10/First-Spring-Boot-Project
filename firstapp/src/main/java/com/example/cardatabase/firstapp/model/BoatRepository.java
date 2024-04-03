package com.example.cardatabase.firstapp.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardatabase.firstapp.domain.Boats;



public interface BoatRepository  extends JpaRepository<Boats,Long>{

}
