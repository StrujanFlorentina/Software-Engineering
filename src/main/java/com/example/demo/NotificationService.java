package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.controller.AppController;
import com.example.demo.model.*;


@Service
public class NotificationService {
	
private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException
	{	
		SimpleMailMessage mail=new SimpleMailMessage();
		
		mail.setFrom("bike.bss503@gmail.com");
		mail.setTo(user.getEmail());
		mail.setSubject("Notification");
		mail.setText("Thank you for registering with us!");
		
		javaMailSender.send(mail);
	}

}
