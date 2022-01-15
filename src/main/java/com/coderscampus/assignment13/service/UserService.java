package com.coderscampus.assignment13.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findOne(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User createUser(User user) {
		return userRepo.save(user);
		
	}


}
