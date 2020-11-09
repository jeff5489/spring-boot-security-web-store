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
	
    @GetMapping("/")
    public String home(Model model) {
    	List<Product> products = productService.findAll();
		model.addAttribute("products", products);
        return "home";
    }
    
    @Autowired
	private ProductService productService;
	
	@GetMapping("/home")
	public String viewProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "home"; 
	}

    


}