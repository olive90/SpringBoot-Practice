package com.biznov.gdic.inventory.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final List<AppUser> users = Arrays.asList(new AppUser(1, "gdic", encoder.encode("admin"), "ADMIN"),
				new AppUser(2, "omar", encoder.encode("123456"), "USER"));

		for (AppUser appUser : users) {
			if (appUser.getUsername().equals(username)) {
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}
		throw new UsernameNotFoundException("Username: " + username + " Not found");
	}

}
