package com.markuswi.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.markuswi.user.User;

@Component
public class AuthenticationUserDetailsGetter implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		if(username.equals("test")) {
			user = new User();
			user.setUsername("test");
			user.setPassword("850c381493d20b719b662abac4e6f4fc");
			user.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
			
		} else {
			throw new UsernameNotFoundException("username not found");
		}
		return user;
	}
	
}
