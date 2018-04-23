import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class MyKeyBinding extends AbstractAction
{
	//Turn based game, everything moves after player does.
	private int keyLocal;
	private ArrayList<Enemy> eList;
	private Player p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	private int direction;
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, int dir, Player p){
		setP(p);
		settList(tList);
		setPanel(panel);
		setDirection(dir);
		
	}

	public int getKeyLocal()
	{
		return keyLocal;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public int getDirection(){
		return direction;
	}

	public void setKeyLocal(int keyLocal)
	{
		this.keyLocal = keyLocal;
	}

	public Player getP()
	{
		return p;
	}

	public void setP(Player p)
	{
		this.p = p;
	}

	public ArrayList<Tile> gettList()
	{
		return tList;
	}

	public void settList(ArrayList<Tile> tList)
	{
		this.tList = tList;
	}

	public JPanel getPanel()
	{
		return panel;
	}

	public void setPanel(JPanel panel)
	{
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(getDirection() == 1)
		{
			p.moveLeft(tList);
			for(Enemy enemy: eList){
				
			}
		}
		else if(getDirection() == 0)
			p.moveRight(tList);
		else if(getDirection() == 2)
			p.moveSouth(tList);
		else if(getDirection() == 3)
			p.moveNorth(tList);
		panel.repaint();
	}

	
}
