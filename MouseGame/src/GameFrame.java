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
		
		MyKeyBinding a = new MyKeyBinding(tList, tilePanel);
		a.setP(game.getpList().get(0));
		InputMap input = tilePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap action = tilePanel.getActionMap();
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0), "keyPerformed");
		action.put("keyPerformed", a);
	
		
		
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