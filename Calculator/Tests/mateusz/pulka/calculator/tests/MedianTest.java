package mateusz.pulka.calculator.tests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import mateusz.pulka.calculator.model.Model;
import org.junit.Test;

public class MedianTest
{
	private Model model;

	@Test
	public void testCalculations()
	{
		model = new Model();
		Double[] array1 =
		{ 1., 2., 3. };
		model.setArrayForMedian(new ArrayList<Double>(Arrays.asList(array1)));
		assertEquals("median of 1 2 3 should be 2", 2, model.median(), 0);

		Double[] array2 =
		{ 1.23, 2.53, 5.46 };
		model.setArrayForMedian(new ArrayList<Double>(Arrays.asList(array2)));
		assertEquals("median of 1.23, 2.53, 5.46 should be 2.53", 2.53, model.median(), 2);

		Double[] array3 =
		{ 1.23, 2.53, 5.46, 7.3, 9.41, 11.53 };
		model.setArrayForMedian(new ArrayList<Double>(Arrays.asList(array3)));
		assertEquals("median of 1.23, 2.53, 5.46, 7.3, 9.41, 11.53 should be 6.38", 6.38,
				model.median(), 2);
	}
}
