package com.example.thymeleafExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleafExample.dao.UserRepository;
import com.example.thymeleafExample.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findById(int id) {
		Optional<User> result = userRepo.findById(id);
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return user;
	}
	
	public void save(User user) {
		userRepo.save(user);
	}

	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

}
