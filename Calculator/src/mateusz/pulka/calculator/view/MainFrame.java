package mateusz.pulka.calculator.view;

import java.awt.BorderLayout;
import java.awt.Font;
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
		setDisplayFont();

		int hgap = 0; // the horizontal gap.
		int vgap = 10; // the vertical gap.

		JPanel mainLayoutforApplication = new JPanel(new BorderLayout(hgap, vgap));
		mainLayoutforApplication.add(toolsMenu, BorderLayout.SOUTH);
		mainLayoutforApplication.add(numberMenu, BorderLayout.CENTER);
		mainLayoutforApplication.add(scrollPane, BorderLayout.NORTH);
		add(mainLayoutforApplication);

		// TODO: how to use application
		// JOptionPane.showMessageDialog(this, "help");

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
		display.setLineWrap(true);
		scrollPane = new JScrollPane(display);
	}

	private void setDisplayFont()
	{
		Font font = new Font("Calibri", Font.BOLD, 28);
		display.setFont(font);
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

	public void leftBracketShouldBeUsed()
	{
		numberMenu.setLeftBracketEnabled();
		numberMenu.setRightBracketDisabled();
	}

	public void rightBracketShouldBeUsed()
	{
		numberMenu.setRightBracketEnabled();
		numberMenu.setLeftBracketDisabled();
	}
}
