import java.awt.Color;
import java.util.ArrayList;

public class Player
{
	
	//Needs to have an inventory added later.
	//Overall this is mostly done
	private int location = 0;
	private String name = "Default";
	private int health = 1;
	private int damage = 5;
	private int level = 0;
	private int exp = 0;
	private int strength = 1;
	private int dexterity = 1;
	private int charisma = 1;
	private int intelligence = 1;
	private int will = 1;
	private int money = 1;
	private int luck = 1;
	private int piety = 1;
	private Color c = Color.RED;
	
	public void moveLeft(ArrayList<Tile> tList){
		Tile currentTile = tList.get(location);
		try{
			Tile tileToLeft = tList.get(location-1);
			if(tileToLeft.getIsWall()){
			tileToLeft.setC(this.getC());
			location = tileToLeft.getGameLocation();
			currentTile.resetTile();
			setLocation(location);
			}
			else{
				System.out.println("YOU HIT A WALL!");
				tileToLeft.damageWall(damage);
			}
		}
		catch(ArrayIndexOutOfBoundsException e1){
			e1.printStackTrace();
			System.out.println("Out Of bounds");
		}
	}
	
	public void moveRight(ArrayList<Tile> tList){
		Tile currentTile = tList.get(location);
		try{
			Tile tileToRight = tList.get(location + 1);
			if(tileToRight.getIsWall()){
				tileToRight.setC(this.getC());
				location = tileToRight.getGameLocation();
				currentTile.resetTile();
				setLocation(location);
			}
			else{
				System.out.println("YOU HIT A WALL!");
				tileToRight.damageWall(damage);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Out of Bounds!");
		}
	}
	
	public void moveSouth(ArrayList<Tile> tList){
		Tile currentTile = tList.get(location);
		try{
			Tile tileBelow = tList.get(location + 10);
			if(tileBelow.getIsWall()){
				tileBelow.setC(this.getC());
				location = tileBelow.getGameLocation();
				currentTile.resetTile();
				setLocation(location);
				currentTile.resetTile();
			}
			else{
				System.out.println("YOU HIT A WALL!");
				tileBelow.damageWall(damage);
			}
		}
	catch(ArrayIndexOutOfBoundsException e1){
		e1.printStackTrace();
		System.out.println("Out Of bounds");
		}
	}
	
	public void moveNorth(ArrayList<Tile> tList){
		Tile currentTile = tList.get(location);
		try{
			Tile tileAbove = tList.get(location-10);
			if(tileAbove.getIsWall()){
			tileAbove.setC(getC());
			location = tileAbove.getGameLocation();
			currentTile.resetTile();
			setLocation(location);
			}
			else{
				System.out.println("YOU HIT A WALL!");
				tileAbove.damageWall(damage);
			}
		}
	catch(ArrayIndexOutOfBoundsException e1){
		e1.printStackTrace();
		System.out.println("Out Of bounds");
		}
	}
	
//	public void movePlayer(ArrayList<Tile> tList, ActionEvent e){
//		int whatKey = (int) e.KEY_EVENT_MASK;
//		Tile currentTile = tList.get(location);
//		if(whatKey == KeyEvent.VK_A){
//			try{
//				Tile tileToLeft = tList.get(location-1);
//				if(tileToLeft.getIsWall()){
//				tileToLeft.randomize();
//				location = tileToLeft.getGameLocation();
//				currentTile.resetTile();
//				setLocation(location);
//				}
//				else{
//					System.out.println("YOU HIT A WALL!");
//					tileToLeft.damageWall();
//				}
//			}
//			catch(ArrayIndexOutOfBoundsException e1){
//				e1.printStackTrace();
//				System.out.println("Out Of bounds");
//			}
//		}
//		else if(whatKey == KeyEvent.VK_W){
//			try{
//				Tile tileAbove = tList.get(location-10);
//				if(tileAbove.getIsWall()){
//					tileAbove.randomize();
//				location = tileAbove.getGameLocation();
//				currentTile.resetTile();
//				setLocation(location);
//				}
//				else{
//					System.out.println("YOU HIT A WALL!");
//					tileAbove.damageWall();
//				}
//			}
//		catch(ArrayIndexOutOfBoundsException e1){
//			e1.printStackTrace();
//			System.out.println("Out Of bounds");
//			}
//		}
//		else if(whatKey == KeyEvent.VK_S){
//		try{
//				Tile tileBelow = tList.get(location + 10);
//				if(tileBelow.getIsWall()){
//					tileBelow.randomize();
//					location = tileBelow.getGameLocation();
//					currentTile.resetTile();
//					setLocation(location);
//					currentTile.resetTile();
//				}
//				else{
//					System.out.println("YOU HIT A WALL!");
//					tileBelow.damageWall();
//				}
//			}
//		catch(ArrayIndexOutOfBoundsException e1){
//			e1.printStackTrace();
//			System.out.println("Out Of bounds");
//			}
//		}
//		else if(whatKey ==KeyEvent.VK_D){
//			try{
//				Tile tileToRight = tList.get(location + 1);
//				if(tileToRight.getIsWall()){
//					tileToRight.randomize();
//					location = tileToRight.getGameLocation();
//					System.out.println("You moved Right");
//					currentTile.resetTile();
//					setLocation(location);
//				}
//				else{
//					System.out.println("YOU HIT A WALL!");
//					tileToRight.damageWall();
//				}
//			}
//		catch(ArrayIndexOutOfBoundsException e1){
//			e1.printStackTrace();
//			System.out.println("Out Of bounds");
//			}
//		}
//		else{
//			System.out.println("Only the arrow keys count as input" + "\nKey you entered: " +whatKey);
//			System.out.println(KeyEvent.VK_E);
//		}
//	}
	
	public int getLocation()
	{
		return location;
	}
	public void setLocation(int location)
	{
		this.location = location;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage, int strength)
	{
		this.damage = damage + strength;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}

	public int getCharisma()
	{
		return charisma;
	}

	public void setCharisma(int charisma)
	{
		this.charisma = charisma;
	}

	public int getIntelligence()
	{
		return intelligence;
	}

	public void setIntelligence(int intelligence)
	{
		this.intelligence = intelligence;
	}

	public int getWill()
	{
		return will;
	}

	public void setWill(int will)
	{
		this.will = will;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}

	public int getLuck()
	{
		return luck;
	}

	public void setLuck(int luck)
	{
		this.luck = luck;
	}

	public int getPiety()
	{
		return piety;
	}

	public void setPiety(int piety)
	{
		this.piety = piety;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}
	
	public Color getC()
	{
		return c;
	}

	public void setC(Color c)
	{
		this.c = c;
	}

	@Override
	public String toString()
	{
		return "I am name " + name + "\nhealth=" + health + " damage="
				+ damage + " level=" + level + " exp=" + exp + " money=" + money + "\nstrength="
				+ strength + " dexterity=" + dexterity + " charisma="
				+ charisma + "\nintelligence=" + intelligence + " will=" + will
				+ " luck=" + luck + " piety=" + piety;
	}
	
}
