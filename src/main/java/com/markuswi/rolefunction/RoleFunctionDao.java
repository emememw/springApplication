package com.markuswi.rolefunction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleFunctionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public RoleFunction saveRoleFunction(RoleFunction roleFunction) {
		roleFunction = entityManager.merge(roleFunction);
		entityManager.flush();
		return roleFunction;
	}
	
}
