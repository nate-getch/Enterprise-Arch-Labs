package com.in28min.restful.springbootrestful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28min.restful.springbootrestful.exception.UserNotFoundException;
import com.in28min.restful.springbootrestful.model.User;
import com.in28min.restful.springbootrestful.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping(path="users/add")
	public ResponseEntity<Object> addUser(@RequestBody User u){
		User newUser = userService.addUser(u);
		// return status code of Created + uri of created user
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="users/list")
	public List<User> getAll(){
		return (List<User>) userService.getAllUsers();
	}
	
	@GetMapping(path="users/{id}")
	public Optional<User> findUser(@PathVariable ("id") int id){
		Optional<User> user = userService.findOne(Long.valueOf(id));
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Id: "+ id);
		}
		return user;
	}
	
	@GetMapping(path="users/delete/{id}")
	public void deleteUser(@PathVariable ("id") int id){
		userService.deleteById(Long.valueOf(id));
	}
	
}
