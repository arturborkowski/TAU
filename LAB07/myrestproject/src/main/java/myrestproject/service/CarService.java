package myrestproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import myrestproject.dao.CarRepository;
import myrestproject.model.Car;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarService {

	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<Car>();
		for(Car p : carRepository.findAll())
			cars.add(p);
		return cars;
	}
	
	public void addCar(Car c) {
		carRepository.save(c);
	}
	
	public void deleteCar(int id) {
		carRepository.delete(id);
	}
	
	public Car findById(int id) {
		return carRepository.findOne(id);
	}

}
