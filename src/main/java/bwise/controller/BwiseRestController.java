package bwise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bwise.service.TransactionsService;

@RestController
public class BwiseRestController {
	
	@Autowired
	private TransactionsService transactionsService;
	
	@GetMapping("/home")
	public String home(){
		return "HOME PAGE";
	}
	
	@GetMapping("/all-transactions")
	public String allTransactions(){
		return transactionsService.findAll().toString();
		
		
	}

}
