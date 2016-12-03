package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class PsikusSteps {

	private PsikusImplementacja psikusImplementacja;
	private Integer result_container;
	
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
	
	@Then("the result should be null")
	public void checkNull() {
		assertNull(result_container);
	}
	
	@Then("the result should be negative")
	public void checkNegative() {
		assertThat(Math.signum(result_container), is(equalTo(-1.0F)));;
	}
	
	@Then("the result should be an integer")
	public void checkType() {
		assertThat(result_container, isA(Integer.class));
	}
	
	
	/* HULTAJCHOCHLA TESTING */
	
	@When("performing a method hultajchochla with argument $argument")
	public void performHultajchochla(int liczba) throws NieudanyPsikusException{
		result_container = psikusImplementacja.hultajchochla(liczba);
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
	

	
	

	
}
