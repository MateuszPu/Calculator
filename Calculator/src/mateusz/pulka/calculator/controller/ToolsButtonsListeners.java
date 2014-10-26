package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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
		toolsMenu.addSquaredListener(new SquaredListener());
		toolsMenu.addCubicListener(new CubicListener());
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
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("+");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("+");
			}
		}
	}

	class SubtractionListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("-");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("-");
			}
		}
	}

	class MultiplicationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("*");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("*");
			}
		}
	}

	class DivisionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
				display.append("/");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("/");
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
			}
		}
	}

	class SquaredListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 2));
				display.append("^2");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("^2");
			}
		}
	}

	class CubicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isMathExpressionUsed())
			{
				display.setText(display.getText().substring(0, display.getText().length() - 2));
				display.append("^3");
			}
			else
			{
				model.setMathExpressionUsed(true);
				model.setDotUsed(false);
				display.append("^3");
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
				System.out.println(textFromDisplayToInteger);
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
			String textInDisplay = display.getText();
			double doubleFromText = Double.parseDouble(textInDisplay);

			model.getArrayForMedian().add(doubleFromText);
			model.setCalculationFinished(true);
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
		}
	}

	class ResultListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!model.getArrayForMedian().isEmpty())
			{
				display.setText("" + model.median());
				model.getArrayForMedian().clear();
			}

			ReversePolishNotation onp = new ReversePolishNotation(display.getText());
			System.out.println(onp);
			// TODO use here ONP
			model.setDotUsed(false);
			model.setMathExpressionUsed(false);
		}
	}

	class BackspaceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (display.getText().length() > 0)
			{
				// TODO finish deleting last character with minus plus etc
				// TODO split to smaller method
				// TODO exception
				display.setText(display.getText().substring(0, display.getText().length() - 1));
			}
		}
	}
}
