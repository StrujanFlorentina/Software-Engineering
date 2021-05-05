package com.example.demo.controller;

import java.util.List;

import com.example.demo.*;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.NotificationService;
import com.example.demo.model.*;

import rmi.Client;
import rmi.MainRMI;
import rmi.Server;


@Controller
public class AppController {
	
	private Logger logger=LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserService repo;
	
	@Autowired
	private BikeService repoBike;
	
	@GetMapping("/index")
	public String viewHomePage()
	{
		Server s=new Server();
		s.runServer();
		return "index";
	}
	
	@GetMapping("/admin")
	public String viewAdmin()
	{
		return "admin";
	}
	
	@GetMapping("/user")
	public String viewUser()
	{
		return "user";
	}

	@GetMapping("/register")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("user",new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user)
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPass=encoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		repo.save(user);
			
		//MainRMI main= new MainRMI();
		//main.runRMI();
		Client c= new Client();
		c.runClient();
		
		try
		{
			notificationService.sendNotification(user);
			
		}catch(MailException e)
		{
			logger.info("Error sending message: "+e.getMessage());
		}
		
		return "register_succes";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model)
	{
		List<User> listUsers=repo.listAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/list_bikes")
	public String viewBikesList(Model model)
	{
		List<Bike> listBikes=repoBike.listAll();
		model.addAttribute("listBikes", listBikes);
		return "bikes";
	}
	
	@GetMapping("/list_bikes_user")
	public String viewBikesListU(Model model)
	{
		List<Bike> listBikes=repoBike.listAll();
		model.addAttribute("listBikes_user", listBikes);
		return "bikes_user";
	}
	
	@RequestMapping("/new")
	public String showNewBikePage(Model model) {
	    Bike bike = new Bike();
	    model.addAttribute("bike", bike);
	     
	    return "new_bike";
	}
	
	@RequestMapping(value = "/saveB", method = RequestMethod.POST)
	public String saveBike(@ModelAttribute("bike") Bike bike) {
	    repoBike.save(bike);
	     
	    return "index";
	}
	
	@RequestMapping("/editB/{id}")
	public ModelAndView showEditBikePage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_bike");
	    Bike bike = repoBike.get(id);
	    mav.addObject("bike", bike);
	     
	    return mav;
	}
	
	@RequestMapping("/editBU/{id}")
	public ModelAndView showEditBikePageU(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_bike_user");
	    Bike bike = repoBike.get(id);
	    mav.addObject("bike", bike);
	     
	    return mav;
	}
	
	@RequestMapping("/deleteB/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
	    repoBike.delete(id);
	    
	    return "admin";       
	}
	
	
	@RequestMapping(value = "/saveU", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
	    repo.save(user);
	     
	    return "admin";
	}
	
	
	@RequestMapping("/deleteU/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
	    repo.delete(id);
	    
	    return "admin";       
	}
}
