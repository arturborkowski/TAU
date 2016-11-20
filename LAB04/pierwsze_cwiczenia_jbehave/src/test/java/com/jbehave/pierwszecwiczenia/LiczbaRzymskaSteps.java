package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.*;
/*import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;*/
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;


public class LiczbaRzymskaSteps {

	private LiczbaRzymska lRzymska;
	/*private Throwable throwable;*/
	
	@Given("a liczba rzymska with argument $liczba")
	public void liczbaRzymskaSetUp(int liczba) {
		try {
			lRzymska = new LiczbaRzymska(liczba);
		} catch (NullPointerException e) {
			/*throwable = e;*/
		}
	}
	
	@Then("the result should be $roman")
	public void performToString(String roman){
		assertEquals(roman, lRzymska.toString());
	}
	
	/*@Then("an exception should be thrown")
	public void performExceptionToString(){
		assertThat(throwable,equalTo(new NullPointerException());
	}
	
	 private Matcher<Throwable> myExceptionMatcher(Exception e) {
		return new BaseMatcher<Throwable>() {

			public boolean matches(Object item) {
				// TODO Auto-generated method stub
				return false;
			}

			public void describeTo(Description description) {
				// TODO Auto-generated method stub
				
			}
			
		};
	 }*/
		    
		 
}
