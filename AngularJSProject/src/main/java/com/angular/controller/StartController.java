package com.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student() {
		return "student";
	}
	
}
