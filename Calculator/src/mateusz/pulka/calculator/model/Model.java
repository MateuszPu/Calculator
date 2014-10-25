package mateusz.pulka.calculator.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Model
{
	private boolean isFinished;

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

	// public BigDecimal factorial(BigDecimal n)
	// {
	// if (n.equals(BigDecimal.ZERO))
	// return BigDecimal.ONE;
	// else
	// return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
	// }

	public boolean isFinished()
	{
		return isFinished;
	}

	public void setFinished(boolean isFinished)
	{
		this.isFinished = isFinished;
	}
}
