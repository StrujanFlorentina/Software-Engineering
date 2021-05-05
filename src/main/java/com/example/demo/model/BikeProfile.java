package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BikeProfile extends JpaRepository<Bike, Long> {
		
		@Query("Select b from Bike b where b.brand=?1") //?1 pentru primul parametru
		
		Bike findbyBrand(String brand);

	}
