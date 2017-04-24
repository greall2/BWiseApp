package bwise.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bwise.model.User;
import bwise.service.UserService;


import bwise.dao.UserInterface;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.GET)
	public String getUser(@ModelAttribute("User1") User u, HttpServletRequest h)
	{
		
		System.out.println("HTTP Request = " + h.getMethod());
			return "RegisterUser";
	}
	
	@RequestMapping(value = "/RegisterUser", method=RequestMethod.POST)
	public String postUser(@ModelAttribute("User1") User u, HttpServletRequest h) {
		
		System.out.println("HTTP Request abcd = " + u.getUsername());
		
		us.save(u);
		
		return "showUser";
	}

	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String loginError(@ModelAttribute("User1") User user,HttpServletRequest h) {
		//model.addAttribute("loginError", true);
		//model.put("username", username);
		return "index";
	}
	
}
