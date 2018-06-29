import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//Don't touch this class, makes sure actions work as intended.
public class NewGameAction extends AbstractAction implements ActionListener
{
	private static final long serialVersionUID = -7557532364836723543L;
	private Game game;
	private GameFrame gameFrame;
	
	public NewGameAction(){
		
	}
	
	public NewGameAction(Game game, GameFrame gameFrame){
		this.setGame(game);
		this.setGameFrame(gameFrame);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		JPanel tilePanel = gameFrame.getTilePanel();
		
		game.randomizeGame(game);
		gameFrame.getTilePanel().removeAll();
		for(Tile tile: game.getTList()){
			game.getpList().get(0).setLocation(0);
			gameFrame.getTilePanel().add(tile);
		}
		
		ArrayList<Tile> tList = game.getTList();
		tilePanel.setLayout(new GridLayout(10,10));
		gameFrame.getContentPane().add(tilePanel,BorderLayout.CENTER);
		
		InputMap input = tilePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap action = tilePanel.getActionMap();
		
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "Move Left");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "Move Right");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Move South");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "Move North");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "Pick up");
		
		action.put("Move Left", new MyKeyBinding(tList,tilePanel,0,game.getpList().get(0),game.geteList()));
		action.put("Move Right", new MyKeyBinding(tList,tilePanel,1,game.getpList().get(0), game.geteList()));
		action.put("Move South", new MyKeyBinding(tList,tilePanel,2,game.getpList().get(0),game.geteList()));
		action.put("Move North", new MyKeyBinding(tList,tilePanel,3,game.getpList().get(0),game.geteList()));
		action.put("Pick up", new MyKeyBinding(tList,tilePanel, game.getpList().get(0), "PickUp"));
		
		MyKeyListener keyListen = new MyKeyListener();
		//content.addKeyListener(keyListen);
		keyListen.settList(tList);
		keyListen.setPanel(tilePanel);
		gameFrame.setVisible(true);
		tilePanel.setVisible(true);
		keyListen.setP(game.getpList().get(0));
			for(Tile tile: tList){
				tilePanel.add(tile);
				//System.out.println(tile);
		}
		gameFrame.setVisible(true);
		gameFrame.getTilePanel().repaint();
		gameFrame.repaint();
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setGame(Game gameIn){
		this.game = gameIn;
	}
	
	public GameFrame getGameFrame(){
		return gameFrame;
	}
	
	public void setGameFrame(GameFrame gameFrame){
		this.gameFrame = gameFrame;
	}
}
