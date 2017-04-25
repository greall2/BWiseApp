package bwise.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bwise.model.User;
import bwise.service.TransactionsService;
import bwise.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private TransactionsService transactionsService;
	
	//Retrieving users registrations details
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.GET)
	public String getUser(@ModelAttribute("User1") User u, HttpServletRequest h)
	{
		System.out.println("HTTP Request = " + h.getMethod());
			return "RegisterUser";
	}
	
	//Storing the Users registration detains 
	@RequestMapping(value = "/RegisterUser", method=RequestMethod.POST)
	public String postUser(@ModelAttribute("User1") User u, HttpServletRequest h) {
		
		System.out.println("HTTP Request user = " + u.getUsername());
		
		us.save(u);
		
		return "showUser";
	}

	//Attempting Loging - Not fully Working
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest req) {
		
		LinkedList<User> userData = new LinkedList();
		
		//get data passed in from html page for comparison
		String user = (String) req.getAttribute("username");
		String pass = (String) req.getAttribute("password");
		boolean authenticated = false;
		
		// for each user in the list assign the user and password for comparrison
		for(User tmp : userData){
			
			tmp.setUsername(userData.element().getUsername());
			tmp.setPassword(userData.element().getPassword());
			
			System.out.println(tmp.toString());
			
			// If the user data from db matches the data from the html page do the following:
			if(user.equalsIgnoreCase(tmp.getUsername())){
				//the user name matches now check the password for this user
				if(pass.equals(tmp.getPassword())){
					// the user is authenticated
					authenticated = true;
					System.out.println("hi");
				}//inner if
				else{
					// return something to tell the user the login failed
					System.out.println("login failed");
				}
			}//outer if
			
		}// for each user in the list
		
		if(authenticated){
			return "index";
		}else{
			return "login";
		}
		
		
	}
	
	//Displaying transactions table when logged in 
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String loginError(/*@ModelAttribute("User1") User user,*/HttpServletRequest h) {
		h.setAttribute("transactions", transactionsService.findAll());
		h.setAttribute("mode", "MODE_TRANSACTIONS");
		return "index";
	}
	
	//Navigating to home page to logout 
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest h) {
		h.setAttribute("mode", "MODE_HOME");
		return "index";
	}
		
}
