package myrestproject.builders;

import java.util.List;

import myrestproject.model.Car;
import myrestproject.model.CarRepair;
import myrestproject.model.Person;

public class CarBuilder {
	private Car car = new Car();
	
	public CarBuilder id(int id) {
		car.setId(id);
		return this;
	}
	
	public CarBuilder brand(String brand) {
		car.setBrand(brand);
		return this;
	}
	
	public CarBuilder model(String model) {
		car.setModel(model);
		return this;
	}
	
	public CarBuilder productionYear(int yop) {
		car.setProductionYear(yop);
		return this;
	}
	
	public CarBuilder person(Person person){
		car.setPerson(person);
		return this;
	}
	
	public CarBuilder repairs(List<CarRepair> repairs) {
		car.setCarRepairs(repairs);
		return this;
	}
	
	public Car build() {
		return car;
	}
	
}
