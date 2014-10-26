package mateusz.pulka.calculator.model;

import java.util.Stack;

public class ReversePolishNotationCalc
{
	public static Double calc(String input)
	{
		Stack<Double> numbers = new Stack<>();
		for (String number : input.split(" "))
		{
			Sign sign = Sign.find(number);
			if (sign != null)
			{
				calcSign(numbers, sign);
			}
			else
			{
				numbers.push(Double.parseDouble(number));
			}
		}
		return numbers.pop();
	}

	protected static Stack<Double> calcSign(Stack<Double> numbers, Sign sign)
	{
		numbers.push(sign.apply(numbers.pop(), numbers.pop()));
		return numbers;
	}
}