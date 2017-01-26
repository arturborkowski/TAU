package myrestproject.controller;

import java.util.List;

import myrestproject.model.Transaction;
import myrestproject.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionRestController {

	@Autowired
	private TransactionService transService;

	@GetMapping("/alltransactions")
	public ResponseEntity<List<Transaction>> getAll(){
		return new ResponseEntity<List<Transaction>>(transService.getAllTransactions(),HttpStatus.OK);		
	}
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> getRepair(@PathVariable int id) {
		return new ResponseEntity<Transaction>(transService.getOne(id),HttpStatus.OK);
	}
	
	@GetMapping("/transaction/{id}/total")
	public String getTotalPrice(@PathVariable int id) {
		return "Total: "+transService.getTotalPrice(id);
	}
	
	@GetMapping("/deletetransaction")
	public ResponseEntity<Transaction> deletePerson(@RequestParam int id) {
		transService.deleteTransaction(id);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}
	
	

}
