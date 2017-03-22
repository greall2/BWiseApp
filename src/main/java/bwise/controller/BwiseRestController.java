package bwise.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bwise.model.Transaction;
import bwise.service.TransactionsService;

@RestController
public class BwiseRestController {
	
	@Autowired
	private TransactionsService transactionsService;
	
	@GetMapping("/home")
	public String home(){
		return "HOME PAGE";
	}
	


}
