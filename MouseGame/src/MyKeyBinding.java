import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class MyKeyBinding extends AbstractAction
{

	private int keyLocal;
	private Player p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel){
		setP(p);
		settList(tList);
		setPanel(panel);
		
		
	}
	
	public void keyPerformed(KeyEvent arg0)
	{
		
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		System.out.println("HELLO");
		System.out.println(e.KEY_EVENT_MASK);
		p.movePlayer(tList, e);
		panel.repaint();
	}

	
}
