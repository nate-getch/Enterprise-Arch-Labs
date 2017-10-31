package com.in28min.restful.springbootrestful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28min.restful.springbootrestful.dao.UserRepository;
import com.in28min.restful.springbootrestful.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository UserRepository;
	
	public User addUser(User u) {
		return UserRepository.save(u);
	}
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}
	
	public Optional<User> findOne(Long id) {
		return UserRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		UserRepository.deleteById(id);
	}

}
