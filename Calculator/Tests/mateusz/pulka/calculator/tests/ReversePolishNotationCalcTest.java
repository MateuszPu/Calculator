package mateusz.pulka.calculator.tests;

import static org.junit.Assert.assertEquals;
import mateusz.pulka.calculator.model.ReversePolishNotation;
import mateusz.pulka.calculator.model.ReversePolishNotationCalc;
import org.junit.Test;

public class ReversePolishNotationCalcTest
{
	private ReversePolishNotation rpn;

	@Test
	public void testAdd()
	{
		rpn = new ReversePolishNotation("2+5");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2+5 should be 7", 7, result1);

		rpn = new ReversePolishNotation("12+8");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 12+8 should be 20", 20, result2);

		rpn = new ReversePolishNotation("122+254");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 122+254 should be 376", 376, result3);
	}

	@Test
	public void testRemove()
	{
		rpn = new ReversePolishNotation("2-5");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2-5 should be -37", -3, result1);

		rpn = new ReversePolishNotation("12-8");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 12-8 should be 4", 4, result2);

		rpn = new ReversePolishNotation("122-254");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 122-254 should be -132", -132, result3);
	}

	@Test
	public void testMultiply()
	{
		rpn = new ReversePolishNotation("1*1");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1*1 should be 1", 1, result1);

		rpn = new ReversePolishNotation("2*5");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2*5 should be 10", 10, result2);

		rpn = new ReversePolishNotation("12*8");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 12*8 should be 96", 96, result3);

		rpn = new ReversePolishNotation("122*254");
		int result4 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 122*254should be 30 988", 30988, result4);

		rpn = new ReversePolishNotation("1*0");
		int result5 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1*0 should be 0", 0, result5);
	}

	@Test
	public void testDivide()
	{
		rpn = new ReversePolishNotation("10/2");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 10/2 should be 5", 5, result1);

		rpn = new ReversePolishNotation("2/2");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2/2 should be 1", 1, result2);
	}

	@Test
	public void testPower()
	{
		rpn = new ReversePolishNotation("10^2");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 10^2 should be 100", 100, result1);

		rpn = new ReversePolishNotation("1^0");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1^0 should be 1", 1, result2);

		rpn = new ReversePolishNotation("1^1");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1^1 should be 1", 1, result3);

		rpn = new ReversePolishNotation("1^125");
		int result4 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1^125 should be 1", 1, result4);

		rpn = new ReversePolishNotation("3^3");
		int result5 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 3^3 should be 27", 27, result5);

		rpn = new ReversePolishNotation("2^6");
		int result6 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2^6 should be 64", 64, result6);
	}

	@Test
	public void testNegativeValues()
	{
		rpn = new ReversePolishNotation("-5*5");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for -5*5 should be -25", -25, result1);

		rpn = new ReversePolishNotation("-5+2*5");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for -5+2*5 should be 5", 5, result2);
	}

	@Test
	public void testMathExpressionOrder()
	{
		rpn = new ReversePolishNotation("2+2*2");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2+2*2 should be 6", 6, result1);

		rpn = new ReversePolishNotation("(2+2)*2");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for (2+2)*2 should be 8", 8, result2);

		rpn = new ReversePolishNotation("(2+2)^2");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for (2+2)^2 should be 16", 16, result3);

		rpn = new ReversePolishNotation("2+2^2");
		int result4 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 2+2^2 should be 6", 6, result4);
	}

	@Test
	public void testDecimalPlacesAdd()
	{
		rpn = new ReversePolishNotation("0.50+0.35");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.50+0.35 should be 0.85", 0.85, result1, 2);

		rpn = new ReversePolishNotation("0.124546+0.67521");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.124546+0.67521 should be 0.7998", 0.7998, result2, 4);

		rpn = new ReversePolishNotation("256.54+132.21");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 256.54 + 132.21 should be 388.75", 388.75, result3, 2);
	}

	@Test
	public void testDecimalPlacesRemove()
	{
		rpn = new ReversePolishNotation("0.50-0.35");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.50-0.35 should be 0.15", 0.15, result1, 2);

		rpn = new ReversePolishNotation("0.124546-0.67521");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.124546-0.67521 should be -0.550664", -0.550664, result2, 6);
	}

	@Test
	public void testDecimalPlacesMultiply()
	{
		rpn = new ReversePolishNotation("0.50*0.35");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.50*0.35 should be 0.175", 0.175, result1, 3);

		rpn = new ReversePolishNotation("1*0.3555");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1*0.3555 should be 0.3555", 0.3555, result2, 4);
	}

	@Test
	public void testDecimalPlacesDivide()
	{
		rpn = new ReversePolishNotation("0.50/0.35");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.50/0.35 should be 1.42857", 1.42857, result1, 5);

		rpn = new ReversePolishNotation("1/0.3555");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1/0.3555 should be 2.8129", 2.8129, result2, 4);
	}

	@Test
	public void testDecimalPlacesPower()
	{
		rpn = new ReversePolishNotation("0.50^0.35");
		int result1 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 0.50^0.35 should be 0.784584", 0.784584, result1, 6);

		rpn = new ReversePolishNotation("1^0.3555");
		int result2 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 1^0.3555 should be 1", 1, result2, 4);

		rpn = new ReversePolishNotation("5^0.3555");
		int result3 = ReversePolishNotationCalc.calc(rpn.toString()).intValue();
		assertEquals("result for 5^0.3555 should be 1.77208", 1.77208, result3, 4);
	}

}
