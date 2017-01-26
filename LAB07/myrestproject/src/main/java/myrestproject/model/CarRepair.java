package myrestproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarRepair {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="transaction_id")
	@JsonIgnore
	private Transaction transaction;
	private double price;
	private String nameOfService;
	
	
	
	
	public CarRepair() {
		super();
	}


	public CarRepair(Car car, Transaction transaction, double price,
			String nameOfService) {
		super();
		this.car = car;
		this.transaction = transaction;
		this.price = price;
		this.nameOfService = nameOfService;
	}


	public CarRepair(Integer id, Car car, Transaction transaction,
			double price, String nameOfService) {
		super();
		this.id = id;
		this.car = car;
		this.transaction = transaction;
		this.price = price;
		this.nameOfService = nameOfService;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getNameOfService() {
		return nameOfService;
	}


	public void setNameOfService(String nameOfService) {
		this.nameOfService = nameOfService;
	}

	
	

	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	@Override
	public String toString() {
		return "CarRepair [id=" + id + ", car=" + car + ", transaction="
				+ transaction + ", price=" + price + ", nameOfService="
				+ nameOfService + "]";
	}

	
	
	
	
}
