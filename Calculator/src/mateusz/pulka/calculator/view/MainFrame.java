package mateusz.pulka.calculator.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mateusz.pulka.calculator.model.Model;

public class MainFrame extends JFrame
{
	private JTextArea display;
	private NumberMenu numberMenu;
	private ToolsMenu toolsMenu;
	private HistoryMenu historyMenu;
	private JScrollPane scrollPane;
	private JPanel mainLayoutforApplication;

	public JPanel getMainLayoutforApplication()
	{
		return mainLayoutforApplication;
	}

	public void setMainLayoutforApplication(JPanel mainLayoutforApplication)
	{
		this.mainLayoutforApplication = mainLayoutforApplication;
	}

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
		initializeHistoryComponenets();
		setDisplayFont();

		int hgap = 0; // the horizontal gap.
		int vgap = 10; // the vertical gap.

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.add(toolsMenu, BorderLayout.NORTH);
		southPanel.add(historyMenu, BorderLayout.SOUTH);

		mainLayoutforApplication = new JPanel();
		mainLayoutforApplication.setLayout(new BorderLayout(hgap, vgap));
		mainLayoutforApplication.add(scrollPane, BorderLayout.NORTH);
		mainLayoutforApplication.add(numberMenu, BorderLayout.CENTER);
		mainLayoutforApplication.add(southPanel, BorderLayout.SOUTH);
		add(mainLayoutforApplication);

		JOptionPane.showMessageDialog(this, "Welcome \n A couple of rules: \n"
				+ "Provide math expression and press \"=\" to get result "
				+ " \n For fibonacci and factorial provide number and press appropraite button "
				+ "\n The last one: to provide an number to calculate median after each number "
				+ "\n you should press median button to get result press \"=\"   ");
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

	public HistoryMenu getHistoryMenu()
	{
		return historyMenu;
	}

	public void setHistoryMenu(HistoryMenu historyMenu)
	{
		this.historyMenu = historyMenu;
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

	public void addExitListener(WindowListener listenerForExit)
	{
		addWindowListener(listenerForExit);
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
		display.setRows(1);
		display.setEditable(false);
		display.setLineWrap(true);
		scrollPane = new JScrollPane(display);
	}

	private void setDisplayFont()
	{
		Font font = new Font("Calibri", Font.BOLD, 28);
		display.setFont(font);
	}

	private void initializeHistoryComponenets()
	{
		historyMenu = new HistoryMenu();
		historyMenu.setTools();
	}
}
