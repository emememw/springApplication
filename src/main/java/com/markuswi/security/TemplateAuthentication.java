package com.markuswi.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class TemplateAuthentication implements Authentication {

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
