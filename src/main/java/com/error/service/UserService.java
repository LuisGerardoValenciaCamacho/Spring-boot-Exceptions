package com.error.service;

import java.util.List;
import java.util.Optional;

import com.error.models.User;

public interface UserService {
	
	List<User> findAll();
	
	Optional<User> findById(Long id);
}
