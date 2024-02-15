package com.example.cardatabase.firstapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*You want to create the Car entity it is most similar to a model or data class 
representing a table row in Android. aka the entity*/
@Entity
@Table(name="Cars")
public class Car {
	
	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	private String model;
	private String color;
	private String registrationNumber;
	private int modelYear;
	private int price;
	
	//The @ManyToOne annotation in Spring Boot is used to define a 
	//many-to-one relationship between two entities.
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Owner")
	private Owner owner;
	
	//Getters and setters for the Owner objects
	public Owner getOwner()
	{
		return owner;
	}
	
	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}
	
	
	public Car(String brand, String model, String color, String registrationNumber, int modelYear, int price, Owner owner)
	{
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.modelYear = modelYear;
		this.price = price;
		this.owner = owner;
		
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}

	public String getRegistrationNumber()
	{
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber)
	{
		this.registrationNumber = registrationNumber;
	}
	
	
	public int getModelYear()
	{
		return modelYear;
	}
	
	public void setModelYear(int modelYear)
	{
		this.modelYear = modelYear;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public Car()
	{
		super();
	}
	
	
}