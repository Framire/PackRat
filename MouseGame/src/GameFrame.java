 import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GameFrame extends JFrame
{
	private JPanel tilePanel;
	//Manages the layout of the game and connects the player's action to the game.
	public GameFrame(ArrayList<Tile> tList,Game game){
		setBounds(0,0,500,500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("PackRat");
		
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem save = new JMenuItem("Save!");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				game.getpList().get(0).saveGame();
			}
		});
		
		JMenuItem newGame = new JMenuItem("New Game");
		NewGameAction gameAction = new NewGameAction(game,this);
		newGame.addActionListener(gameAction);
		
		file.add(save);
		file.add(newGame);
		
		mb.add(file);
		this.setJMenuBar(mb);
		
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		content.setFocusable(true);
		content.requestFocusInWindow();
		
		tilePanel = new JPanel();
		tilePanel.setLayout(new GridLayout(10,10));
		content.add(tilePanel,BorderLayout.CENTER);
		
		InputMap input = tilePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap action = tilePanel.getActionMap();
		
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "Move Left");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "Move Right");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Move South");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "Move North");
		
		action.put("Move Left", new MyKeyBinding(tList,tilePanel,0,game.getpList().get(0),game.geteList()));
		action.put("Move Right", new MyKeyBinding(tList,tilePanel,1,game.getpList().get(0), game.geteList()));
		action.put("Move South", new MyKeyBinding(tList,tilePanel,2,game.getpList().get(0),game.geteList()));
		action.put("Move North", new MyKeyBinding(tList,tilePanel,3,game.getpList().get(0),game.geteList()));
		
		MyKeyListener keyListen = new MyKeyListener();
		//content.addKeyListener(keyListen);
		keyListen.settList(tList);
		keyListen.setPanel(tilePanel);
		setVisible(true);
		tilePanel.setVisible(true);
		keyListen.setP(game.getpList().get(0));
			for(Tile tile: tList){
				tilePanel.add(tile);
				//System.out.println(tile);
		}
		setVisible(true);
		
	}
	
	public void setTilePanel(JPanel tilePanel){
		this.tilePanel = tilePanel;
	}
	
	public JPanel getTilePanel(){
		return tilePanel;
	}
	
}