package com.example.cardatabase.firstapp.model;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardatabase.firstapp.domain.Owner;

//MAKE SURE!, you have Owner and NOT car its very similar to
//the car repository so make sure you dont get confused
public interface OwnerRepository extends JpaRepository<Owner,Long>{
}
