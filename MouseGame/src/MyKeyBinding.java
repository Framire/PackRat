import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

//Handles the movement and actions the player gives to the game.
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
	private boolean fastAction = false;
	private String actionName;
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, int dir, Human p, ArrayList<Player> enemyList){
		setP(p);
		settList(tList);
		setPanel(panel);
		setDirection(dir);
		seteList(enemyList);
		setFastAction(false);
		pList.add(p);
		for(Player e: enemyList){
			pList.add(e);
		}
	}
	
	public MyKeyBinding() {
		
	}
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, Human p, String actionName) {
		setFastAction(true);
		settList(tList);
		setPanel(panel);
		setP(p);
		setActionName(actionName);
		setFastAction(true);
		pList.add(p);
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

	//This is where actions are determined based on their input. Combat is also managed here.
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!isFastAction()) {
		combat();
		}
		else {
			if(getActionName().contains("PickUp") && tList.get(p.getLocation()).getInventory().size()>0) {
				getP().pickUpItem(tList.get(p.getLocation()).itemPickedUp());
			}
		}
		
	}
	
	public void combat() {
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

	public ArrayList<Player> getpList() {
		return pList;
	}

	public void setpList(ArrayList<Player> pList) {
		this.pList = pList;
	}

	public boolean isFastAction() {
		return fastAction;
	}

	public void setFastAction(boolean fastAction) {
		this.fastAction = fastAction;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	

			
}
