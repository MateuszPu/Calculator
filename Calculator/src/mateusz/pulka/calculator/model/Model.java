package mateusz.pulka.calculator.model;

import java.math.BigInteger;

public class Model
{
	private boolean isFinished;

	public Model()
	{

	}

	public BigInteger fib(int place)
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

	public boolean isFinished()
	{
		return isFinished;
	}

	public void setFinished(boolean isFinished)
	{
		this.isFinished = isFinished;
	}
}
