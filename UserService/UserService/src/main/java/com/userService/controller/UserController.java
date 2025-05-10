package com.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entities.User;
import com.userService.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		
		return userService.createUser(user);
		
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable int userId) {
		
		return userService.getUser(userId);
		
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable int userId) {
		
		return userService.updateUser(user,userId);
	}

}
