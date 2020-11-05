package com.example.thymeleafExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleafExample.model.User;
import com.example.thymeleafExample.service.UserService;

//@RestController
//@RequestMapping
//("/test")
@Controller
public class UserTLController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/users")
	public String viewUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/viewUsers"; 
	}
	
	@GetMapping("/admin/saveUserForm")
	public String showSaveForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "admin/saveUser"; 
	}
	
	@GetMapping("/admin/updateUser")
	public String update(@RequestParam("id") int id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "admin/saveUser"; 
	}
	
	@PostMapping("/admin/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		userService.save(user);
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/viewUsers"; 
	}
	
	@GetMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam("id") int id, Model model) {
		userService.deleteById(id);;
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/viewUsers"; 
	}

//	@GetMapping("/home")
//	public String home() {
//		return "home"; 
//	}
}
