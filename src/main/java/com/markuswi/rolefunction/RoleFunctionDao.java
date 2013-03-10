package com.markuswi.rolefunction;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public RoleFunction loadRoleFunctionByFunctionAndRole(Integer functionId, String roleId) {
		RoleFunction roleFunction = null;

		Query query = entityManager.createQuery("from RoleFunction roleFunction where roleFunction.function_id :functionId and roleFunction.role_id : roleId");
		query.setParameter("functionId", functionId);
		query.setParameter("roleId", roleId);
		try {
			roleFunction = (RoleFunction) query.getSingleResult();
		} catch (NoResultException noResultException) {

		}
		return roleFunction;
	}

}
