package myrestproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import myrestproject.dao.PersonRepository;
import myrestproject.model.Person;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();
		for(Person p : personRepository.findAll())
			persons.add(p);
		return persons;
	}
	
	public void addPerson(Person p) {
		personRepository.save(p);
	}
	
	public void deletePerson(int id) {
		personRepository.delete(id);
	}
	
	public Person findById(int id) {
		return personRepository.findOne(id);
	}
	
	public void deleteAll(){
		personRepository.deleteAll();
	}

}
