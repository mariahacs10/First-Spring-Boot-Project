package com.example.cardatabase.firstapp.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardatabase.firstapp.domain.ArtWork;

public interface ArtWorkRepository extends JpaRepository<ArtWork,Long>{

}
