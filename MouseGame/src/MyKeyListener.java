import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyKeyListener implements KeyListener
{
	private int keyLocal;
	private Player p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		System.out.println("Key Okay");
		System.out.println(arg0);
		setKeyLocal(arg0.getKeyLocation());
		//p.movePlayer(tList, arg0);
		//System.out.println(arg0);
		panel.repaint();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	public int getKeyLocal()
	{
		return keyLocal;
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
	

}
