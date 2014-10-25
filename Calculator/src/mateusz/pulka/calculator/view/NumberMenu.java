package mateusz.pulka.calculator.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberMenu extends JPanel
{
	private JButton numberOneButton, numberTwoButton, numberTrheeButton, numberFourButton,
			numberFiveButton, numberSixButton, numberSevenButton, numberEightButton,
			numberNineButton, numberZeroButton;
	private JLabel emptyPlace;

	public NumberMenu()
	{
	}

	public void setNumber()
	{
		int numberOfColumns = 3; // = 0 many columns as necessary
		int numberOfRows = 0; // 0 = many rows as necessary
		this.setLayout(new GridLayout(numberOfRows, numberOfColumns));

		numberOneButton = new JButton("1");
		numberTwoButton = new JButton("2");
		numberTrheeButton = new JButton("3");
		numberFourButton = new JButton("4");
		numberFiveButton = new JButton("5");
		numberSixButton = new JButton("6");
		numberSevenButton = new JButton("7");
		numberEightButton = new JButton("8");
		numberNineButton = new JButton("9");
		numberZeroButton = new JButton("0");
		emptyPlace = new JLabel();

		this.add(numberOneButton);
		this.add(numberTwoButton);
		this.add(numberTrheeButton);
		this.add(numberFourButton);
		this.add(numberFiveButton);
		this.add(numberSixButton);
		this.add(numberSevenButton);
		this.add(numberEightButton);
		this.add(numberNineButton);
		this.add(emptyPlace); // adding empty square to calculator looks nicer
		this.add(numberZeroButton);
	}
}
