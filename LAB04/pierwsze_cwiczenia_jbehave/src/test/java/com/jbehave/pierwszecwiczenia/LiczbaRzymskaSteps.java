package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;


public class LiczbaRzymskaSteps {

	private LiczbaRzymska lRzymska;
	
	@Given("a liczba rzymska with argument $liczba")
	public void liczbaRzymskaSetUp(int liczba) {
			lRzymska = new LiczbaRzymska(liczba);
	}
	@Then("the result should be $roman")
	public void performToString(String roman){
		assertEquals(roman, lRzymska.toString());
	}
	
	@Given("a double liczba rzymska with argument $liczba")
	public void liczbaDoubleRzymskaSetUp(double liczba) {
			lRzymska = new LiczbaRzymska(liczba);
	}
	@Then("the double result should be $roman")
	public void performDoubleToString(String roman){
		assertEquals(roman, lRzymska.toString());
	}
	
	@Given("a string liczba rzymska with argument $liczba")
	public void liczbaStringRzymskaSetUp(String liczba) {
			lRzymska = new LiczbaRzymska(liczba);
	}
	@Then("the string result should be $roman")
	public void performStringToString(String roman){
		assertEquals(roman, lRzymska.toString());
	}
	

	
}
