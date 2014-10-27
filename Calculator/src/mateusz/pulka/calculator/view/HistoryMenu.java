package mateusz.pulka.calculator.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryMenu extends JPanel
{
	private JButton displaySelectedHistory, readHistoryFromFile;
	private JComboBox<String> history;
	private JLabel info, emptyLabel;
	private static int counter = 1;

	public void setTools()
	{
		int numberOfColumns = 3; // = 0 many columns as necessary
		int numberOfRows = 0; // 0 = many rows as necessary
		this.setLayout(new GridLayout(numberOfRows, numberOfColumns));

		displaySelectedHistory = new JButton("Display");
		displaySelectedHistory.setToolTipText("Set history to the display");
		readHistoryFromFile = new JButton("Open...");
		readHistoryFromFile.setToolTipText("Get history from the file");
		history = new WideComboBox();
		info = new JLabel("History:");
		emptyLabel = new JLabel();

		this.add(info);
		this.add(history);
		this.add(displaySelectedHistory);
		this.add(emptyLabel);
		this.add(readHistoryFromFile);
	}

	public void addDisplayActionListener(ActionListener listenerForDisplay)
	{
		displaySelectedHistory.addActionListener(listenerForDisplay);
	}

	public void addReadHistoryActionListener(ActionListener listenerReadHistory)
	{
		displaySelectedHistory.addActionListener(listenerReadHistory);
	}

	public void addExpressionToCombobox(String expression)
	{
		String historyExpression = "" + counter + ". " + expression;
		history.addItem(historyExpression);
		counter++;
	}

	public String getSelectedItemFromCombobox()
	{
		return (String) history.getSelectedItem();
	}
}
