package myrestproject.tests;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import myrestproject.builders.CarBuilder;
import myrestproject.builders.PersonBuilder;
import myrestproject.model.Car;
import myrestproject.model.Person;
import myrestproject.service.CarService;
import myrestproject.service.PersonService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class CarControllerIT {
	
	private static final String BRAND_FIELD = "brand";
	private static final String MODEL_FIELD = "model";
	private static final String YOP_FIELD = "productionYear";
	
	private static final String FIRST_PERSON_NAME = "Stasio Sójka";
	private static final int FIRST_PERSON_YOB = 1989;
	private static final String SECOND_PERSON_NAME = "Wiesiek Długopis";
	private static final int SECOND_PERSON_YOB = 1970;
	
	private static final String FIRST_CAR_BRAND = "Opel";
	private static final String FIRST_CAR_MODEL = "Astra";
	private static final int FIRST_CAR_PRODUCTION_YEAR = 2001;
	private static final String SECOND_CAR_BRAND = "Daewoo";
	private static final String SECOND_CAR_MODEL = "Leganza";
	private static final int SECOND_CAR_PRODUCTION_YEAR = 1995;
	
	
	private static final String CARS_RESOURCE = "/allcars";
	private static final String CAR_RESOURCE = "/car/{id}";
	private static final String ADD_CAR_RESOURCE = "/addcar";
	
	private static final Person firstPerson = new PersonBuilder()
	.name(FIRST_PERSON_NAME)
	.yob(FIRST_PERSON_YOB)
	.build();
	
	private static final Person secondPerson = new PersonBuilder()
	.name(SECOND_PERSON_NAME)
	.yob(SECOND_PERSON_YOB)
	.build();
	
	private static final Car firstCar = new CarBuilder()
	.brand(FIRST_CAR_BRAND)
	.model(FIRST_CAR_MODEL)
	.productionYear(FIRST_CAR_PRODUCTION_YEAR)
	.person(firstPerson)
	.build();
	
	private static final Car secondCar = new CarBuilder()
	.brand(SECOND_CAR_BRAND)
	.model(SECOND_CAR_MODEL)
	.productionYear(SECOND_CAR_PRODUCTION_YEAR)
	.person(secondPerson)
	.build();
	
	@Autowired
	private CarService carService;
	@Autowired 
	private PersonService personService;
	

	@Before
	public void setUp(){
		carService.deleteAll();
		personService.deleteAll();
		personService.addPerson(firstPerson);
		personService.addPerson(secondPerson);
		carService.addCar(firstCar);
		carService.addCar(secondCar);
	}
	
	@Test
	public void getCarsShouldReturnBothCars() {
	  when()
	    .get(CARS_RESOURCE)
	  .then()
	  	.statusCode(HttpStatus.OK.value())
	    .body(BRAND_FIELD, hasItems(FIRST_CAR_BRAND,SECOND_CAR_BRAND))
	    .body(MODEL_FIELD, hasItems(FIRST_CAR_MODEL,SECOND_CAR_MODEL))
	    .body(YOP_FIELD, hasItems(FIRST_CAR_PRODUCTION_YEAR,SECOND_CAR_PRODUCTION_YEAR));
	}

	
	@After
	public void cleanUp(){
		carService.deleteAll();
		personService.deleteAll();
	}

}
