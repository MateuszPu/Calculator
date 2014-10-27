package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;
import javax.swing.JOptionPane;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.model.ReversePolishNotation;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.ToolsMenu;

public class ToolsButtonsListeners extends SuperListeners
{
	private ToolsMenu toolsMenu;
	private StringBuilder medianNumbers;

	public ToolsButtonsListeners(MainFrame view, Model model)
	{
		super(view, model);
		medianNumbers = new StringBuilder();
		toolsMenu = view.getToolsMenu();

		toolsMenu.addAdditionListener(new AdditionListener());
		toolsMenu.addSubtractionListener(new SubtractionListner());
		toolsMenu.addMultiplicationListener(new MultiplicationListener());
		toolsMenu.addDivisionListener(new DivisionListener());
		toolsMenu.addDotListener(new DotListener());
		toolsMenu.addSquaredListener(new PowerListener());
		toolsMenu.addFibboListener(new FibboListener());
		toolsMenu.addMedianListener(new MedianListener());
		toolsMenu.addFactorialListener(new FactorialListener());
		toolsMenu.addResultListener(new ResultListener());
		toolsMenu.addBackspaceListener(new BackspaceListener());
	}

	class AdditionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setMathExpressionToDisplay("+");
		}
	}

	class SubtractionListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setMathExpressionToDisplay("-");
		}
	}

	class MultiplicationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setMathExpressionToDisplay("*");
		}
	}

	class DivisionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setMathExpressionToDisplay("/");
		}
	}

	class PowerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setMathExpressionToDisplay("^");
		}
	}

	class DotListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!(hasNumberDot(lastNumberInExpression()) || getDisplay().getText().isEmpty() || isLastSignMathExpression()))
			{
				getDisplay().append(".");
				getModel().setCalculationFinished(false);
			}
		}
	}

	class FibboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			final int maxValueForFibbo = 99999; // for greater integer
												// application
			// works too slow
			String expressionInDisplay = getDisplay().getText();
			try
			{
				int textFromDisplayToInteger = Integer.parseInt(expressionInDisplay);
				if (textFromDisplayToInteger <= maxValueForFibbo && textFromDisplayToInteger > 0)
				{
					saveHistory(" Fibbo of: ");
					getDisplay().setText("" + getModel().fibonacci(textFromDisplayToInteger));
				}
				else
				{
					JOptionPane.showMessageDialog(getView(), "Really do you want Fibonacci for "
							+ expressionInDisplay + "? \n Max value for Fibonacci is: "
							+ maxValueForFibbo + "\n Minimum value for factorial is: 1");
				}

			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(getView(), "Number should be an integer");
			}
			getModel().setCalculationFinished(true);
		}
	}

	class MedianListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double doubleFromText;
			try
			{
				String numberInDisplay = getDisplay().getText();
				medianNumbers.append(numberInDisplay);
				medianNumbers.append(" ");
				doubleFromText = Double.parseDouble(numberInDisplay);
				getModel().getArrayForMedian().add(doubleFromText);
			}
			catch (NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(getView(),
						"You should provide only one number not expression");
			}

			getModel().setCalculationFinished(true);
		}
	}

	class FactorialListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			final int maxValueForFactorial = 9999; // for greater integer
													// application
			// works too slow
			String expressionInDisplay = getDisplay().getText();

			try
			{
				Long textFromDisplayToLong = Long.parseLong(expressionInDisplay);
				if (textFromDisplayToLong <= maxValueForFactorial && textFromDisplayToLong > 0)
				{
					saveHistory(" Factorial of: ");
					BigInteger numberConvertFromDisplay = BigInteger.valueOf(textFromDisplayToLong);
					getDisplay().setText("" + getModel().factorial(numberConvertFromDisplay));
				}
				else
				{
					JOptionPane.showMessageDialog(getView(), "Really do you want Fibonacci for "
							+ expressionInDisplay + "? \n Maximum value for factorial is: "
							+ maxValueForFactorial + "\n Minimum value for factorial is: 1");
					;
				}
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(getView(), "Number should be an integer");
			}
			getModel().setCalculationFinished(true);
		}
	}

	class ResultListener implements ActionListener
	{
		NumberFormat nf = new DecimalFormat("##.##########");

		public void actionPerformed(ActionEvent e)
		{
			if (!getModel().getArrayForMedian().isEmpty())
			{
				String result = nf.format(getModel().median());
				getDisplay().setText(result);
				getModel().getArrayForMedian().clear();
				System.out.println(medianNumbers.toString());

				getModel().addHistoryToList(medianNumbers.toString(), "Median of: ");
				displayHistoryInCombobox();
			}
			else
			{
				try
				{
					if (!isLastSignMathExpression())
					{
						saveHistory(" ");
						String expressionInDisplay = getDisplay().getText();
						ReversePolishNotation revPolishNotation = new ReversePolishNotation(
								expressionInDisplay);
						String result = nf.format(getModel()
								.getResult(revPolishNotation.toString()));
						getDisplay().setText(result);
						getModel().setCalculationFinished(true);
					}
				}
				catch (NumberFormatException event)
				{
					getDisplay().setText("Infinity");
				}
			}
		}
	}

	class BackspaceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (getDisplay().getText().length() > 0)
			{
				if (lastCharacter().equals(")"))
				{
					getView().rightBracketShouldBeUsed();
				}

				if (lastCharacter().equals("("))
				{
					getView().leftBracketShouldBeUsed();
				}
				getDisplay().setText(expressionWithoutLastCharacter());
			}
		}
	}

	private void setMathExpressionToDisplay(String mathExpression)
	{
		if (!getDisplay().getText().isEmpty())
		{
			if (isLastSignMathExpression())
			{
				getDisplay().setText(expressionWithoutLastCharacter());
				getDisplay().append(mathExpression);
			}
			else
			{
				getDisplay().append(mathExpression);
				getModel().setCalculationFinished(false);
			}
		}
	}

	private String expressionWithoutLastCharacter()
	{
		String expressionInDisplay = getDisplay().getText();
		int beginIndex = 0;
		int endIngex = expressionInDisplay.length() - 1;
		return expressionInDisplay.substring(beginIndex, endIngex);
	}

	private boolean hasNumberDot(String number)
	{
		if (number.contains("."))
		{
			return true;
		}
		return false;
	}

	private String lastNumberInExpression()
	{
		String expressionInDisplay = getDisplay().getText();
		return expressionInDisplay.substring(placeOfLastMathSign(), expressionInDisplay.length());
	}

	private int placeOfLastMathSign()
	{
		String expressionInDisplay = getDisplay().getText();
		int lengthOfExpression = expressionInDisplay.length();

		while (lengthOfExpression > 0)
		{
			String lastCharacter = expressionInDisplay.substring(lengthOfExpression - 1,
					lengthOfExpression);
			if (lastCharacter.equals("*") || lastCharacter.equals("/") || lastCharacter.equals("+")
					|| lastCharacter.equals("-") || lastCharacter.equals("^"))
			{
				return lengthOfExpression;
			}

			lengthOfExpression--;
		}

		return lengthOfExpression;
	}

	private void saveHistory(String separator)
	{
		String illegalExpression = "/0";
		String expressionInDisplay = getDisplay().getText();
		if (!expressionInDisplay.contains(illegalExpression))
		{
			getModel().addHistoryToList(expressionInDisplay, separator);
			displayHistoryInCombobox();
		}
	}

	private void displayHistoryInCombobox()
	{
		Stack<String> historyOfExpression = getModel().getHistoryOfExpression();
		String lastSuccesExpression = historyOfExpression.peek();
		getView().getHistoryMenu().addExpressionToCombobox(lastSuccesExpression);
	}
}
