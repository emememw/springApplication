package com.markuswi.role;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
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
