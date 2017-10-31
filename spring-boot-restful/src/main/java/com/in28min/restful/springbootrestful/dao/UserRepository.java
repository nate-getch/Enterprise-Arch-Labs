package com.in28min.restful.springbootrestful.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28min.restful.springbootrestful.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	/*public User save(User u);
	public List<User> findAll();
	public User findOne(Long id);*/
}
