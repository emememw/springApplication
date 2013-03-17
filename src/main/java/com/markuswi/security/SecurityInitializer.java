package com.markuswi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityInitializer {

	//@Autowired
	//private AuthenticationManager authenticationManager;
	
	public void init() {
		System.out.println("test!");
		SecurityContextHolder.getContext().setAuthentication(new TemplateAuthentication());  
	}
	
}
