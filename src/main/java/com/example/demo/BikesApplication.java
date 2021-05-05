package com.example.demo;

import com.example.demo.*;
import com.example.demo.controller.AppController;
import com.example.demo.model.*;

import rmi.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class BikesApplication {

	public static void main(String[] args) {

		SpringApplication.run(BikesApplication.class, args);
		
	}

}
