package com.coderscampus.assignment13.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class UserController {
	@Autowired 
	private UserService userService;
	
	@GetMapping("/register")
	public String geCreateUser (ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String postCreateUser(User user) {
		System.out.println(user);
		userService.createUser(user);
		return "redirect:/register";
	}
	
	
	@GetMapping("/users")
		public String getAllUsers (ModelMap model) {
		List<User> users = userService.findAll();
		model.put("users", users);
		return "users";
	}
	@GetMapping("/users/{userId}")
		public String getOneUser (ModelMap model, @PathVariable Long userId) {
		User user = userService.findOne(userId);
		model.put("users", Arrays.asList(user));
		return "users";
	}
	
	
}
