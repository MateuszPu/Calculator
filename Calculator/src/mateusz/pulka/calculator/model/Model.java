package mateusz.pulka.calculator.model;

import java.math.BigInteger;
import java.util.Arrays;

public class Model
{
	private boolean isCalculationFinished;
	private boolean isMathExpressionUsed;
	private boolean isDotUsed;
	private double[] arrayForMedian;

	public Model()
	{
	}

	public BigInteger fibonacci(int place)
	{
		BigInteger prev1 = new BigInteger("0");
		BigInteger prev2 = new BigInteger("1");
		while (place-- > 1)
		{
			BigInteger t = prev2;
			prev2 = prev1.add(prev2);
			prev1 = t;
		}
		return prev2;
	}

	public BigInteger factorial(BigInteger n)
	{
		BigInteger result = BigInteger.ONE;

		while (!n.equals(BigInteger.ZERO))
		{
			result = result.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}
		return result;
	}

	public double median(double[] medianArray)
	{
		Arrays.sort(medianArray);
		int middle = medianArray.length / 2;
		if (medianArray.length % 2 == 1)
		{
			return medianArray[middle];
		}
		else
		{
			return (medianArray[middle - 1] + medianArray[middle]) / 2.0;
		}
	}

	public boolean isCalculationFinished()
	{
		return isCalculationFinished;
	}

	public void setCalculationFinished(boolean isFinished)
	{
		this.isCalculationFinished = isFinished;
	}

	public boolean isMathExpressionUsed()
	{
		return isMathExpressionUsed;
	}

	public void setMathExpressionUsed(boolean isMathExpressionUsed)
	{
		this.isMathExpressionUsed = isMathExpressionUsed;
	}

	public boolean isDotUsed()
	{
		return isDotUsed;
	}

	public void setDotUsed(boolean isDotUsed)
	{
		this.isDotUsed = isDotUsed;
	}

	public double[] getArrayForMedian()
	{
		return arrayForMedian;
	}

	public void setArrayForMedian(double[] arrayForMedian)
	{
		this.arrayForMedian = arrayForMedian;
	}
}
