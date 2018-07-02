package userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class InputPanel extends JPanel
{
	private UserInputBox uiBox;
	private ChatButton chat; 
	
	public InputPanel(Dimension dim){
		setLayout(new BorderLayout());
		
		add(uiBox,BorderLayout.WEST);
		add(chat,BorderLayout.EAST);
		
		this.setMinimumSize(dim);
	}
	
	
}
