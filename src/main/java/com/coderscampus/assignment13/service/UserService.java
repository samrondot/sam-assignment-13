package com.coderscampus.assignment13.service;

import java.time.LocalDate;
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
	
	public List<User> findByUsername(String username){
		return userRepo.findByUsername(username);
	}
	public List<User> findByUsernameAndName(String name, String username){
		return userRepo.findByUsernameAndName(name, username);
	}
	public List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2){
		return userRepo.findByCreatedDateBetween(date1, date2);
	}
	public User findByExactlyOneUserByUsername(String username) {
		List<User> users =  userRepo.findByExactlyOneUserByUsername(username);
		if(users.size()>0)
			return users.get(0);
		else
			return new User();
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findOne(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User saveUser(User user) {
		return userRepo.save(user);
		
	}

	public void delete(Long userId) {
		userRepo.deleteById(userId);
		
	}


}
