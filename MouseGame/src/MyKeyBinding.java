import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class MyKeyBinding extends AbstractAction
{
	//Turn based game, everything moves after player does.
	private int keyLocal;
	private ArrayList<Enemy> eList;
	private Human p;
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private JPanel panel;
	private int direction;
	private Random rand = new Random();
	
	public MyKeyBinding(ArrayList<Tile> tList, JPanel panel, int dir, Human p, ArrayList<Enemy> enemyList){
		setP(p);
		settList(tList);
		setPanel(panel);
		setDirection(dir);
		seteList(enemyList);
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
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 2){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 3){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 2){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 3){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveLeft(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 2){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 3){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
							if(enemy.bumpIntoPlayer(p)){
								if(enemy.fightOther(p)){
									p.reviveMe();
								}
								
							}
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 1){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveNorth(tList);
							if(enemy.bumpIntoPlayer(p)){
								if(enemy.fightOther(p)){
									p.reviveMe();
								}
								
							}
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 2){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveSouth(tList);
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
							}
						}
					}
					else if(random == 3){
						if(!p.bumpIntoPlayer(enemy)){
							enemy.moveRight(tList);
							if(enemy.bumpIntoPlayer(p)){
								if(enemy.fightOther(p)){
									p.reviveMe();
								}
								
							}
						}
						else if(p.bumpIntoPlayer(enemy)){
							if(p.fightOther(enemy)){
								eList.remove(enemy);
								tList.get(p.getLocation()).setC(Color.yellow);;
							}
							else{
								enemy.fightOther(p);
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
