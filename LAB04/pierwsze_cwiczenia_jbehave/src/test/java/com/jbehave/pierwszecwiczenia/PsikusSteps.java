package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class PsikusSteps {

	private PsikusImplementacja psikusImplementacja;
	private Integer result_container;
	private String error_message;
	
	@Given("a psikus implementacja")
	public void psikusSetUp() {
			psikusImplementacja = new PsikusImplementacja();
	}
	
	/* CYFROKRAD TESTING */
	
	@When("performing a method cyfrokrad with argument $argument")
	public void perfomCyfrokrad(int liczba){
		result_container = psikusImplementacja.cyfrokrad(liczba);
	}
	
	@Then("the result length should be $length")
	public void checkLength(int length) {
		assertEquals(length, Integer.toString(result_container).length());
	}
	
	@Then("the result should not be returned")
	public void checkNull() {
		assertNull(result_container);
	}
	
	@Then("the returned value should be negative")
	public void checkNegative() {
		assertThat(Math.signum(result_container), is(equalTo(-1.0F)));;
	}
	
	
	@Then("the returned type should be an integer")
	public void checkType() {
		assertThat(result_container, isA(Integer.class));
	}
	
	
	/* HULTAJCHOCHLA TESTING */
	
	@When("performing a method hultajchochla with argument $argument")
	public void performHultajchochla(int liczba) {
		try {
			result_container = psikusImplementacja.hultajchochla(liczba);
		} catch (NieudanyPsikusException e) {
			error_message = "An error have occured.";
		}
	}

	@Then("the result should be $result")
	public void checkDigitsSwapping(int result){
		assertEquals(result, result_container.intValue());
	}
	
	@Then("the sum of digits should be $result")
	public void checkSum(int result){
		int num = result_container;
		int sum = 0;
		while(num > 0){
			sum+=num%10;
			num/=10;
		}
		assertEquals(result, sum);
	}


	@Then("the error message should be generated")
	public void checkErrorMessage(){
		assertNotNull(error_message);
	}
	
	
	/* NIEKSZTAŁTEK TESTING */
	
	@When("performing a method nieksztaltek with argument $argument")
	public void performNieksztaltek(int liczba) {
		result_container = psikusImplementacja.nieksztaltek(liczba);
	}
	
	@Then("the changed value should be $result")
	public void checkChangingNumber(int result) {
		assertEquals(result,result_container.intValue());
	}
	
	@Then("the sum of changed digits should be $result")
	public void checkSumOfChangedNumber(int result) {
		int num = result_container;
		int sum = 0;
		while(num > 0){
			sum+=num%10;
			num/=10;
		}
		assertEquals(result, sum);
	}
	
	
}
