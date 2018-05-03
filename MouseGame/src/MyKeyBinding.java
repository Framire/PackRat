import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class MyKeyBinding extends AbstractAction
{
	private int keyLocal;
	private ArrayList<Player> eList;
	private Human p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	private int direction;
	private Random rand = new Random();
	private ArrayList<Player> pList = new ArrayList<Player>();
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, int dir, Human p, ArrayList<Player> enemyList){
		setP(p);
		settList(tList);
		setPanel(panel);
		setDirection(dir);
		seteList(enemyList);
		pList.add(p);
		for(Player e: enemyList){
			pList.add(e);
		}
	}
	
	public ArrayList<Player> geteList()
	{
		return eList;
	}

	public void seteList(ArrayList<Player> eList)
	{
		this.eList = eList;
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

	public void setP(Human p)
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
		if(p.isDead()){
			p.reviveMe();
			p.setDead(false);
		}
		for(int i = 0; i < 1; i++){
			MoveTurn mTurn = new MoveTurn(p,getDirection(),tList);
			Player check = mTurn.getAttacked();
			if(check != null){
				eList.remove(mTurn.getAttacked());
			}
			try{
				for(Player enemy: eList){
				int random = rand.nextInt(4);
				MoveTurn enemyMove = new MoveTurn(enemy,random,tList);
				check = enemyMove.getAttacked();
				if(check != null){
					eList.remove(check);
					}
				}
			}
			catch(Exception e1){
				//e1.printStackTrace();
			}
		}
		if(rand.nextInt(5) == 0){
			Enemy enemy = new Enemy();
			eList.add(enemy);
		}
		panel.repaint();
		System.out.println(p);
	}

			
}
