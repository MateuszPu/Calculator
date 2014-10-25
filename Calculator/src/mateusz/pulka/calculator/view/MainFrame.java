package mateusz.pulka.calculator.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;

public class MainFrame extends JFrame
{
	private ToolsMenu toolsMenu;
	private NumberMenu numberMenu;
	private JTextArea display;
	private JScrollPane scrollPane;

	public MainFrame(Model model)
	{
		prepareFrame();
	}

	public void prepareFrame()
	{
		int width = 300;
		int height = 350;

		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		initializeToolsMenuComponents();
		initializeNumberMenuComponents();
		initializeDisplayComponents();

		JPanel mainLayoutforApplication = new JPanel(new BorderLayout());
		mainLayoutforApplication.add(toolsMenu, BorderLayout.SOUTH);
		mainLayoutforApplication.add(numberMenu, BorderLayout.CENTER);
		mainLayoutforApplication.add(scrollPane, BorderLayout.NORTH);
		add(mainLayoutforApplication);
	}

	private void initializeToolsMenuComponents()
	{
		toolsMenu = new ToolsMenu();
		toolsMenu.setTools();
	}

	private void initializeNumberMenuComponents()
	{
		numberMenu = new NumberMenu();
		numberMenu.setNumber();
	}

	private void initializeDisplayComponents()
	{
		display = new JTextArea();
		display.setEditable(false);
		scrollPane = new JScrollPane(display);
	}

	public ToolsMenu getToolsMenu()
	{
		return toolsMenu;
	}

	public void setToolsMenu(ToolsMenu toolsMenu)
	{
		this.toolsMenu = toolsMenu;
	}

	public NumberMenu getNumberMenu()
	{
		return numberMenu;
	}

	public void setNumberMenu(NumberMenu numberMenu)
	{
		this.numberMenu = numberMenu;
	}

	public JTextArea getDisplay()
	{
		return display;
	}

	public void setDisplay(JTextArea display)
	{
		this.display = display;
	}
}
