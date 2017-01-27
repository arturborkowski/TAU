package myrestproject.builders;

import java.util.Date;
import java.util.List;

import myrestproject.model.CarRepair;
import myrestproject.model.Transaction;

public class TransactionBuilder {
	private Transaction tran = new Transaction();
	
	public TransactionBuilder id(int id) {
		tran.setId(id);
		return this;
	}
	
	public TransactionBuilder nameOfService(Date date) {
		tran.setDate(date);
		return this;
	}
	
	public TransactionBuilder model(List<CarRepair> repairs) {
		tran.setRepairs(repairs);
		return this;
	}
	
	
	public Transaction build() {
		return tran;
	}
	
}
