package myrestproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import myrestproject.dao.CarRepairRepository;
import myrestproject.model.Car;
import myrestproject.model.CarRepair;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarRepairService {

	private final CarRepairRepository carRepairRepository;

	public CarRepairService(CarRepairRepository carRepairRepository) {
		super();
		this.carRepairRepository = carRepairRepository;
	}
	
	public List<CarRepair> getAllRepairs() {
		List<CarRepair> repairs = new ArrayList<CarRepair>();
		for(CarRepair cr : carRepairRepository.findAll())
			repairs.add(cr);
		return repairs;
	}
	
	public void addRepair(CarRepair cr) {
		carRepairRepository.save(cr);
	}
	
	public void deleteRepair(int id) {
		carRepairRepository.delete(id);
	}
	
	public CarRepair findById(int id) {
		return carRepairRepository.findOne(id);
	}
	
	public List<CarRepair> findRepairsByCar(Car car) {
		return carRepairRepository.findRepairsByCar(car);
	}

}
