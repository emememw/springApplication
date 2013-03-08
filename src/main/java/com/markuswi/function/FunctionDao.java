package com.markuswi.function;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FunctionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Function loadFunctionById(Integer id) {
		Function function = entityManager.find(Function.class, id);
		return function;
	}
	
	public List<Function> loadAllFunctions() {
		List<Function> functions = new LinkedList<Function>();
		Query query = entityManager.createQuery("from Function");
		functions.addAll(query.getResultList());
		return functions;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Function saveFunction(Function function) {
		function = entityManager.merge(function);
		entityManager.flush();
		return function;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void deleteFunction(Integer id) {
		Function function = entityManager.find(Function.class, id);
		entityManager.remove(function);
	}
	
}
