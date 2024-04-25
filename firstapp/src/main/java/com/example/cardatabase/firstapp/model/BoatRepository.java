package com.example.cardatabase.firstapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cardatabase.firstapp.domain.Boats;



public interface BoatRepository  extends JpaRepository<Boats,Long>{
	 @Query("SELECT b FROM Boats b WHERE " +
	            "(:boatBrand IS NULL OR LOWER(b.boatBrand) LIKE LOWER(CONCAT('%', :boatBrand, '%'))) AND " +
	            "(:boatModel IS NULL OR LOWER(b.boatModel) LIKE LOWER(CONCAT('%', :boatModel, '%'))) AND " +
	            "(:boatColor IS NULL OR LOWER(b.boatColor) LIKE LOWER(CONCAT('%', :boatColor, '%'))) AND " +
	            "(:boatModelYear IS NULL OR b.boatModelYear = :boatModelYear) AND " +
	            "(:boatPrice IS NULL OR b.boatPrice = :boatPrice)")
	    List<Boats> searchBoats(@Param("boatBrand") String boatBrand,
	                            @Param("boatModel") String boatModel,
	                            @Param("boatColor") String boatColor,
	                            @Param("boatModelYear") Integer boatModelYear,
	                            @Param("boatPrice") Integer boatPrice);
}
