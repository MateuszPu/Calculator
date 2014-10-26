package mateusz.pulka.calculator.application;

import java.util.Locale;
import javax.swing.SwingUtilities;
import mateusz.pulka.calculator.controller.Controller;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;

public class Application
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Locale.setDefault(Locale.US);
				runApplication();
			}
		});
	}

	public static void runApplication()
	{
		Model model = new Model();
		MainFrame view = new MainFrame(model);
		new Controller(view, model);
	}
}
