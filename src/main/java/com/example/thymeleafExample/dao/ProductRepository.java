package com.example.thymeleafExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleafExample.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}