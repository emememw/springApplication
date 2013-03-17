package com.markuswi.security;

import org.springframework.stereotype.Component;

@Component
public class TemplateSecurityService {

	public boolean hasPermission(String key) {
		System.out.println("testPermission key:"+key);
		return true;
	}
	
}
