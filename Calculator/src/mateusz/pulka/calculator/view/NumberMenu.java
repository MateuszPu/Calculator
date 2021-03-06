package mateusz.pulka.calculator.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberMenu extends JPanel
{
	private JButton numberOneButton, numberTwoButton, numberThreeButton, numberFourButton,
			numberFiveButton, numberSixButton, numberSevenButton, numberEightButton,
			numberNineButton, numberZeroButton, leftBracketButton, rightBracketButton;

	public void setNumber()
	{
		final int numberOfColumns = 3; // = 0 many columns as necessary
		final int numberOfRows = 0; // 0 = many rows as necessary
		this.setLayout(new GridLayout(numberOfRows, numberOfColumns));

		numberOneButton = new JButton("1");
		numberTwoButton = new JButton("2");
		numberThreeButton = new JButton("3");
		numberFourButton = new JButton("4");
		numberFiveButton = new JButton("5");
		numberSixButton = new JButton("6");
		numberSevenButton = new JButton("7");
		numberEightButton = new JButton("8");
		numberNineButton = new JButton("9");
		numberZeroButton = new JButton("0");
		leftBracketButton = new JButton("(");
		rightBracketButton = new JButton(")");
		setRightBracketDisabled();

		this.add(numberOneButton);
		this.add(numberTwoButton);
		this.add(numberThreeButton);
		this.add(numberFourButton);
		this.add(numberFiveButton);
		this.add(numberSixButton);
		this.add(numberSevenButton);
		this.add(numberEightButton);
		this.add(numberNineButton);
		this.add(leftBracketButton);
		this.add(numberZeroButton);
		this.add(rightBracketButton);

	}

	public void addNumberOneListener(ActionListener listenerForNumberOne)
	{
		numberOneButton.addActionListener(listenerForNumberOne);
	}

	public void addNumberTwoListener(ActionListener listenerForNumberTwo)
	{
		numberTwoButton.addActionListener(listenerForNumberTwo);
	}

	public void addNumberThreeListener(ActionListener listenerForNumberThree)
	{
		numberThreeButton.addActionListener(listenerForNumberThree);
	}

	public void addNumberFourListener(ActionListener listenerForNumberFour)
	{
		numberFourButton.addActionListener(listenerForNumberFour);
	}

	public void addNumberFiveListener(ActionListener listenerForNumberFive)
	{
		numberFiveButton.addActionListener(listenerForNumberFive);
	}

	public void addNumberSixListener(ActionListener listenerForNumberSix)
	{
		numberSixButton.addActionListener(listenerForNumberSix);
	}

	public void addNumberSevenListener(ActionListener listenerForNumberSeven)
	{
		numberSevenButton.addActionListener(listenerForNumberSeven);
	}

	public void addNumberEightListener(ActionListener listenerForNumberEight)
	{
		numberEightButton.addActionListener(listenerForNumberEight);
	}

	public void addNumberNineListener(ActionListener listenerForNumberNine)
	{
		numberNineButton.addActionListener(listenerForNumberNine);
	}

	public void addNumberZeroListener(ActionListener listenerForNumberZero)
	{
		numberZeroButton.addActionListener(listenerForNumberZero);
	}

	public void addLeftBracketListener(ActionListener listenerForLeftBracket)
	{
		leftBracketButton.addActionListener(listenerForLeftBracket);
	}

	public void addRightBracketListener(ActionListener listenerForRightBracket)
	{
		rightBracketButton.addActionListener(listenerForRightBracket);
	}

	public void setRightBracketEnabled()
	{
		rightBracketButton.setEnabled(true);
	}

	public void setRightBracketDisabled()
	{
		rightBracketButton.setEnabled(false);
	}

	public void setLeftBracketEnabled()
	{
		leftBracketButton.setEnabled(true);
	}

	public void setLeftBracketDisabled()
	{
		leftBracketButton.setEnabled(false);
	}
}
