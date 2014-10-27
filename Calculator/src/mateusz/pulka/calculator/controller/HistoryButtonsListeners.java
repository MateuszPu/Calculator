package mateusz.pulka.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
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

		historyMenu.addDisplayActionListener(new DisplayListener());
		historyMenu.addReadHistoryActionListener(new ReadHistoryListener());
	}

	class DisplayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			if (!historyMenu.isComboboxEmpty())
			{
				String selectedHistory = historyMenu.getSelectedItemFromCombobox();
				int indexOfDot = selectedHistory.indexOf(".") + 2; // index of
																	// dot
																	// plus two
																	// empty
																	// spaces
				display.setText(selectedHistory.substring(indexOfDot));
			}

			readMemoryList();
		}
	}

	class ReadHistoryListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser openFile = new JFileChooser();
			openFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			openFile.setAcceptAllFileFilterUsed(false);
			openFile.addChoosableFileFilter(new FileNameExtensionFilter("HistoryFile",
					"myHistoryEextension"));

			int result = openFile.showOpenDialog(openFile);

			if (result == JFileChooser.APPROVE_OPTION)
			{
				File file = openFile.getSelectedFile();
				String pathName = file.getAbsolutePath();
				String thisLine = null;

				try
				{
					historyMenu.clearCombobox();
					model.setOpenHistoryUsed(true);
					FileReader historyFile = new FileReader(pathName);
					BufferedReader reader = new BufferedReader(historyFile);
					while ((thisLine = reader.readLine()) != null)
					{
						historyMenu.addExpressionToCombobox(thisLine);
					}
				}
				catch (IOException ex)
				{
					JOptionPane.showMessageDialog(view, "Open error for \"" + file.getPath()
							+ "\" : " + ex.getMessage(), "Unable to Open file",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void readMemoryList()
	{
		if (model.isOpenHistoryUsed())
		{
			historyMenu.clearCombobox();
			Stack<String> historyOfExpression = model.getHistoryOfExpression();
			for (String element : historyOfExpression)
			{
				historyMenu.addExpressionToCombobox(element);
			}
			model.setOpenHistoryUsed(false);
		}
	}
}
