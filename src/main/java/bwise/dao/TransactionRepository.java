package bwise.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bwise.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
