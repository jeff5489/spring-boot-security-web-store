package com.example.thymeleafExample.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymeleafExample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
