package bwise.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bwise.model.User;

@Repository
public interface UserInterface extends CrudRepository<User, Long>  {

	
}
