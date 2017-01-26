package myrestproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import myrestproject.dao.TransactionRepository;
import myrestproject.model.CarRepair;
import myrestproject.model.Transaction;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransactionService {

	private final TransactionRepository transRepo;

	public TransactionService(TransactionRepository transRepo) {
		super();
		this.transRepo = transRepo;
	}
	
	public List<Transaction> getAllTransactions(){
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(Transaction t : transRepo.findAll()){
			transactions.add(t);
		}
		return transactions;
	}
	
	public double getTotalPrice(int transId) {
		double sum = 0;
		for(CarRepair cr : transRepo.findOne(transId).getRepairs()) {
			sum+=cr.getPrice();
		}
		return sum;
	}
	
	public Transaction getOne(int id) {
		return transRepo.findOne(id);
	}
	
	public void addTransaction(Transaction trans) {
		transRepo.save(trans);
	}
	
	public void deleteTransaction(int id) {
		transRepo.delete(id);
	}
	
	
	
}
