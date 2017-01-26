package myrestproject;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import myrestproject.model.Person;
import myrestproject.service.PersonService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PersonControllerIT {
	private static final String NAME_FIELD = "name";
	private static final String YOB_FIELD = "yob";
	private static final String FIRST_PERSON_NAME = "Jan Kowalski";
	private static final int FIRST_PERSON_YOB = 1989;
	private static final String SECOND_PERSON_NAME = "Zbyszek Nowak";
	private static final int SECOND_PERSON_YOB = 1970;
	
	private static final String PERSONS_RESOURCE = "/allpersons";
	//private static final String PERSON_RESOURCE = "/person/{id}";
	
	private static final Person FIRST_PERSON = new PersonBuilder()
	.name(FIRST_PERSON_NAME)
	.yob(FIRST_PERSON_YOB)
	.build();
	
	private static final Person SECOND_PERSON = new PersonBuilder()
	.name(SECOND_PERSON_NAME)
	.yob(SECOND_PERSON_YOB)
	.build();
	
	@Autowired
	private PersonService personService;
	

	@Before
	public void setUp(){
		personService.deleteAll();
		personService.addPerson(FIRST_PERSON);
		personService.addPerson(SECOND_PERSON);
	}
	
	@Test
	public void getItemsShouldReturnBothItems() {
	  when()
	    .get(PERSONS_RESOURCE)
	  .then()
	  	.statusCode(200)
	    .body(NAME_FIELD, hasItems(FIRST_PERSON_NAME,SECOND_PERSON_NAME))
	    .body(YOB_FIELD, hasItems(FIRST_PERSON_YOB,SECOND_PERSON_YOB));
	}
}
