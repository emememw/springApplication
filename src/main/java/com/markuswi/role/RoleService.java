package com.markuswi.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Role loadRoleById(String id) {
		return roleDao.loadRoleById(id);
	}
	
	public List<Role> loadAllRoles() {
		return roleDao.loadAllRoles();
	}
	
	public Role saveRole(Role role){
		return roleDao.saveRole(role);
	}
	
}
