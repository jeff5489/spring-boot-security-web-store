package com.example.thymeleafExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.thymeleafExample.model.Product;
import com.example.thymeleafExample.service.ProductService;

@Controller
public class HomeController {
	
    @Autowired
	private ProductService productService;
	
    @GetMapping("/")
    public String home(Model model) {
    	List<Product> products = productService.findAll();
		model.addAttribute("products", products);
        return "home";
    }
    
	@GetMapping("/home")
	public String viewProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "home"; 
	}
	
//	@GetMapping("/error") 
//	public String error() {
//		return "error"; 
//	}
	
//	@GetMapping("/loginFailed") 
//	public String loginFailed() {
//		return "loginFailed"; 
//	}

	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
    
	// if this is @PostMapping the logout view isn't shown
	@GetMapping("/logout")
	public String logout() {
		return "logout"; 
	}


}
