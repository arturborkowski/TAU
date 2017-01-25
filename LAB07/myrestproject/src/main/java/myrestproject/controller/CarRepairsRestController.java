package myrestproject.controller;

import java.util.List;

import myrestproject.model.Car;
import myrestproject.model.CarRepair;
import myrestproject.service.CarRepairService;
import myrestproject.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarRepairsRestController {

	@Autowired
	private CarRepairService repairService;
	@Autowired
	private CarService carService;

	@GetMapping("/allrepairs")
	public ResponseEntity<List<CarRepair>> getAll(){
		return new ResponseEntity<List<CarRepair>>(repairService.getAllRepairs(),HttpStatus.OK);		
	}
	
	@GetMapping("/repair/{id}")
	public ResponseEntity<CarRepair> getRepair(@PathVariable int id) {
		return new ResponseEntity<CarRepair>(repairService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/repairsforcar/{id}")
	public ResponseEntity<List<CarRepair>> getRepairsByCar(@PathVariable int id) {
		Car c = carService.findById(id);
		if(c != null) {
			return new ResponseEntity<List<CarRepair>>(repairService.
					findRepairsByCar(c),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<CarRepair>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/addrepair")
	public ResponseEntity<CarRepair> addRepair(
			@RequestParam double price, 
			@RequestParam String name, 
			@RequestParam int carId) {
		Car car = carService.findById(carId);
		if(car != null) {
			CarRepair cr = new CarRepair(car, price, name);
			repairService.addRepair(cr);
			return new ResponseEntity<CarRepair>(cr,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<CarRepair>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/deleterepair")
	public ResponseEntity<CarRepair> deletePerson(@RequestParam int id) {
		repairService.deleteRepair(id);
		return new ResponseEntity<CarRepair>(HttpStatus.OK);
	}
	
	

}
