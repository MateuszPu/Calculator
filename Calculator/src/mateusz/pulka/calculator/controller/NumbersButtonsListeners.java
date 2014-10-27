package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.NumberMenu;

public class NumbersButtonsListeners extends SuperListeners
{
	private NumberMenu numberMenu;

	public NumbersButtonsListeners(MainFrame view, Model model)
	{
		super(view, model);
		numberMenu = view.getNumberMenu();

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
			setNumberToDisplay("1");
		}
	}

	class NumberTwoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("2");
		}
	}

	class NumberThreeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("3");
		}
	}

	class NumberFourListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("4");
		}
	}

	class NumberFiveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("5");
		}
	}

	class NumberSixListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("6");
		}
	}

	class NumberSevenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("7");
		}
	}

	class NumberEightListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("8");
		}
	}

	class NumberNineListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("9");
		}
	}

	class NumberZeroListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("0");
		}
	}

	class LeftBracketListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay("(");
			getView().rightBracketShouldBeUsed();
		}
	}

	class RightBracketListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setNumberToDisplay(")");
			getView().leftBracketShouldBeUsed();
		}
	}

	private void setNumberToDisplay(String character)
	{
		if (getModel().isCalculationFinished())
		{
			getDisplay().setText(character);
			getModel().setCalculationFinished(false);
		}
		else
		{
			getDisplay().append(character);
		}
	}
}
