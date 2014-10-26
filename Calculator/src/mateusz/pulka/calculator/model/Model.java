package mateusz.pulka.calculator.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Model
{
	private boolean isCalculationFinished;
	private ArrayList<Double> arrayForMedian = new ArrayList<Double>();

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

	public double median()
	{
		Double[] listForMedian = new Double[arrayForMedian.size()];
		arrayForMedian.toArray(listForMedian);
		Arrays.sort(listForMedian);

		int middle = listForMedian.length / 2;
		if (listForMedian.length % 2 == 1)
		{
			return listForMedian[middle];
		}
		else
		{
			return (listForMedian[middle - 1] + listForMedian[middle]) / 2.0;
		}
	}

	public double getResult(String expressionPostfix)
	{
		return ReversePolishNotationCalc.calc(expressionPostfix);
	}

	public boolean isCalculationFinished()
	{
		return isCalculationFinished;
	}

	public void setCalculationFinished(boolean isFinished)
	{
		this.isCalculationFinished = isFinished;
	}

	public ArrayList<Double> getArrayForMedian()
	{
		return arrayForMedian;
	}

	public void setArrayForMedian(ArrayList<Double> arrayForMedian)
	{
		this.arrayForMedian = arrayForMedian;
	}
}
