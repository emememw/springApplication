package com.markuswi.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/loginSuccess")
	public ModelAndView loginSuccess() {
		return new ModelAndView(new RedirectView("/listFunctions", true));
	}
	
}
