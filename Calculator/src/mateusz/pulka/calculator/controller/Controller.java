package mateusz.pulka.calculator.controller;

import mateusz.pulka.calculator.model.Model;
import mateusz.pulka.calculator.view.MainFrame;

public class Controller
{
	private MainFrame view;
	private Model model;
	private ToolsButtonsListeners toolsButtonsListeners;
	private NumbersButtonsListeners numbersButtonsListeners;
	private HistoryButtonsListeners historyButtonsListeners;
	private ExitListener exitListener;

	public Controller(MainFrame view, Model model)
	{
		this.view = view;
		this.model = model;
		setToolsButtonsListeners(new ToolsButtonsListeners(view, model));
		setNumbersButtonsListeners(new NumbersButtonsListeners(view, model));
		setHistoryButtonsListeners(new HistoryButtonsListeners(view, model));
		setExitListener(new ExitListener(view, model));
	}

	public MainFrame getView()
	{
		return view;
	}

	public void setView(MainFrame view)
	{
		this.view = view;
	}

	public Model getModel()
	{
		return model;
	}

	public void setModel(Model model)
	{
		this.model = model;
	}

	public ToolsButtonsListeners getToolsButtonsListeners()
	{
		return toolsButtonsListeners;
	}

	public void setToolsButtonsListeners(ToolsButtonsListeners toolsButtonsListeners)
	{
		this.toolsButtonsListeners = toolsButtonsListeners;
	}

	public NumbersButtonsListeners getNumbersButtonsListeners()
	{
		return numbersButtonsListeners;
	}

	public void setNumbersButtonsListeners(NumbersButtonsListeners numbersButtonsListeners)
	{
		this.numbersButtonsListeners = numbersButtonsListeners;
	}

	public HistoryButtonsListeners getHistoryButtonsListeners()
	{
		return historyButtonsListeners;
	}

	public ExitListener getExitListener()
	{
		return exitListener;
	}

	public void setExitListener(ExitListener exitListener)
	{
		this.exitListener = exitListener;
	}

	public void setHistoryButtonsListeners(HistoryButtonsListeners historyButtonsListeners)
	{
		this.historyButtonsListeners = historyButtonsListeners;
	}
}
