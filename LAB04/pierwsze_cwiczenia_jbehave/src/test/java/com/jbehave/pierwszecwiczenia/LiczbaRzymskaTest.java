package com.jbehave.pierwszecwiczenia;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jbehave.pierwszecwiczenia.LiczbaRzymska;

public class LiczbaRzymskaTest {

	@Test
	public void toStringIntCheck() {
		String testString = "MCMLXXXIX";
		int testInt = 1989;
		assertEquals(testString, new LiczbaRzymska(testInt).toString());
	}
	
	@Test
	public void toStringDoubleCheck() {
		String testString = "II";
		double testDouble = 2.43d;
		assertEquals(testString, new LiczbaRzymska(testDouble).toString());
	}
	
	@Test
	public void toStringNegativeCheck() {
		String testString = "XV";
		int negativeTest = -15;
		assertEquals(testString, new LiczbaRzymska(negativeTest).toString());
	}
	
	@Test
	public void toStringStringCheck() {
		String testString="XIX";
		String testInputString="19";
		assertEquals(testString, new LiczbaRzymska(testInputString).toString());
	}
	
	@Test(expected = NumberFormatException.class)
	public void toStringInvalidStringCheck() {
		String testInputString="test";
		new LiczbaRzymska(testInputString).toString();
	}
}
