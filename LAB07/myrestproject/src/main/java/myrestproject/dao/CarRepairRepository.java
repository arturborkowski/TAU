package myrestproject.dao;

import java.util.List;

import myrestproject.model.Car;
import myrestproject.model.CarRepair;

import org.springframework.data.repository.CrudRepository;

public interface CarRepairRepository extends CrudRepository<CarRepair, Integer>{
	public List<CarRepair> findRepairsByCar(Car car);
}
