package com.markuswi.function;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FunctionValidator implements Validator {

	private static final String FUNCTION_NAME_NULL = "function.name.null";
	private static final String FUNCTION_NAME_INVALID_FORMAT = "function.name.invalid.format";
	
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Function.class);
	}

	public void validate(Object object, Errors errors) {
		Function function = (Function) object;
		
		if(function.getName() == null) {
			errors.rejectValue("", FunctionValidator.FUNCTION_NAME_NULL, "Fehler beim Verarbeiten der Funktion" );
		} else if(function.getName().isEmpty() || !function.getName().matches("[a-zA-z0-9\\.\\-\\_\\+]*")) {
			errors.rejectValue("", FunctionValidator.FUNCTION_NAME_INVALID_FORMAT, "Bitte prüfen Sie das Format des angegebenen Namens");
		}
		
	}

}
