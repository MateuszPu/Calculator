package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.NumberMenu;

public class NumbersButtonsListeners
{
	private MainFrame view;
	private NumberMenu numberMenu;
	private JTextArea display;

	public NumbersButtonsListeners(MainFrame view)
	{
		this.view = view;
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
	}

	class NumberOneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("1");
		}
	}

	class NumberTwoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("2");
		}
	}

	class NumberThreeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("3");
		}
	}

	class NumberFourListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("4");
		}
	}

	class NumberFiveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("5");
		}
	}

	class NumberSixListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("6");
		}
	}

	class NumberSevenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("7");
		}
	}

	class NumberEightListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("8");
		}
	}

	class NumberNineListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("9");
		}
	}

	class NumberZeroListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("0");
		}
	}
}
