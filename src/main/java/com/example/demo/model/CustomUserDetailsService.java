package com.example.demo.model;

import com.example.demo.*;
import com.example.demo.controller.AppController;
import com.example.demo.model.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserProfile repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findbyEmail(email);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found!");
		}
		return new CustomUserDetails(user);
	}

}
