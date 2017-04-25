package bwise.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bwise.model.Transaction;
import bwise.service.TransactionsService;

//mvs controller for resolving jsp files

@Controller
public class MainController {
	//setting date format
	public static final SimpleDateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
	
	@Autowired
	private TransactionsService transactionsService;
	
	//Welcome Page Navigates to Home section of index
	@GetMapping("/")
	public String welcome(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	//Date search - getting transaction results of particular dates entered by user from database
	@RequestMapping (value="/search", method = RequestMethod.POST)
	public String search(
			@RequestParam(value="date_from") String date_from, 
			@RequestParam(value="date_to") String date_to, 
			Model model){
		List<Transaction> transactions = transactionsService.findAll();
		List<Transaction> afterSearch = new ArrayList<>();
		Date fromDate, toDate;
		try {
			 fromDate = SDF.parse(date_from);
			 toDate = SDF.parse(date_to);
			 for (Transaction tr: transactions) {
				 Date dateTr = tr.getDateTransfered();
				 if (dateTr.before(toDate) && dateTr.after(fromDate)) {
					 afterSearch.add(tr);
				 }
			 }
			
		} catch (ParseException e) {
		}
	
		model.addAttribute("transactions", afterSearch);
		model.addAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	//Getting all transactions from the database and listing them in transactions section of index
	@GetMapping("/all-transactions")
	public String allTransactions(HttpServletRequest request){
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	//Mapping to add spendings pages of application
	@GetMapping("/new-transaction")
	public String newTransaction(HttpServletRequest request){
		
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	//saving the new transaction to database and displaying table of all transactions
	@PostMapping("/save-transaction")
	public String saveTransaction(@ModelAttribute Transaction transaction, BindingResult bindingResult, HttpServletRequest request){
		transaction.setDateTransfered(new Date());
		transactionsService.save(transaction);
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	//Editing and updating a transaction 
	@GetMapping("/update-transaction")
	public String updateTransaction(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("transactions", transactionsService.findTransaction(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	//Deleting a transaction from database and table
	@GetMapping("/delete-transaction")
	public String deleteTransaction(@RequestParam int id, HttpServletRequest request){
		transactionsService.delete(id);
		request.setAttribute("transactions", transactionsService.findAll());
		request.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}

}
