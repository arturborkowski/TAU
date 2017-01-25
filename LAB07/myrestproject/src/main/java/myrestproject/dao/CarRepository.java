package myrestproject.dao;

import myrestproject.model.Car;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer>{
	

}
