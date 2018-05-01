import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Player
{
	public Enemy(){
		Random rand = new Random();
		setC(Color.green);
		setLocation(rand.nextInt(99)+ 1);
		System.out.println(this);
		setName("Enemy");
	}
	
	public Enemy(Player p){
		Random rand = new Random();
		setC(Color.green);
		setLocation(rand.nextInt(99)+ 1);
		System.out.println(this);
		setName("Enemy");
	}
	
	private void scaleEnemy(Player p){
		int scale = p.getLevel();
		
	}
	
	public Player enemyMove(int choose, ArrayList<Tile> tList){
		Player p = null;
		try{
			if(choose == 0){
				if (!(tList.get(this.getLocation()-1).getP() != null)){
					this.moveLeft(tList);
					Tile toLeft = tList.get(this.getLocation()-1);
					if(toLeft != null){
						this.fightOther(toLeft.getP());
						p = toLeft.getP();
						if(!p.isDead())
							p.fightOther(this);
					}
				}
			}
			if(choose == 1){
				if(!(tList.get(this.getLocation()-10).getP() != null)){
					this.moveNorth(tList);
					Tile toNorth = tList.get(this.getLocation()+10);
					if(toNorth != null){
						this.fightOther(toNorth.getP());
						p = toNorth.getP();
						if(!p.isDead())
							p.fightOther(this);
					}
				}
				
			}
			if(choose == 2){
				if(!(tList.get(this.getLocation()-10).getP() != null)){
					this.moveSouth(tList);
					Tile toSouth = tList.get(this.getLocation()+10);
					if(toSouth.getP() != null){
						this.fightOther(toSouth.getP());
						p = toSouth.getP();
						if(!p.isDead())
							p.fightOther(this);
					}
				}
				
			}
			if(choose == 3){
				if(!(tList.get(this.getLocation()+1).getP() != null)){
					this.moveRight(tList);
					Tile toRight = tList.get(this.getLocation()+1);
					if(toRight.getP() != null){
						this.fightOther(toRight.getP());
						p = toRight.getP();
						if(!p.isDead())
							p.fightOther(this);
					}
				}	
			}
		}
		catch(Exception e){
			
		}
		return p;
	}
}
