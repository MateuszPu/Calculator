package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.view.MainFrame;
import mateusz.pulka.calculator.view.ToolsMenu;

public class ToolsButtonsListeners
{
	private MainFrame view;
	private ToolsMenu toolsMenu;
	private JTextArea display;

	public ToolsButtonsListeners(MainFrame view)
	{
		this.view = view;
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
		toolsMenu.addResultListener(new ResultListener());
		toolsMenu.addBackspaceListener(new BackspaceListener());
	}

	class AdditionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("+");
		}
	}

	class SubtractionListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("-");
		}
	}

	class MultiplicationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("*");
		}
	}

	class DivisionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("/");
		}
	}

	class DotListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append(".");
		}
	}

	class SquaredListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("^2");
		}
	}

	class CubicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("^3");
		}
	}

	class FibboListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("fibbo");
		}
	}

	class MedianListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			display.append("median");
		}
	}

	class ResultListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(display.getText());
		}
	}

	class BackspaceListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO exception
			display.setText(display.getText().substring(0, display.getText().length() - 1));
		}
	}
}
