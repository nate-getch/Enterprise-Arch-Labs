package com.in28min.restful.springbootrestful.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28min.restful.springbootrestful.model.User;

@Repository
public class UserRepositoryImpl { // implements UserRepository {
	
	/*
	List<User> users;
	
	
	UserRepositoryImpl(){
		users = new ArrayList<User>();
		users.add(new User("Nati","Admin"));
		users.add(new User("Beti","Admin"));
	}
	
	public User addUser(User u) {
		users.add(u);
		return u;
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	public User findOne(int id) {
		for(User u : users) {
			if(u.getId() == id)
				return u;
		}
		return null;
	}*/
}
