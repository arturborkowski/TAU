package Lab01;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NieksztaltekPlainTest {

	PsikusImplementacja p = new PsikusImplementacja();
	
	@Test
	public void negativeNumber() {
		assertThat(Math.signum(p.nieksztaltek(-564)), is(equalTo(-1.0F)));
	}
	
	@Test
	public void onlyOneChange() {
		List<Integer> listOfPossibleResults = new ArrayList<Integer>(
				Arrays.asList(
						876,
						316,
						379
						));
		assertTrue(listOfPossibleResults.contains(p.nieksztaltek(376)));
	}
	
}
