package com.markuswi.role;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Role saveRole(Role role) {
		role = entityManager.merge(role);
		entityManager.flush();
		return role;
	}
	
	public Role loadRoleById(String id) {
		Role role = entityManager.find(Role.class, id);
		return role;
	}
	
	public List<Role> loadAllRoles() {
		List<Role> roles = new LinkedList<Role>();
		Query query = entityManager.createQuery("from Role");
		roles.addAll(query.getResultList());
		return roles;
	}
	
}
