package Zad03;

import static org.junit.Assert.*;
import org.junit.Test;

public class LiczbaRzymskaTest {

	@Test
	public void toStiringIntCheck() {
		String testString = "MCMLXXXIX";
		int testInt = 1989;
		assertEquals(testString, new LiczbaRzymska(testInt).toString());
	}
	
	@Test
	public void toStiringDoubleCheck() {
		// TODO
	}
	
	@Test
	public void toStiringNegativeCheck() {
		// TODO
	}
	
	@Test
	public void toStiringStringCheck() {
		// TODO
	}
}