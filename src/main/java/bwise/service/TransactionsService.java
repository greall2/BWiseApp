package bwise.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import bwise.dao.TransactionRepository;
import bwise.model.Transaction;

@Service
@Transactional
public class TransactionsService {
	
	private TransactionRepository transactionRepository;
	
	//public TransactionsService(){}
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
	

	
	public void delete (int id){
		transactionRepository.delete(id);
	}


	public void save(Transaction transaction) {
		// TODO Auto-generated method stub
		transactionRepository.save(transaction);

	}
}
