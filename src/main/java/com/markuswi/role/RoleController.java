package com.markuswi.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listRoles")
	public ModelAndView listRoles() {
		ModelAndView modelAndView = new ModelAndView("role/roles");
		modelAndView.addObject("roles", roleService.loadAllRoles());
		return modelAndView;
	}
	
}
