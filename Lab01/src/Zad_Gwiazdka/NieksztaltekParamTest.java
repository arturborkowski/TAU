package Zad_Gwiazdka;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NieksztaltekParamTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{724,124}, 
				{1234,1284}, 
				{65401,95401},
				{1111,1111}
		});
	}
	
	private Integer input;
	private Integer expected;
	public NieksztaltekParamTest(Integer input, Integer expected) {
		this.input = input;
		this.expected = expected;
	}
	
	PsikusImplementacja p = new PsikusImplementacja();
	
	@Test
	public void parametrizedTest() {
		assertEquals(expected, p.nieksztaltek(input));
	}
	
	

}
