package com.markuswi.function;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;

@Service
public class FunctionService {

	@Autowired
	private FunctionDao functionDao;

	@Autowired
	private FunctionValidator functionValidator;

	public Function loadFunctionById(Integer id) {
		return functionDao.loadFunctionById(id);
	}

	public List<Function> loadAllFunctions() {
		return functionDao.loadAllFunctions();
	}

	public Function saveFunction(Function function) {
		return functionDao.saveFunction(function);
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

}
