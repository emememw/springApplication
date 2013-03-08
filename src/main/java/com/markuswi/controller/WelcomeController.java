package com.markuswi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/welcome")
	public void home() {
		System.out.println("test ... test ...");
	}
}
