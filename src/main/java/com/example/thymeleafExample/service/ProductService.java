package com.example.thymeleafExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleafExample.dao.ProductRepository;
import com.example.thymeleafExample.model.Product;
import com.example.thymeleafExample.model.User;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> findAll() {
		return productRepo.findAll();
	}
	
	public Product findById(int id) {
		Optional<Product> result = productRepo.findById(id);
		Product product = null;
		if (result.isPresent()) {
			product = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return product;
	}
	
	public void save(Product product) {
		productRepo.save(product);
	}

	public void deleteById(int id) {
		productRepo.deleteById(id);
	}

}
