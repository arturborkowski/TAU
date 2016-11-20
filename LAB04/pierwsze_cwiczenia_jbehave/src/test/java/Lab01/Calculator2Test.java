package Lab01;

import static org.junit.Assert.*;
import org.junit.Test;



public class Calculator2Test {
	
	private static final double DELTA = 0.001;

	Calculator2 calculator = new Calculator2();
	
	@Test
	public void addCheck() {
		double sum = calculator.add(1, 2);
		assertEquals(3, sum, DELTA);
	}
	
	@Test
	public void subCheck() {
		double submission = calculator.sub(5.34, 3.21);
		assertEquals(2.13, submission, DELTA);
	}
	
	@Test
	public void multiCheck() {
		double multi = calculator.multi(5.3, 3.21);
		assertEquals(17.013, multi, DELTA);
	}
	
	@Test
	public void divCheck() {
		double division = calculator.div(5.6, 2.8);
		assertEquals(2, division, DELTA);
	}
	
	@Test 
	public void greaterCheck() {
		boolean greater = calculator.greater(1, 5);
		assertFalse(greater);
	}
	
	@Test
	public void zeroDivisionCheck() {
		double zeroDiv = calculator.div(5, 0);
		assertEquals(0, zeroDiv, DELTA);
	}
	
}
