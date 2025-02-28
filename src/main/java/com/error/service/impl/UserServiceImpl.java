package com.error.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.error.models.Role;
import com.error.models.User;
import com.error.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users;
	
	public UserServiceImpl() {
		this.users = Arrays.asList(
			new User(1L, "Luis Gerardo", "Valencia Camacho", new Role("Admin")),
			new User(2L, "María Ana Gabriela", "Ramírez Lugo"),
			new User(3L, "Eduardo", "Valencia Cardenas"),
			new User(4L, "Ma Guadalupe", "Camacho Bazaldua"),
			new User(5L, "José Eduardo", "Valencia Camacho")
		);
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public Optional<User> findById(Long id) {
		return users.stream().filter(item -> item.getId().equals(id)).findFirst();
	}

}
