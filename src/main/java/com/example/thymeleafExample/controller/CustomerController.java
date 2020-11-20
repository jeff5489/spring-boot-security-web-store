package com.example.thymeleafExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleafExample.model.User;
import com.example.thymeleafExample.service.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	BCryptPasswordEncoder bc;
	
	@GetMapping("/customer/saveUserForm")
	public String showSaveForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "nonCustomer/saveCustomerForm"; 
	}
	
	@PostMapping("/customer/saveCustomer")
	public String saveCustomerUser(@ModelAttribute("user") User user, Model model) {
		
//		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
//		String encodedPassword = bc.encode(user.getPassword());
//		user.setPassword(encodedPassword);
		
		user.setRoles("ROLE_USER");
				
		userService.save(user);
		return "home"; 
	}

}
