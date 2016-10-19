package Zad_Gwiazdka;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HultajchochlaTest {

	PsikusImplementacja p = new PsikusImplementacja();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void exceptionCheck() throws NieudanyPsikusException {
		thrown.expect(NieudanyPsikusException.class);
		p.hultajchochla(1);
	}
	
	@Test
	public void typeCheck() throws NieudanyPsikusException {
		Integer x = new Integer(123456);
		assertThat(p.hultajchochla(x), isA(Integer.class));
	}
	

	
	@Test
	public void negativeCheck() throws NieudanyPsikusException {
		Integer x = new Integer(-45);
		assertThat(p.hultajchochla(x).toString(),either(containsString("-")).or(containsString("-54")));
	}
	
	
	@Test
	public void negativeExceptionCheck() throws NieudanyPsikusException {
		thrown.expect(NieudanyPsikusException.class);
		p.hultajchochla(-4);
	}
	
	@Test
	public void leadingZerosCheck() throws NieudanyPsikusException {
		Integer x = new Integer("000047");
		assertEquals("74",p.hultajchochla(x).toString());
	}

}
