package com.example.demo.model;

import com.example.demo.*;
import com.example.demo.controller.AppController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserProfile extends JpaRepository<User, Long> {
	
	@Query("Select u from User u where u.email=?1") //?1 pentru primul parametru
	
	User findbyEmail(String email);
	

}
