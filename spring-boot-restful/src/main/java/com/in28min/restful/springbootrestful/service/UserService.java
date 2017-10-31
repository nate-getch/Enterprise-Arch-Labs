package com.in28min.restful.springbootrestful.service;

import java.util.List;
import java.util.Optional;

import com.in28min.restful.springbootrestful.model.User;

public interface UserService {
	public User addUser(User u);
	public List<User> getAllUsers();
	public Optional<User> findOne(Long id);
	public void deleteById(Long id);
}
