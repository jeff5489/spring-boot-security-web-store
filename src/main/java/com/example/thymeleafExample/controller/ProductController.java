package com.example.thymeleafExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleafExample.model.Product;
import com.example.thymeleafExample.model.User;
import com.example.thymeleafExample.service.ProductService;
import com.example.thymeleafExample.service.UserService;

@Controller
//@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/products")
	public String viewProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "admin/viewProducts"; 
	}
	
	@GetMapping("/product/saveProductForm")
	public String showSaveForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin/saveProduct"; 
	}

	@GetMapping("/product/updateProduct")
	public String updateProduct(@RequestParam("id") int id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "admin/saveProduct"; 
	}
	
	@PostMapping("/product/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		productService.save(product);
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "admin/viewProducts"; 
	}
	
	@GetMapping("/product/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id, Model model) {
		productService.deleteById(id);;
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "admin/viewProducts"; 
	}
}
