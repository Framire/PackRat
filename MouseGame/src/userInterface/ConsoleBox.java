package userInterface;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ConsoleBox extends JPanel{
	private InGameConsole console;
	private UserInputBox input;
	
	public ConsoleBox() {
		BorderLayout border = new BorderLayout();
		setLayout(border);
		
		console = new InGameConsole();
		input = new UserInputBox();
		
		add(console,BorderLayout.NORTH);
		add(input,BorderLayout.SOUTH);
	}
}
