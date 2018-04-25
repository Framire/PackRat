import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class MyKeyBinding extends AbstractAction
{
	//FIX THE FUCKING COMBAT, IT'S ALL MESSED UP. CONSIDER REDOING IT.
	//Turn based game, everything moves after player does.
	private int keyLocal;
	private ArrayList<Enemy> eList;
	private Human p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	private int direction;
	private Random rand = new Random();
	private ArrayList<Player> pList = new ArrayList<Player>();
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, int dir, Human p, ArrayList<Enemy> enemyList){
		setP(p);
		settList(tList);
		setPanel(panel);
		setDirection(dir);
		seteList(enemyList);
		pList.add(p);
		for(Enemy e: enemyList){
			pList.add(e);
		}
	}
	
	public ArrayList<Enemy> geteList()
	{
		return eList;
	}

	public void seteList(ArrayList<Enemy> eList)
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
		if(getDirection() == 1)
		{
			p.moveLeft(tList);
			int random = 0;
			try{
				for(Enemy enemy: eList){
					random = rand.nextInt(4);
					if(random == 0){
						for(Player p: pList)
						//If the player is not the path of the enemy, then it will move.
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}//If it is in the path of the enemy, they fight.
						else if(p.bumpIntoPlayer(enemy)){
							//If player attacks another thing, then enemy is removed.
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								//Else if the enemy kills the player, then the player is revived.
							}
						}
					}
					else if(random == 1){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveNorth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(p.getC());;
							}
							else{
								
							}
						}
					}
					else if(random == 2){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 3){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
				}	
			}
			catch(Exception e1){
				tList.get(p.getLocation()).setC(Color.yellow);
			}
		}	
		else if(getDirection() == 0){
			p.moveRight(tList);
			int random = 0;
			try{
				for(Enemy enemy: eList){
					random = rand.nextInt(4);
					if(random == 0){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 1){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 2){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 3){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
				}	
			}
			catch(Exception e1){
				tList.get(p.getLocation()).setC(Color.yellow);
			}
		}
		else if(getDirection() == 2){
			int random = 0;
			p.moveSouth(tList);
			try{
				for(Enemy enemy: eList){
					random = rand.nextInt(4);
					if(random == 0){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 1){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveNorth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 2){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 3){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
				}	
			}
			catch(Exception e1){
				tList.get(p.getLocation()).setC(Color.yellow);
			}
		}
		else if(getDirection() == 3){
			int random = 0;
			p.moveNorth(tList);
			try{
				for(Enemy enemy: eList){
					random = rand.nextInt(4);
					if(random == 0){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);
								System.out.println("That's a kill\n\n\n\n\n\n\n");
							}
							else{
							
							}
						}
					}
					else if(random == 1){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveNorth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 2){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
					else if(random == 3){
						for(Player p: pList)
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
							if(enemy.bumpIntoPlayer(p)){
								
							}
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								
							}
						}
					}
				}	
			}
			catch(Exception e1){
				tList.get(p.getLocation()).setC(Color.yellow);
			}
		}
		
		if(rand.nextInt(10) == 0){
			Enemy enemy = new Enemy();
			eList.add(enemy);
		}
		panel.repaint();
		System.out.println(p);
	}

	
}
