package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.model.ReversePolishNotation;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.ToolsMenu;

public class ToolsButtonsListeners
{
	private MainFrame view;
	private Model model;
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
			if (isLastSignMathExpression())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("+");
			}
			else
			{
				display.append("+");
				model.setDotUsed(false);
				model.setCalculationFinished(false);
			}
		}
	}

	class SubtractionListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (isLastSignMathExpression())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("-");
			}
			else
			{
				display.append("-");
				model.setDotUsed(false);
				model.setCalculationFinished(false);
			}
		}
	}

	class MultiplicationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (isLastSignMathExpression())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("*");
			}
			else
			{
				display.append("*");
				model.setDotUsed(false);
				model.setCalculationFinished(false);
			}
		}
	}

	class DivisionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (isLastSignMathExpression())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("/");
			}
			else
			{
				display.append("/");
				model.setDotUsed(false);
				model.setCalculationFinished(false);
			}
		}
	}

	class DotListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!model.isDotUsed())
			{
				display.append(".");
				model.setDotUsed(true);
				model.setCalculationFinished(false);
			}
		}
	}

	class PowerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 2));
				display.append("^");
			}
			else
			{
				display.append("^");
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				model.setCalculationFinished(false);
			}
		}
	}

	class FibboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int maxValueForFibbo = 99999; // for greater integer application
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
			model.setDotUsed(false);
			model.setCalculationFinished(false);
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
			model.setDotUsed(false);
		}
	}

	class FactorialListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int maxValueForFactorial = 9999; // for greater integer application
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
			model.setDotUsed(false);
			model.setCalculationFinished(false);
		}
	}

	class ResultListener implements ActionListener
	{
		NumberFormat nf = new DecimalFormat("#,###.############");

		public void actionPerformed(ActionEvent e)
		{
			if (!model.getArrayForMedian().isEmpty())
			{
				String result = nf.format(model.median());
				// String result = String.valueOf(model.median());
				display.setText(result);
				model.getArrayForMedian().clear();
			}
			else
			{
				try
				{
					ReversePolishNotation onp = new ReversePolishNotation(display.getText());
					String result = nf.format(model.getResult(onp.toString()));
					display.setText(result);
				}
				catch (NumberFormatException event)
				{
					display.setText("Infinity");
				}
			}
			model.setDotUsed(false);
			model.setMathExpressionUsed(false);
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

				display.setText(display.getText().substring(0, display.getText().length() - 1));
			}
		}
	}

	private String lastCharacter()
	{
		String textInDisplay = display.getText();
		int placeOfLastCharacter = textInDisplay.length() - 1;
		String lastCharacter = textInDisplay.substring(placeOfLastCharacter);
		return lastCharacter;
	}

	private boolean isLastSignMathExpression()
	{
		return lastCharacter().equals("*") || lastCharacter().equals("/")
				|| lastCharacter().equals("+") || lastCharacter().equals("-");
	}
}
