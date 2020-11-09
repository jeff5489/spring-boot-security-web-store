package com.example.thymeleafExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/customer/saveUserForm")
	public String showSaveForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "nonCustomer/saveCustomerForm"; 
	}
	
	@PostMapping("/customer/saveCustomer")
	public String saveCustomerUser(@ModelAttribute("user") User user, Model model) {
		userService.save(user);
		return "home"; 
	}

}
