package mateusz.pulka.calculator.tests;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import mateusz.pulka.calculator.model.Model;
import org.junit.Test;

public class FactorialTest
{
	private Model model;

	@Test
	public void testCalculations()
	{
		model = new Model();

		assertEquals("factorial for 1 should be 1", BigInteger.valueOf(1),
				model.factorial(BigInteger.valueOf(1)));
		assertEquals("factorial for 5 should be 120", BigInteger.valueOf(120),
				model.factorial(BigInteger.valueOf(5)));
		assertEquals("factorial for 7 should be 5040", BigInteger.valueOf(5040),
				model.factorial(BigInteger.valueOf(7)));
	}
}
