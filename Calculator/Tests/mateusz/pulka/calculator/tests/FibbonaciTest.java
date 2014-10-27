package mateusz.pulka.calculator.tests;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import mateusz.pulka.calculator.model.Model;
import org.junit.Test;

public class FibbonaciTest
{
	private Model model;

	@Test
	public void testCalculations()
	{
		model = new Model();

		assertEquals("fibbonacci for 1 should be 1", BigInteger.valueOf(1), model.fibonacci(1));
		assertEquals("fibbonacci for 6 should be 8", BigInteger.valueOf(8), model.fibonacci(6));
		assertEquals("fibbonacci for 25 should be 75025 ", BigInteger.valueOf(75025),
				model.fibonacci(25));
	}
}
