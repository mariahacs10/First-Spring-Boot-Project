package com.example.cardatabase.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Boat")
public class Boats {
		
		@Id
		@GeneratedValue
		private Long boatId;
		private String boatBrand;
		private String boatModel;
		private String boatColor;
		private int boatModelYear;
		private int boatPrice;
		
	    private String boatImageUrl; 
		
		public Boats(String boatBrand, String boatModel, String boatColor, int boatModelYear, int boatPrice, String boatImageUrl)
		{
			this.boatBrand = boatBrand;
			this.boatModel = boatModel;
			this.boatColor = boatColor;
			this.boatModelYear = boatModelYear;
			this.boatPrice = boatPrice;
			this.boatImageUrl = boatImageUrl;	
		}
		
		public Long getBoatId()
		{
			return boatId;
		}
		
		public void setBoatId(Long boatId)
		{
			this.boatId = boatId;
		}
		
		public String getBoatBrand()
		{
			return boatBrand;
		}
		
		public void setBoatBrand(String boatBrand)
		{
			this.boatBrand = boatBrand;
		}
		
		public String getBoatModel()
		{
			return boatModel;
		}
		
		public void setBoatModel(String boatModel)
		{
			this.boatModel = boatModel;
		}
		
		public String getBoatColor()
		{
			return boatColor;
		}
		
		public void setBoatColor(String boatColor)
		{
			this.boatColor = boatColor;
		}
	
		
		public int getBoatModelYear()
		{
			return boatModelYear;
		}
		
		public void setBoatModelYear(int boatModelYear)
		{
			this.boatModelYear = boatModelYear;
		}
		
		public int getBoatPrice()
		{
			return boatPrice;
		}
		
		public void setBoatPrice(int boatPrice)
		{
			this.boatPrice = boatPrice;
		}
		
		public String getBoatImageUrl() {
		       return boatImageUrl;
		}

		public void setBoatImageUrl(String boatImageUrl) {
		      this.boatImageUrl = boatImageUrl;
		}
		
		public Boats()
		{
			super();
		}
}
