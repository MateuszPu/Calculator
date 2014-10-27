package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.model.ReversePolishNotation;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.ToolsMenu;

public class ToolsButtonsListeners
{
	private Model model;
	private MainFrame view;
	private ToolsMenu toolsMenu;
	private JTextArea display;

	public ToolsButtonsListeners(MainFrame view, Model model)
	{
		this.view = view;
		this.model = model;
		toolsMenu = view.getToolsMenu();
		display = view.getDisplay();

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
			if (!(hasNumberDot(lastNumberInExpression()) || display.getText().isEmpty() || isLastSignMathExpression()))
			{
				display.append(".");
				model.setCalculationFinished(false);
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
			String textInDisplay = display.getText();
			try
			{
				int textFromDisplayToInteger = Integer.parseInt(textInDisplay);
				if (textFromDisplayToInteger <= maxValueForFibbo && textFromDisplayToInteger > 0)
				{
					display.setText("" + model.fibonacci(textFromDisplayToInteger));
				}
				else
				{
					JOptionPane.showMessageDialog(view, "Really do you want Fibonacci for "
							+ textInDisplay + "? \n Max value for Fibonacci is: "
							+ maxValueForFibbo + "\n Minimum value for factorial is: 1");
				}

			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(view, "Number should be an integer");
			}
			model.setCalculationFinished(true);
		}
	}

	class MedianListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double doubleFromText;
			try
			{
				String textInDisplay = display.getText();
				doubleFromText = Double.parseDouble(textInDisplay);
				model.getArrayForMedian().add(doubleFromText);
			}
			catch (NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(view, "You should provide only one number");
			}

			model.setCalculationFinished(true);
		}
	}

	class FactorialListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			final int maxValueForFactorial = 9999; // for greater integer
													// application
			// works too slow
			String textInDisplay = display.getText();

			try
			{
				Long textFromDisplayToLong = Long.parseLong(textInDisplay);
				if (textFromDisplayToLong <= maxValueForFactorial && textFromDisplayToLong > 0)
				{
					BigInteger numberConvertFromDisplay = BigInteger.valueOf(textFromDisplayToLong);
					display.setText("" + model.factorial(numberConvertFromDisplay));
				}
				else
				{
					JOptionPane.showMessageDialog(view, "Really do you want Fibonacci for "
							+ textInDisplay + "? \n Maximum value for factorial is: "
							+ maxValueForFactorial + "\n Minimum value for factorial is: 1");
					;
				}
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(view, "Number should be an integer");
			}
			model.setCalculationFinished(true);
			model.setCalculationFinished(false);
		}
	}

	class ResultListener implements ActionListener
	{
		NumberFormat nf = new DecimalFormat("##.############");

		public void actionPerformed(ActionEvent e)
		{
			if (!model.getArrayForMedian().isEmpty())
			{
				String result = nf.format(model.median());
				display.setText(result);
				model.getArrayForMedian().clear();
			}
			else
			{
				try
				{
					String expression = display.getText();

					model.addHistoryToList(expression);
					Stack<String> historyOfExpression = model.getHistoryOfExpression();
					String lastSuccesExpression = historyOfExpression.peek();
					view.getHistoryMenu().addExpressionToCombobox(lastSuccesExpression);

					ReversePolishNotation revPolishNotation = new ReversePolishNotation(expression);
					String result = nf.format(model.getResult(revPolishNotation.toString()));
					display.setText(result);
				}
				catch (NumberFormatException event)
				{
					display.setText("Infinity");
				}
			}
			model.setCalculationFinished(true);
		}
	}

	class BackspaceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (display.getText().length() > 0)
			{
				if (lastCharacter().equals(")"))
				{
					view.rightBracketShouldBeUsed();
				}

				if (lastCharacter().equals("("))
				{
					view.leftBracketShouldBeUsed();
				}
				display.setText(expressionWithoutLastCharacter());
			}
		}
	}

	private void setMathExpressionToDisplay(String mathExpression)
	{
		if (!display.getText().isEmpty())
		{
			if (isLastSignMathExpression())
			{
				display.setText(expressionWithoutLastCharacter());
				display.append(mathExpression);
			}
			else
			{
				display.append(mathExpression);
				model.setCalculationFinished(false);
			}
		}
	}

	private String expressionWithoutLastCharacter()
	{
		String wholeExpression = display.getText();
		int beginIndex = 0;
		int endIngex = wholeExpression.length() - 1;
		return wholeExpression.substring(beginIndex, endIngex);
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
		String wholeExpression = display.getText();
		return wholeExpression.substring(placeOfLastMathSign(), wholeExpression.length());
	}

	private int placeOfLastMathSign()
	{
		String wholeExpression = display.getText();
		int lengthOfExpression = wholeExpression.length();

		while (lengthOfExpression > 0)
		{
			String lastCharacter = wholeExpression.substring(lengthOfExpression - 1,
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

	private boolean isLastSignMathExpression()
	{
		return lastCharacter().equals("*") || lastCharacter().equals("/")
				|| lastCharacter().equals("+") || lastCharacter().equals("-")
				|| lastCharacter().equals("^");
	}

	private String lastCharacter()
	{
		String textInDisplay = display.getText();
		int placeOfLastCharacter = textInDisplay.length() - 1;
		String lastCharacter = textInDisplay.substring(placeOfLastCharacter);
		return lastCharacter;
	}
}
