package com.userService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.entities.User;
import com.userService.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User createUser(User user) {
		return userRepo.save(user);

	}

	public User getUser(int userId) {
		return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found!!"));
	}

	public User updateUser(User user, int userId) {

		User dbUser = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found!!"));

		dbUser.setUserName(user.getUserName());
		dbUser.setUserEmail(user.getUserEmail());
		dbUser.setUserPassword(user.getUserPassword());
		dbUser.setUserAddress(user.getUserAddress());

		return userRepo.save(dbUser);
	}

}
