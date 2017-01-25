package myrestproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private int yob;
	
	@OneToMany(mappedBy="person")
	private List<Car> cars;
		
	
	public Person() {}

	public Person(Integer id, String name, int yob) {
		super();
		this.id = id;
		this.name = name;
		this.yob = yob;
	}


	public Person(String name, int yob) {
		super();
		this.name = name;
		this.yob = yob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}
	

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", yob=" + yob + "]";
	}
	
	
	


	

}
