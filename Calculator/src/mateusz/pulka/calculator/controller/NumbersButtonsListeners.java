package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.NumberMenu;

public class NumbersButtonsListeners
{
	private MainFrame view;
	private Model model;
	private NumberMenu numberMenu;
	private JTextArea display;

	public NumbersButtonsListeners(MainFrame view, Model model)
	{
		this.view = view;
		this.model = model;
		numberMenu = view.getNumberMenu();
		display = view.getDisplay();

		numberMenu.addNumberOneListener(new NumberOneListener());
		numberMenu.addNumberTwoListener(new NumberTwoListener());
		numberMenu.addNumberThreeListener(new NumberThreeListener());
		numberMenu.addNumberFourListener(new NumberFourListener());
		numberMenu.addNumberFiveListener(new NumberFiveListener());
		numberMenu.addNumberSixListener(new NumberSixListener());
		numberMenu.addNumberSevenListener(new NumberSevenListener());
		numberMenu.addNumberEightListener(new NumberEightListener());
		numberMenu.addNumberNineListener(new NumberNineListener());
		numberMenu.addNumberZeroListener(new NumberZeroListener());
		numberMenu.addLeftBracketListener(new LeftBracketListener());
		numberMenu.addRightBracketListener(new RightBracketListener());
	}

	class NumberOneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("1");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append("1");
			}
		}
	}

	class NumberTwoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("2");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append("2");
			}
		}
	}

	class NumberThreeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("3");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append("3");
			}
		}
	}

	class NumberFourListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("4");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append("4");
			}
		}
	}

	class NumberFiveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("5");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("5");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class NumberSixListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("6");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("6");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class NumberSevenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("7");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("7");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class NumberEightListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("8");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("8");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class NumberNineListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("9");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("9");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class NumberZeroListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("0");
				model.setCalculationFinished(false);
				model.setMathExpressionUsed(false);
			}
			else
			{
				display.append("0");
				model.setMathExpressionUsed(false);
			}
		}
	}

	class LeftBracketListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText("(");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append("(");
			}
		}
	}

	class RightBracketListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isCalculationFinished())
			{
				display.setText(")");
				model.setCalculationFinished(false);
			}
			else
			{
				display.append(")");
			}
		}
	}
}
