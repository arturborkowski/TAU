package Zad_Gwiazdka;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class CyfrokradTest {

	PsikusImplementacja p = new PsikusImplementacja();
	
	@Test
	public void lengthCheck() {
		Integer x = new Integer(12345);
		assertEquals(4, p.cyfrokrad(x).toString().length());
	}
	
	@Test
	public void typeCheck() {
		Integer x = new Integer(9999);
		assertThat(p.cyfrokrad(x), isA(Integer.class));
	}
	
	@Test
	public void nullCheck() {
		Integer x = new Integer(5);
		assertNull(p.cyfrokrad(x));
	}
	
	@Test
	public void negativeCheck() {
		Integer x = new Integer(-43);
		assertThat(Math.signum(p.cyfrokrad(x)), is(equalTo(-1.0F)));
	}
	
	@Test
	public void negativeNullCheck() {
		Integer x = new Integer(-4);
		assertNull(p.cyfrokrad(x));
	}
	
	@Test
	public void leadingZerosCheck() {
		Integer x = new Integer("000047");
		assertEquals(1, p.cyfrokrad(x).toString().length());
	}

}
