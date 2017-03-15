package bwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bwise.service.TransactionsService;

//mvs controller for resolving jsp files

@Controller
public class MainController {
	@Autowired
	private TransactionsService transactionsService;
	
	
	@GetMapping("/")
	public String welcome(){
		return "index";
	}

}
