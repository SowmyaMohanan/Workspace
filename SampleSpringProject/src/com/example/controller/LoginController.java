package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.User;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check(@ModelAttribute(value = "login") User u, HttpSession session){
		
		if(u.getUsername().equals("admin") 
				&& u.getPassword().equals("1234")){
			session.setAttribute("user",u.getUsername());
			return "success";
		}
		session.setAttribute("user",null);
		return "fail";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("login", new User());
		return "login";
	}
}
