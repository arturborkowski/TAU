package com.example.jbehavedemo;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorSteps {
	
	private Calculator calc;
	
	@Given("a calculator with arguments $l and $r")
	public void calulatorSetup(int l, int r){
		calc = new Calculator(l, r);
	}
	
	@When("perform adding")
	public void performAdding(){
		calc.add();
	}
	
	@When("perform subtracting")
	public void performSubtracting(){
		calc.subtract();
	}
	
    @Then("result should be $result")
	public void result(int result){
		assertEquals(result, new Double(calc.getLastResult()).intValue());
	}
	
	@Given("a calculator")
	public void calulatorSetup(){
		calc = new Calculator();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(int a, int b){
		calc.setLeftOp(a);
		calc.setRightOp(b);
	}
	
    @Then("adding should return $result")
	public void shouldAdd(int result){
		assertEquals(result, calc.add());
	}
    
    @Then("subtracting should return $result")
  	public void shouldSubstract(int result){
  		assertEquals(result, calc.subtract());
  	}
}
