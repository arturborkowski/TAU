package myrestproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarRepair {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	private double price;
	private String nameOfService;
	
	
	public CarRepair() {
		super();
	}


	public CarRepair(Integer id, Car car, double price, String nameOfService) {
		super();
		this.id = id;
		this.car = car;
		this.price = price;
		this.nameOfService = nameOfService;
	}


	public CarRepair(Car car, double price, String nameOfService) {
		super();
		this.car = car;
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


	@Override
	public String toString() {
		return "CarRepair [id=" + id + ", car=" + car + ", price=" + price
				+ ", nameOfService=" + nameOfService + "]";
	}
	
	
	
	
	
}
