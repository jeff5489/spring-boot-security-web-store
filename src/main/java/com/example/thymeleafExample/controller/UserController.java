package com.example.thymeleafExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleafExample.model.User;
import com.example.thymeleafExample.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/users")
//	public List<User> getUsers() {
//		return userService.findAll();
//	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.findById(id);
		if (user == null) {
			throw new RuntimeException("User id not found - " + id);
		}
		return user;
	}
	
//	@PostMapping("/saveUser")
//	public User addUser(@RequestBody User theEmployee) {
//		// also just in case they pass an id in JSON ... set id to 0
//		// this is to force a save of new item ... instead of update
//		theEmployee.setId(0);
//		userService.save(theEmployee);
//		return theEmployee;
//	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteEmployee(@PathVariable int id) {
		User user = userService.findById(id);
		// throw exception if null
		if (user == null) {
			throw new RuntimeException("Employee id not found - " + user);
		}
		userService.deleteById(id);
		return "Deleted employee id - " + id;
	}

}
