import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameFrame extends JFrame
{
	//Manages the layout of the game and connects the player's action to the game.
	public GameFrame(ArrayList<Tile> tList,Game game){
		setVisible(true);
		setBounds(0,0,500,500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.setFocusable(true);
		content.requestFocusInWindow();
		
		JPanel tilePanel = new JPanel();
		tilePanel.setLayout(new GridLayout(10,10));
		content.add(tilePanel,BorderLayout.CENTER);
		
		InputMap input = tilePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap action = tilePanel.getActionMap();
		
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "Move Left");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "Move Right");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Move South");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "Move North");
		
		action.put("Move Left", new MyKeyBinding(tList,tilePanel,0,game.getpList().get(0)));
		action.put("Move Right", new MyKeyBinding(tList,tilePanel,1,game.getpList().get(0)));
		action.put("Move South", new MyKeyBinding(tList,tilePanel,2,game.getpList().get(0)));
		action.put("Move North", new MyKeyBinding(tList,tilePanel,3,game.getpList().get(0)));
		
		MyKeyListener keyListen = new MyKeyListener();
		//content.addKeyListener(keyListen);
		keyListen.settList(tList);
		keyListen.setPanel(tilePanel);
		keyListen.setP(game.getpList().get(0));
			for(Tile tile: tList){
				tilePanel.add(tile);
				//System.out.println(tile);
		}
	}
}