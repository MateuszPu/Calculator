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
import javax.swing.filechooser.FileNameExtensionFilter;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.HistoryMenu;
import mateusz.pulka.calculator.view.MainFrame;

public class HistoryButtonsListeners extends SuperListeners
{
	private HistoryMenu historyMenu;

	public HistoryButtonsListeners(MainFrame view, Model model)
	{
		super(view, model);
		historyMenu = view.getHistoryMenu();

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
				int indexOfLastSign = 0;
				if (selectedHistory.contains("of:"))
				{
					indexOfLastSign = selectedHistory.indexOf(":") + 2;
				}
				else
				{
					indexOfLastSign = selectedHistory.indexOf(".") + 2;
				}
				getDisplay().setText(selectedHistory.substring(indexOfLastSign));
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
					getModel().setOpenHistoryUsed(true);
					FileReader historyFile = new FileReader(pathName);
					BufferedReader reader = new BufferedReader(historyFile);
					while ((thisLine = reader.readLine()) != null)
					{
						historyMenu.addExpressionToCombobox(thisLine);
					}
				}
				catch (IOException ex)
				{
					JOptionPane.showMessageDialog(getView(), "Open error for \"" + file.getPath()
							+ "\" : " + ex.getMessage(), "Unable to Open file",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void readMemoryList()
	{
		if (getModel().isOpenHistoryUsed())
		{
			historyMenu.clearCombobox();
			Stack<String> historyOfExpression = getModel().getHistoryOfExpression();
			for (String element : historyOfExpression)
			{
				historyMenu.addExpressionToCombobox(element);
			}
			getModel().setOpenHistoryUsed(false);
		}
	}
}
