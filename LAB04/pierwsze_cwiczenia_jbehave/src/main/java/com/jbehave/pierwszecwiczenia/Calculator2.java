package com.jbehave.pierwszecwiczenia;

public class Calculator2 {
	
	private double a;
	private double b;

	public double add() {
		return a + b;
	}
	
	public double sub() {
		return a - b;
	}
	
	public double multi() {
		return a * b;
	}
	
	public double div() {
		return a/b==Double.POSITIVE_INFINITY || a/b==Double.NEGATIVE_INFINITY ? 0 : a/b;
	}
	
	public boolean greater() {
		return a > b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
}
