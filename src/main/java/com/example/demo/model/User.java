package com.example.demo.model;

import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersTable")
public class User {
	
	//--------------------------------------------------------------------------------------
    public User(String location)
    {
        this.location=location;
        System.out.println(location);
    }
    
    public User(String location,String name)
    {
        this.location=location;
        this.firstName=name;
        //System.out.println(location);
    }
    
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=false,length=20)
	private String firstName;
	@Column(nullable=false,unique=false,length=20)
	private String lastName;
	@Column(nullable=false,unique=true,length=45)
	private String email;
	@Column(nullable=false,unique=true,length=45)
	private String phoneNumber;
	@Column(nullable=false,unique=true,length=64)
	private String password;
	
	@Column(nullable=false,unique=false,length=64)
	private String payment;
	
	@Column(nullable=false,unique=false,length=64)
	private String location;
	
	
	
	public User() {
		this.payment="Credit Card";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toString()
	{
		return "Location: " + location + ", name: "+firstName;
	}

	
}
