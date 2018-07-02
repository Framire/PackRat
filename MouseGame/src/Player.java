import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import DropTable.Item;

/*
 * Describes any character in the game
 * 
 */
public abstract class Player
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
	private int gameSize;
	private boolean isDead = false;
	private BufferedImage avatar = null;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public void pickUpItem(Item item) {
		inventory.add(item);
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public void dropItemsDeath(Tile tile){
		for(Item item: inventory) {
		tile.itemDroppedOn(item);
		}
	}
	
	public void moveLeft(ArrayList<Tile> tList){
		Tile currentTile = tList.get(location);
		try{
			Tile tileToLeft = tList.get(location-1);
			if(tileToLeft.getIsWall()  && !((location % 10) == 0)){
			tileToLeft.setC(this.getC());
			location = tileToLeft.getGameLocation();
			tileToLeft.setP(this);
			currentTile.setP(null);
			currentTile.resetTile();
			setLocation(location);
			}
			else{
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
			if(tileToRight.getIsWall()  && !(((location +1) % 10) == 0)){
				tileToRight.setC(this.getC());
				tileToRight.setP(this);
				currentTile.setP(null);
				location = tileToRight.getGameLocation();
				currentTile.resetTile();
				setLocation(location);
			}
			else{
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
				tileBelow.setP(this);
				currentTile.setP(null);
				setLocation(location);
				currentTile.resetTile();
			}
			else{
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
			tileAbove.setP(this);
			currentTile.setP(null);
			location = tileAbove.getGameLocation();
			currentTile.resetTile();
			setLocation(location);
			}
			else{
				tileAbove.damageWall(damage);
			}
		}
	catch(ArrayIndexOutOfBoundsException e1){
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
		if(this.health <= 0){
			this.setDead(true);
		}
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
	
	public boolean bumpIntoPlayer(Player e){
		boolean isPlayer = false;
		
		if(e != null)
			if(this.getLocation() == e.getLocation()){
				isPlayer = true;
			}
		
		return isPlayer;
	}
	
	public void gainXp(Player e){
		int current = getExp();
		current = current + getIntelligence() * ((e.getExp()/2) + 1);
		setExp(current);
		gainLevel(getExp());
	}
	
	public void gainLevel(int exp){
		if(exp >= getLevel()*5){
			setLevel(getLevel()+1);
			setExp(0);
			Random rand = new Random();
			int choice = rand.nextInt(7);
			switch(choice){
				case 0:{
					setStrength(getStrength()+1);
					break;
				}
				case 1:{
					setDexterity(getDexterity()+1);
					break;
				}
				case 2:{
					setCharisma(getCharisma()+1);
					break;
				}
				case 3:{
					setIntelligence(getIntelligence()+1);
					break;
				}
				case 4:{
					setWill(getWill()+1);
					break;
				}
				case 5:{
					setLuck(getLuck()+1);
					break;
				}
				case 6:{
					setPiety(getPiety()+1);
					break;
				}
				default:{
					
					break;
				}
			}
		}
	}
	
	public boolean fightOther(Player e){
		e.damageThis(this.getDamage());
		
		System.out.println("I DIED");
		if(e.isDead()){
			gainXp(e);
			
		}
		return e.isDead();
	}	
	
	protected void damageThis(int dam){
		int currentHp = getHealth();
		currentHp = currentHp - dam;
		setHealth(currentHp);
	}

	@Override
	public String toString()
	{
		String charInfo = "I am " + name + "\nhealth=" + health + " damage="
				+ damage + " level=" + level + " exp=" + exp + " money=" + money + "\nstrength="
				+ strength + " dexterity=" + dexterity + " charisma="
				+ charisma + "\nintelligence=" + intelligence + " will=" + will
				+ " luck=" + luck + " piety=" + piety;
		
		String inventory = "";
		for(Item item: getInventory()){
			inventory = inventory + item;
		}
		return charInfo + inventory;
	}

	public boolean isDead() {
		
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getGameSize()
	{
		return gameSize;
	}

	public void setGameSize(int gameSize)
	{
		this.gameSize = gameSize;
	}

	public BufferedImage getAvatar()
	{
		return avatar;
	}

	public void setAvatar(BufferedImage avatar)
	{
		this.avatar = avatar;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	
}
