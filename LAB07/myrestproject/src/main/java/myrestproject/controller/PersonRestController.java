package myrestproject.controller;

import java.util.List;

import myrestproject.model.Person;
import myrestproject.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonRestController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
	
	@GetMapping("/allpersons")
	public ResponseEntity<List<Person>> getAll(){
		return new ResponseEntity<List<Person>>(personService.getAllPersons(),HttpStatus.OK);		
	}
	

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return new ResponseEntity<Person>(personService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/addperson")
	public ResponseEntity<Person> addPerson(@RequestParam String name, @RequestParam int yob) {
		Person p = new Person(name, yob);
		personService.addPerson(p);
		return new ResponseEntity<Person>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/addperson",method=RequestMethod.POST)
	public ResponseEntity<Person> postPerson(@RequestBody Person person) {
		personService.addPerson(person);
		return new ResponseEntity<Person>(person,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/person/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Person> deletePerson(@PathVariable int id) {
		if(personService.findById(id) != null) {
			personService.deletePerson(id);
			return new ResponseEntity<Person>(HttpStatus.OK);
		}
		else return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}
	
	

}
