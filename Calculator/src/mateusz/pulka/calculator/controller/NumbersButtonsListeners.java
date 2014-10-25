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
			if (model.isFinished())
			{
				display.setText("1");
				model.setFinished(false);
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
			if (model.isFinished())
			{
				display.setText("2");
				model.setFinished(false);
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
			if (model.isFinished())
			{
				display.setText("3");
				model.setFinished(false);
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
			if (model.isFinished())
			{
				display.setText("4");
				model.setFinished(false);
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
			if (model.isFinished())
			{
				display.setText("5");
				model.setFinished(false);
			}
			else
			{
				display.append("5");
			}
		}
	}

	class NumberSixListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("6");
				model.setFinished(false);
			}
			else
			{
				display.append("6");
			}
		}
	}

	class NumberSevenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("7");
				model.setFinished(false);
			}
			else
			{
				display.append("7");
			}
		}
	}

	class NumberEightListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("8");
				model.setFinished(false);
			}
			else
			{
				display.append("8");
			}
		}
	}

	class NumberNineListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("9");
				model.setFinished(false);
			}
			else
			{
				display.append("9");
			}
		}
	}

	class NumberZeroListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("0");
				model.setFinished(false);
			}
			else
			{
				display.append("0");
			}
		}
	}

	class LeftBracketListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (model.isFinished())
			{
				display.setText("(");
				model.setFinished(false);
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
			if (model.isFinished())
			{
				display.setText(")");
				model.setFinished(false);
			}
			else
			{
				display.append(")");
			}
		}
	}
}
