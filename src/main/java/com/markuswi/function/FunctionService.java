package com.markuswi.function;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;

import com.markuswi.rolefunction.RoleFunctionService;

@Service
public class FunctionService {

	@Autowired
	private FunctionDao functionDao;

	@Autowired
	private RoleFunctionService roleFunctionService;

	@Autowired
	private FunctionValidator functionValidator;

	public Function loadFunctionByName(String name) {
		return functionDao.loadFunctionByName(name);
	}
	
	public Function loadFunctionById(Integer id) {
		return functionDao.loadFunctionById(id);
	}

	public List<Function> loadAllFunctions() {
		return functionDao.loadAllFunctions();
	}

	public Function saveFunction(Function function) {
		boolean createRoleFunction = false;
		if (function.getId() == null) {
			createRoleFunction = true;
		}
		function = functionDao.saveFunction(function);
		if(createRoleFunction) {
			roleFunctionService.createRoleFunctionForNewFunction(function);
		}
		
		return function;
	}

	public void deleteFunction(Integer id) {
		functionDao.deleteFunction(id);
	}

	public List<ObjectError> checkIfFunctionIsValid(Function function) {

		List<ObjectError> errors = new LinkedList<ObjectError>();
		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(function, "function");
		functionValidator.validate(function, bindingResult);
		errors.addAll(bindingResult.getAllErrors());
		return errors;
	}
	
	public boolean checkIfFunctionNameIsAlreadyExisting(String functionName, Integer functionId) {
		boolean alreadyExisting = false;
		Function storedFunction = this.loadFunctionByName(functionName);
		if(storedFunction != null && !storedFunction.getId().equals(functionId)) {
			alreadyExisting = true;
		}
		return alreadyExisting;
	}
	
	public Set<Integer> getChildFunctionIdsRecursive(Function currentFunction, List<Function> allFunctions) {
		Set<Integer> childFunctions = new HashSet<Integer>();
		if(currentFunction.getId() != null) {
			for(Function function : allFunctions) {
				if(function.getParentFunctionId() != null && function.getParentFunctionId().equals(currentFunction.getId())) {
					childFunctions.add(function.getId());
					childFunctions.addAll(this.getChildFunctionIdsRecursive(function, allFunctions));
				}
			}
		}
		return childFunctions;
	}
	
	public List<Function> getPotentialParents(Function currentFunction, List<Function> allFunctions) {
		Set<Integer> allChildFunctions = new HashSet<Integer>();
		if(currentFunction.getId() != null) {
			allChildFunctions.addAll(this.getChildFunctionIdsRecursive(currentFunction, allFunctions));
		}
		List<Function> potentialParents = new LinkedList<Function>();
		for(Function function : allFunctions) {
			if(!function.getId().equals(currentFunction.getId()) && !allChildFunctions.contains(function.getId())) {
				potentialParents.add(function);
			}
		}
		return potentialParents;
	}

}
