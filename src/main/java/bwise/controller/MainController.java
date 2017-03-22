package bwise.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bwise.model.Transaction;
import bwise.service.TransactionsService;

//mvs controller for resolving jsp files

@Controller
public class MainController {
	@Autowired
	private TransactionsService transactionsService;
	
	
	@GetMapping("/")
	public String welcome(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-transactions")
	public String allTransactions(HttpServletRequest request){
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	@GetMapping("/new-transaction")
	public String newTransaction(HttpServletRequest request){
		
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-transaction")
	public String saveTransaction(@ModelAttribute Transaction transaction, BindingResult bindingResult, HttpServletRequest request){
		transaction.setDateTransfered(new Date());
		transactionsService.save(transaction);
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	@GetMapping("/update-transaction")
	
	public String updateTransaction(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("transactions", transactionsService.findTransaction(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-transaction")
	public String deleteTransaction(@RequestParam int id, HttpServletRequest request){
		transactionsService.delete(id);
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}

}
