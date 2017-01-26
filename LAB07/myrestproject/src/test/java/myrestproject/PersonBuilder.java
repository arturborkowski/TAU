package myrestproject;

import myrestproject.model.Person;

public class PersonBuilder {
	private Person person = new Person();
	
	public PersonBuilder id(int id) {
		person.setId(id);
		return this;
	}
	
	public PersonBuilder name(String name) {
		person.setName(name);
		return this;
	}
	
	public PersonBuilder yob(int yob) {
		person.setYob(yob);
		return this;
	}
	
	public Person build() {
		return person;
	}
	
}
