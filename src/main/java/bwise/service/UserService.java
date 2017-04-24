package bwise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bwise.model.User;
import bwise.dao.UserInterface;

@Service
public class UserService {

	@Autowired
	private UserInterface userInterface;

	  public User save(User user) {
	    	return userInterface.save(user);
	  }

}
