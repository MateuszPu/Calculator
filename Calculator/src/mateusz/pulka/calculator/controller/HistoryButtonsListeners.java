package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.HistoryMenu;
import mateusz.pulka.calculator.view.MainFrame;

public class HistoryButtonsListeners
{
	private MainFrame view;
	private Model model;
	private HistoryMenu historyMenu;
	private JTextArea display;

	public HistoryButtonsListeners(MainFrame view, Model model)
	{
		this.view = view;
		this.model = model;
		historyMenu = view.getHistoryMenu();
		display = view.getDisplay();

		historyMenu.addDisplayActionListener(new listenerForDisplay());
	}

	class listenerForDisplay implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String selectedHistory = historyMenu.getSelectedItemFromCombobox();
			int indexOfDot = selectedHistory.indexOf(".") + 2; // index of dot
																// plus two
																// empty spaces
			display.setText(selectedHistory.substring(indexOfDot));
		}
	}
}
