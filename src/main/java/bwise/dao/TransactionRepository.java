package bwise.dao;

import org.springframework.data.repository.CrudRepository;

import bwise.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
