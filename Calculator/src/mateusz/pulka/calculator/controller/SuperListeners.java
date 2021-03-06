package mateusz.pulka.calculator.controller;

import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;

public abstract class SuperListeners
{
	private MainFrame view;
	private Model model;
	private JTextArea display;

	public SuperListeners(MainFrame view, Model model)
	{
		this.setModel(model);
		this.setView(view);
		setDisplay(view.getDisplay());
	}

	protected String lastCharacter()
	{
		String expressionInDisplay = display.getText();
		if (!expressionInDisplay.isEmpty())
		{
			int placeOfLastCharacter = expressionInDisplay.length() - 1;
			String lastCharacter = expressionInDisplay.substring(placeOfLastCharacter);
			return lastCharacter;
		}
		return "";

	}

	protected boolean isLastSignMathExpression()
	{
		return lastCharacter().equals("*") || lastCharacter().equals("/")
				|| lastCharacter().equals("+") || lastCharacter().equals("-")
				|| lastCharacter().equals("^");
	}

	protected boolean isLastCharacterRightBracket()
	{
		return lastCharacter().equals(")");
	}

	protected Model getModel()
	{
		return model;
	}

	protected void setModel(Model model)
	{
		this.model = model;
	}

	protected MainFrame getView()
	{
		return view;
	}

	protected void setView(MainFrame view)
	{
		this.view = view;
	}

	protected JTextArea getDisplay()
	{
		return display;
	}

	protected void setDisplay(JTextArea display)
	{
		this.display = display;
	}
}
