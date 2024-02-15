package com.example.cardatabase.firstapp.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Owner")
public class Owner {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerid;
	private String firstname, lastname;
	
	/*The main difference between @OneToMany And @ManyTOne is:
	
	 	@OneToMany defines a one to many relationship from the source
	 	entity perspective. For example, one Author has many Books
	 	
	 	@ManyToOne defines a many to one relationship from the source
	 	entity perspective. For example Books have one Author
	
	  The cascade attribute defines how cascading affects the entities in 
	  the case of deletions or updates.
	
	  The ALL attribute setting means that all operations are cascaded. 
	  For example, if the owner is deleted, the cars that are linked to that owner are 
	  deleted as well
	  
	  The mappedBy="owner" attribute setting tells us that the Car class
	  has the owner field, which is the foreign key for this
	  relationship.
	*/
	 @OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	 private List<Car> cars;
	 
	 public List<Car> getCars(){
		 return cars;
	 }
	 
	 public void setCars(List<Car> cars)
	 {
		 this.cars = cars;
	 }

	
	public Owner(String firstname, String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Owner()
	{
		super();
	}
	
	private Long getOwnerid()
	{
		return ownerid;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastnmae(String lastname)
	{
		this.lastname = lastname;
	}

}
