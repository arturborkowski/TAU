package myrestproject.tests;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import myrestproject.builders.PersonBuilder;
import myrestproject.model.Person;
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

import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class PersonControllerIT {
	
	private static final String NAME_FIELD = "name";
	private static final String YOB_FIELD = "yob";
	private static final String NON_EXISTING_ID="9999";
	
	private static final String FIRST_PERSON_NAME = "Jan Kowalski";
	private static final int FIRST_PERSON_YOB = 1989;
	private static final String SECOND_PERSON_NAME = "Zbyszek Nowak";
	private static final int SECOND_PERSON_YOB = 1970;
	private static final String THIRD_PERSON_NAME = "Janina Malinowska";
	private static final int THIRD_PERSON_YOB = 1954;
	
	
	private static final String PERSONS_RESOURCE = "/allpersons";
	private static final String PERSON_RESOURCE = "/person/{id}";
	private static final String PERSON_ADD_RESOURCE="/addperson";
	
	private static final Person firstPerson = new PersonBuilder()
	.name(FIRST_PERSON_NAME)
	.yob(FIRST_PERSON_YOB)
	.build();
	
	private static final Person secondPerson = new PersonBuilder()
	.name(SECOND_PERSON_NAME)
	.yob(SECOND_PERSON_YOB)
	.build();
	
	private static final Person thirdPerson = new PersonBuilder()
	.name(THIRD_PERSON_NAME)
	.yob(THIRD_PERSON_YOB)
	.build();
	
	@Autowired
	private PersonService personService;
	

	@Before
	public void setUp(){
		personService.deleteAll();
		personService.addPerson(firstPerson);
		personService.addPerson(secondPerson);
	}
	
	@Test
	public void getPersonsShouldReturnBothPersons() {
	  when()
	    .get(PERSONS_RESOURCE)
	  .then()
	  	.statusCode(HttpStatus.OK.value())
	    .body(NAME_FIELD, hasItems(FIRST_PERSON_NAME,SECOND_PERSON_NAME))
	    .body(YOB_FIELD, hasItems(FIRST_PERSON_YOB,SECOND_PERSON_YOB));
	}
	
	@Test
	public void addPersonShouldReturnSavedPerson() {
	  given()
	    .body(thirdPerson)
	    .contentType(ContentType.JSON)
	  .when()
	    .post(PERSON_ADD_RESOURCE)
	  .then()
	    .statusCode(HttpStatus.CREATED.value())
	    .body(NAME_FIELD, is(THIRD_PERSON_NAME))
	    .body(YOB_FIELD, is(THIRD_PERSON_YOB));
	}
	
	@Test
	public void addPersonShouldReturnNotSupportedMediaTypeIfNonJSON() {
	  given()
	    .body(thirdPerson)
	  .when()
	    .post(PERSON_ADD_RESOURCE)
	  .then()
	    .statusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
	}
	
	@Test
	public void deletePersonShouldReturnOK() {
	   when()
	    .delete(PERSON_RESOURCE, secondPerson.getId())
	  .then()
	    .statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deletePersonShouldBeNoContentIfNonExistingID() {
	  when()
	    .delete(PERSON_RESOURCE, NON_EXISTING_ID)
	  .then()
	    .statusCode(HttpStatus.NO_CONTENT.value());
	}
	
	@After
	public void cleanUp(){
		personService.deleteAll();
	}

}
