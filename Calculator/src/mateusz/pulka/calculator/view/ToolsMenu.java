package mateusz.pulka.calculator.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolsMenu extends JPanel
{
	private JButton additionButton, subtractionButton, multiplicationButton, divisionButton,
			squaredButton, cubicButton, fibboButton, medianButton, dotButton, resultButton,
			backspaceButton;

	public ToolsMenu()
	{
	}

	public void setTools()
	{
		int numberOfColumns = 3; // = 0 many columns as necessary
		int numberOfRows = 0; // 0 = many rows as necessary
		this.setLayout(new GridLayout(numberOfRows, numberOfColumns));

		additionButton = new JButton("+");
		subtractionButton = new JButton("-");
		multiplicationButton = new JButton("*");
		divisionButton = new JButton("/");
		dotButton = new JButton(".");
		squaredButton = new JButton("^2");
		cubicButton = new JButton("^3");
		fibboButton = new JButton("Fibbo");
		medianButton = new JButton("Median");
		resultButton = new JButton("=");
		backspaceButton = new JButton("Backspace");

		this.add(additionButton);
		this.add(subtractionButton);
		this.add(multiplicationButton);
		this.add(divisionButton);
		this.add(dotButton);
		this.add(squaredButton);
		this.add(cubicButton);
		this.add(fibboButton);
		this.add(medianButton);
		this.add(resultButton);
		this.add(backspaceButton);
	}

	public void addAdditionListener(ActionListener listenerForAddition)
	{
		additionButton.addActionListener(listenerForAddition);
	}

	public void addSubtractionListener(ActionListener listenerForSubtraction)
	{
		subtractionButton.addActionListener(listenerForSubtraction);
	}

	public void addMultiplicationListener(ActionListener listenerForMultiplication)
	{
		multiplicationButton.addActionListener(listenerForMultiplication);
	}

	public void addDivisionListener(ActionListener listenerForDivision)
	{
		divisionButton.addActionListener(listenerForDivision);
	}

	public void addDotListener(ActionListener listenerForDot)
	{
		dotButton.addActionListener(listenerForDot);
	}

	public void addSquaredListener(ActionListener listenerForSquared)
	{
		squaredButton.addActionListener(listenerForSquared);
	}

	public void addCubicListener(ActionListener listenerForCubic)
	{
		cubicButton.addActionListener(listenerForCubic);
	}

	public void addFibboListener(ActionListener listenerForFibbo)
	{
		fibboButton.addActionListener(listenerForFibbo);
	}

	public void addMedianListener(ActionListener listenerForMedian)
	{
		medianButton.addActionListener(listenerForMedian);
	}

	public void addResultListener(ActionListener listenerForResult)
	{
		resultButton.addActionListener(listenerForResult);
	}

	public void addBackspaceListener(ActionListener listenerForBackspace)
	{
		backspaceButton.addActionListener(listenerForBackspace);
	}
}
