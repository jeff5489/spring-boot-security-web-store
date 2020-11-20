package com.example.thymeleafExample.model;

import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Customer extends User {
	
	private ArrayList <Order>orderHistory;
	
	// add items to shopping cart
	// order all items in shopping cart therefore creating an order
	
	// shopping cart functionality
	// customer order history functionality
	
	// customer has order history - arraylist of order arraylists
	// order history has individual orders - arraylist of products
	// order has individual products

}
