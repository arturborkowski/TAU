package com.example.jbehavedemo;

public class Calculator {
	
	private double lastResult;
	
	private int leftOp;
	private int rightOp;
	
	public Calculator(int leftOp, int rightOp) {
		super();
		this.leftOp = leftOp;
		this.rightOp = rightOp;
	}
	
	public Calculator() {
		super();
	}

	public double getLastResult() {
		return lastResult;
	}

	public int add(){
		lastResult = leftOp + rightOp;
		return new Double(lastResult).intValue();
	}
	
	public int subtract(){
		lastResult = leftOp - rightOp;
		return new Double(lastResult).intValue();
	}

	public int getLeftOp() {
		return leftOp;
	}

	public void setLeftOp(int leftOp) {
		this.leftOp = leftOp;
	}

	public int getRightOp() {
		return rightOp;
	}

	public void setRightOp(int rightOp) {
		this.rightOp = rightOp;
	}
}
