package com.jbehave.pierwszecwiczenia;

public class Calculator2 {
	

	public double add(double a, double b) {
		return a + b;
	}
	
	public double sub(double a, double b) {
		return a - b;
	}
	
	public double multi(double a, double b) {
		return a * b;
	}
	
	public double div(double a, double b) {
		return a/b==Double.POSITIVE_INFINITY ? 0 : a/b;
	}
	
	public boolean greater(double a, double b) {
		return a > b;
	}
}
