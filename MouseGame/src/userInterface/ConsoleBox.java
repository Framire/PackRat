package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ConsoleBox extends JPanel{
	private InGameConsole console;
	private UserInputBox input;
	
	public ConsoleBox(Dimension dim) {
		BorderLayout border = new BorderLayout();
		setLayout(border);
		
		this.setMinimumSize(dim);
		
		console = new InGameConsole();
		input = new UserInputBox();
		
		add(console,BorderLayout.NORTH);
		//add(input,BorderLayout.SOUTH);
		
		console.setEditable(false);
		
		
	}
}
