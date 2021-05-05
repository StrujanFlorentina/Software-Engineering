package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.controller.AppController;
import com.example.demo.model.*;

public class PasswordEncoder {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPassword="psw";
		String encodedPass=encoder.encode(rawPassword);
		
		System.out.println(encodedPass);
	}

}
