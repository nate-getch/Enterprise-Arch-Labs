package com.in28min.restful.springbootrestful.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28min.restful.springbootrestful.dao.UserRepository;
import com.in28min.restful.springbootrestful.model.User;

/*
 * CommandLineRunner will run at launch of the application
 */

@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {
	
	//log info using slf4j Logger
	private static final Logger log = LoggerFactory.getLogger(UserServiceCommandLineRunner.class);
			
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Nati","Admin");
		userRepository.save(user1);
		log.info("Inserted User ID:" + user1);
	}

}
