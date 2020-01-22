package com.restful.webservices.with.jpa.restfulwebserviceswithjpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restful.webservices.with.jpa.restfulwebserviceswithjpa.entity.User;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	private String username = "Gandu";
	private String role = "Admin";
	
	@Autowired
	UserDaoService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(username, role);
		userDaoService.insert(user);
		log.info("New user created : " + user);
	}

}
