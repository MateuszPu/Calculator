package mateusz.pulka.calculator.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryMenu extends JPanel
{
	private JButton displaySelectedHistory, readHistoryFromFile;
	private JComboBox<String> history;
	private JLabel infoTextForCombobox, infoTextForOpenFile;

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
		infoTextForCombobox = new JLabel("History:");
		infoTextForOpenFile = new JLabel("History from file:");

		this.add(infoTextForCombobox);
		this.add(history);
		this.add(displaySelectedHistory);
		this.add(infoTextForOpenFile);
		this.add(readHistoryFromFile);
	}

	public void addDisplayActionListener(ActionListener listenerForDisplay)
	{
		displaySelectedHistory.addActionListener(listenerForDisplay);
	}

	public void addReadHistoryActionListener(ActionListener listenerReadHistory)
	{
		readHistoryFromFile.addActionListener(listenerReadHistory);
	}

	public void addExpressionToCombobox(String lastSuccesExpression)
	{
		history.addItem(lastSuccesExpression);
	}

	public String getSelectedItemFromCombobox()
	{
		return (String) history.getSelectedItem();
	}

	public boolean isComboboxEmpty()
	{
		if (history.getItemCount() == 0)
		{
			return true;
		}
		return false;
	}

	public void clearCombobox()
	{
		history.removeAllItems();
	}
}
