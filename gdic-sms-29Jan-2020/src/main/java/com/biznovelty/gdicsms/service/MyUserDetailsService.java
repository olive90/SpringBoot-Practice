package com.biznovelty.gdicsms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new User("gdic", encoder.encode("admin"), new ArrayList<>());
	}

}
