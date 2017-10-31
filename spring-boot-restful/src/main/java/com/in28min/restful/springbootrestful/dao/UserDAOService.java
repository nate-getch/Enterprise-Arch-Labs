package com.in28min.restful.springbootrestful.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28min.restful.springbootrestful.model.User;

/*
 * directly using entity manager to perform CRUD operation
 */

@Repository
@Transactional
public class UserDAOService { 
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
	
}
