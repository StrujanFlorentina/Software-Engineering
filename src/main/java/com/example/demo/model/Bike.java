package com.example.demo.model;

import javax.persistence.Column;

import com.example.demo.*;
import com.example.demo.controller.AppController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bikesTable")
public class Bike {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,length=20)
	private String brand;
	@Column(nullable=false,length=20)
	private String color;
	@Column(nullable=false,length=10)
	private String fullspeed;
	@Column(nullable=false,length=5)
	private String size;
	@Column(nullable=false,length=30)
	private String location;
	@Column(nullable=false,length=20)
	private String disponibility;


	public Bike() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFullspeed() {
		return fullspeed;
	}

	public void setFullspeed(String fullspeed) {
		this.fullspeed = fullspeed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(String disponibility) {
		this.disponibility = disponibility;
	}
	
}
