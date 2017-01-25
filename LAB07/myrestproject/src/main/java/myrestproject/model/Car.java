package myrestproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String brand;
	private String model;
	private int productionYear;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	@JsonIgnore
	private Person person;
	
	@OneToMany(mappedBy="car")
	@JsonIgnore
	private List<CarRepair> carRepairs;
	
	public Car() {
		super();
	}
	public Car(Integer id, String brand, String model, int productionYear,
			Person person) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.person = person;
	}
	public Car(String brand, String model, int productionYear, Person person) {
		super();
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.person = person;
	}
	public Car(String brand, String model, int productionYear) {
		super();
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	public List<CarRepair> getCarRepairs() {
		return carRepairs;
	}
	public void setCarRepairs(List<CarRepair> carRepairs) {
		this.carRepairs = carRepairs;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model
				+ ", productionYear=" + productionYear + ", person=" + person
				+ "]";
	}
	
	
	
	
}
