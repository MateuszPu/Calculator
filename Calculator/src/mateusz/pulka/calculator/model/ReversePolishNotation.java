package mateusz.pulka.calculator.model;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReversePolishNotation
{
	private String expressionInfix;
	private String expressionPostfix;

	public ReversePolishNotation(String expression)
	{
		StringBuilder sb = new StringBuilder(expression);
		if (expression.startsWith("-"))
		{
			sb.insert(0, "0");
		}
		expressionInfix = sb.toString();
		expressionPostfix = "";
		infixToPostfix();
	}

	private void infixToPostfix()
	{

		Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(expressionInfix, "+-*/()^", true);

		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			if (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/") || s.equals("^"))
			{
				while (!stack.empty() && priority(stack.peek()) >= priority(s))
					expressionPostfix += stack.pop() + " ";
				stack.push(s);
			}
			else if (s.equals("("))
				stack.push(s);
			else if (s.equals(")"))
			{
				while (!stack.peek().equals("("))
					expressionPostfix += stack.pop() + " ";
				stack.pop();
			}
			else
				expressionPostfix += s + " ";
		}
		while (!stack.empty())
			expressionPostfix += stack.pop() + " ";
	}

	public static int priority(String operator)
	{
		if (operator.equals("+") || operator.equals("-"))
			return 1;
		else if (operator.equals("*") || operator.equals("/"))
			return 2;
		else if (operator.equals("^"))
			return 3;
		else
			return 0;
	}

	public String toString()
	{
		return expressionPostfix;
	}
}