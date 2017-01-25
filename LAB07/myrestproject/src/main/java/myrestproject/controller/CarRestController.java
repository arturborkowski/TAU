package myrestproject.controller;

import java.util.List;

import myrestproject.model.Car;
import myrestproject.model.Person;
import myrestproject.service.CarService;
import myrestproject.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarRestController {

	@Autowired
	private CarService carService;
	@Autowired
	private PersonService personService;

	@GetMapping("/allcars")
	public ResponseEntity<List<Car>> getAll(){
		return new ResponseEntity<List<Car>>(carService.getAllCars(),HttpStatus.OK);		
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCar(@PathVariable int id) {
		return new ResponseEntity<Car>(carService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/addcar")
	public ResponseEntity<Car> addCar(
			@RequestParam String brand, 
			@RequestParam String model,
			@RequestParam int productionYear,
			@RequestParam int ownerId) {
		
		Person p = personService.findById(ownerId);
		if(p != null) {
			Car c = new Car(brand, model, productionYear, p);
			carService.addCar(c);
			return new ResponseEntity<Car>(c,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/deletecar")
	public ResponseEntity<Car> deleteCar(@RequestParam int id) {
		carService.deleteCar(id);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
	

}
