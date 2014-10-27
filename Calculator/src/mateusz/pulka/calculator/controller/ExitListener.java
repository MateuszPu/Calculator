package mateusz.pulka.calculator.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import javax.swing.JOptionPane;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;

public class ExitListener extends SuperListeners
{
	private Stack<String> historyOfExpression;

	public ExitListener(MainFrame view, Model model)
	{
		super(view, model);
		view.addExitListener(new listenerForExit());
		historyOfExpression = model.getHistoryOfExpression();
	}

	class listenerForExit implements WindowListener
	{
		public void windowClosing(WindowEvent e)
		{
			if (!historyOfExpression.empty())
			{
				exitMethod();
			}
		}

		// required to implement from WindowListener but unneeded
		public void windowActivated(WindowEvent e)
		{
		}

		// required to implement from WindowListener but unneeded
		public void windowClosed(WindowEvent e)
		{
		}

		// required to implement from WindowListener but unneeded
		public void windowDeactivated(WindowEvent e)
		{
		}

		// required to implement from WindowListener but unneeded
		public void windowDeiconified(WindowEvent e)
		{
		}

		// required to implement from WindowListener but unneeded
		public void windowIconified(WindowEvent e)
		{
		}

		// required to implement from WindowListener but unneeded
		public void windowOpened(WindowEvent e)
		{
		}
	}

	private void exitMethod()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH;mm;ss");
		Date date = new Date();
		String fileName = dateFormat.format(date);

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName
				+ ".myHistoryEextension", true))))
		{
			while (!historyOfExpression.empty())
			{
				out.println(historyOfExpression.pop());
			}
			out.close();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(getView(),
					"upsss something goes wrong with saving history");
		}
	}
}
