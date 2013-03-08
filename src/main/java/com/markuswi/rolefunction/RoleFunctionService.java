package com.markuswi.rolefunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markuswi.function.Function;
import com.markuswi.role.Role;
import com.markuswi.role.RoleService;

@Service
public class RoleFunctionService {

	@Autowired
	private RoleFunctionDao roleFunctionDao;
	
	@Autowired
	private RoleService roleService;
	
	public RoleFunction saveRoleFunction(RoleFunction roleFunction) {
		return roleFunctionDao.saveRoleFunction(roleFunction);
	}
	
	public void createRoleFunctionForNewFunction(Function function) {
		List<Role> allRoles = roleService.loadAllRoles();
		for(Role role : allRoles) {
			RoleFunction roleFunction = new RoleFunction();
			roleFunction.setFunction(function);
			roleFunction.setRole(role);
			this.saveRoleFunction(roleFunction);
		}
	}
	
}
