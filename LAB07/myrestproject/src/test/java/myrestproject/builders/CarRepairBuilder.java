package myrestproject.builders;

import myrestproject.model.Car;
import myrestproject.model.CarRepair;
import myrestproject.model.Transaction;

public class CarRepairBuilder {
	private CarRepair repair = new CarRepair();
	
	public CarRepairBuilder id(int id) {
		repair.setId(id);
		return this;
	}
	
	public CarRepairBuilder nameOfService(String nameOfService) {
		repair.setNameOfService(nameOfService);
		return this;
	}
	
	public CarRepairBuilder model(double price) {
		repair.setPrice(price);
		return this;
	}
	
	public CarRepairBuilder productionYear(Car car) {
		repair.setCar(car);
		return this;
	}
	
	public CarRepairBuilder person(Transaction transaction){
		repair.setTransaction(transaction);
		return this;
	}

	
	public CarRepair build() {
		return repair;
	}
	
}
