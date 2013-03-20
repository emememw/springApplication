package com.markuswi.function;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FunctionController {

	@Autowired
	private FunctionService functionService;
	

	private static final String LIST_FUNCTIONS_MAPPING = "/listFunctions";
	private static final String LIST_FUNCTIONS_VIEW = "function/listFunctions";
	private static final String NEW_FUNCTION_MAPPING = "/newFunction";
	private static final String EDIT_FUNCTION_VIEW = "function/editFunction";
	private static final String SAVE_FUNCTION_MAPPING = "/saveFunction";
	private static final String EDIT_FUNCTION_MAPPING = "/editFunction";
	private static final String DELETE_FUNCTION_MAPPING = "/deleteFunction";
	
	@PreAuthorize("@templateSecurityService.hasPermission('test12')")
	@RequestMapping(method = RequestMethod.GET, value = FunctionController.LIST_FUNCTIONS_MAPPING)
	public ModelAndView listFunctions() {
		ModelAndView modelAndView = new ModelAndView(FunctionController.LIST_FUNCTIONS_VIEW);
		modelAndView.addObject("functions", functionService.loadAllFunctions());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = FunctionController.NEW_FUNCTION_MAPPING)
	public ModelAndView newFunction() {
		ModelAndView modelAndView = new ModelAndView(FunctionController.EDIT_FUNCTION_VIEW);
		modelAndView.addObject("function", new Function());
		modelAndView.addObject("allFunctions", functionService.loadAllFunctions());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = FunctionController.SAVE_FUNCTION_MAPPING)
	public ModelAndView saveFunction(@ModelAttribute("function") Function function) {
		RedirectView redirectView = new RedirectView(FunctionController.LIST_FUNCTIONS_MAPPING, true);
		ModelAndView modelAndView = new ModelAndView(redirectView);
		if (function.getId() != null) {
			Function storedFunction = functionService.loadFunctionById(function.getId());
			if (storedFunction != null) {
				storedFunction.setName(function.getName());
				storedFunction.setDescription(function.getDescription());
				
				storedFunction.setReadableByDefault(function.isReadableByDefault());
				storedFunction.setReadableEditable(function.isReadableEditable());
				
				storedFunction.setWriteableByDefault(function.isWriteableByDefault());
				storedFunction.setWriteableEditable(function.isWriteableEditable());
				
				storedFunction.setDeleteableByDefault(function.isDeleteableByDefault());
				storedFunction.setDeleteableEditable(function.isDeleteableEditable());
				
				storedFunction.setDeactivateableByDefault(function.isDeactivateableByDefault());
				storedFunction.setDeactivateableEditable(function.isDeactivateableEditable());
				
				storedFunction.setParentFunctionId(function.getParentFunctionId());
				
				function = storedFunction;
			}
		}

		List<ObjectError> errors = functionService.checkIfFunctionIsValid(function);
		if(functionService.checkIfFunctionNameIsAlreadyExisting(function.getName(), function.getId())) {
			errors.add(new ObjectError("", "Eine Funktion mit diesem Namen existiert bereits!"));
		}
		if (errors.isEmpty()) {
			functionService.saveFunction(function);
		} else {
			modelAndView = new ModelAndView(FunctionController.EDIT_FUNCTION_VIEW);
			modelAndView.addObject("function", function);
			modelAndView.addObject("errors", errors);
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = FunctionController.EDIT_FUNCTION_MAPPING + "/{id}")
	public ModelAndView editFunction(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView(FunctionController.EDIT_FUNCTION_VIEW);

		modelAndView.addObject("function", functionService.loadFunctionById(id));
		modelAndView.addObject("allFunctions", functionService.loadAllFunctions());
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = FunctionController.DELETE_FUNCTION_MAPPING+"/{id}")
	public ModelAndView deleteFunction(@PathVariable Integer id) {
		RedirectView redirectView = new RedirectView(FunctionController.LIST_FUNCTIONS_MAPPING, true);
		ModelAndView modelAndView = new ModelAndView(redirectView);
		functionService.deleteFunction(id);
		return modelAndView;
	}

}
