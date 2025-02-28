package com.error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.error.exceptions.UserNotFoundException;
import com.error.models.User;
import com.error.service.UserService;

@RestController
public class AppController {
	
	UserService userService;
	
	public AppController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String index() {
		return "ok 200";
	}
	
	@GetMapping("/InternalError")
	public String internalError() {
		int val = 500 / 0;
		System.out.println(val);
		return "Error 500";
	}
	
	@GetMapping("/NumberFormat")
	public int numberFormat() {
		int number = Integer.parseInt("hola");
		return number;
	}
	
	@GetMapping("/show/{id}")
	public User showUser(@PathVariable("id") Long id) {
		User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario no existe"));
		return user;
	}
}
