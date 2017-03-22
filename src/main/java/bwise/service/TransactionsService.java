package bwise.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bwise.dao.TransactionRepository;
import bwise.model.Transaction;

@Service
@Transactional
public class TransactionsService {
	private final TransactionRepository transactionRepository;

	public TransactionsService(TransactionRepository transactionrepository) {
		
		this.transactionRepository = transactionrepository;
	}
	

	public List<Transaction> findAll(){
		List<Transaction> transactions = new ArrayList<>();
		for (Transaction transaction : transactionRepository.findAll()){
			transactions.add(transaction);
		}
		return transactions;
	}
	
	public Transaction findTransaction(int id) {
		return transactionRepository.findOne(id);
		
	}
	
	public void save (Transaction transaction){
		transactionRepository.save(transaction);
	}
	
	public void delete (int id){
		transactionRepository.delete(id);
	}
}
