package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class Calculator2Steps {

	private final double PRECISION = 0.001d;
	private Calculator2 calc;
	
	@Given("a calculator")
	public void calulatorSetup(){
		calc = new Calculator2();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(double a, double b){
		calc.setA(a);
		calc.setB(b);
	}
	
    @Then("adding should return $result")
	public void shouldAdd(double result){
		assertEquals(result, calc.add(),PRECISION);
	}
    
    @Then("subtracting should return $result")
  	public void shouldSubstract(double result){
  		assertEquals(result, calc.sub(),PRECISION);
  	}
    
    @Then("multiplying should return $result")
    public void shouldMultiply(double result) {
    	assertEquals(result, calc.multi(),PRECISION);
    }
    
    @Then("division should return $result")
    public void shouldDivide(double result) {
    	assertEquals(result, calc.div(),PRECISION);
    }
    
    @Then("comparison should return $result")
    public void shouldCompare(boolean result) {
    	assertEquals(result, calc.greater());
    }
	
}
