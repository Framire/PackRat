import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player
{
	private int location = 0;
	private String name = "Default";
	private int health = 1;
	
	public void movePlayer(ArrayList<Tile> tList, ActionEvent e){
		int whatKey = (int) e.KEY_EVENT_MASK;
		Tile currentTile = tList.get(location);
		if(whatKey == KeyEvent.VK_A){
			try{
				Tile tileToLeft = tList.get(location-1);
				if(tileToLeft.getIsWall()){
				tileToLeft.randomize();
				location = tileToLeft.getGameLocation();
				currentTile.resetTile();
				setLocation(location);
				}
			}
			catch(ArrayIndexOutOfBoundsException e1){
				e1.printStackTrace();
				System.out.println("Out Of bounds");
			}
		}
		else if(whatKey == KeyEvent.VK_W){
			try{
				Tile tileAbove = tList.get(location-10);
				if(tileAbove.getIsWall()){
					tileAbove.randomize();
				location = tileAbove.getGameLocation();
				currentTile.resetTile();
				setLocation(location);
				}
			}
		catch(ArrayIndexOutOfBoundsException e1){
			e1.printStackTrace();
			System.out.println("Out Of bounds");
			}
		}
		else if(whatKey == KeyEvent.VK_S){
		try{
				Tile tileBelow = tList.get(location + 10);
				if(tileBelow.getIsWall()){
					tileBelow.randomize();
					location = tileBelow.getGameLocation();
					currentTile.resetTile();
					setLocation(location);
					currentTile.resetTile();
				}
				else{
					System.out.println("YOU HIT A WALL!");
					tileBelow.damageWall();
				}
			}
		catch(ArrayIndexOutOfBoundsException e1){
			e1.printStackTrace();
			System.out.println("Out Of bounds");
			}
		}
		else if(whatKey ==KeyEvent.VK_D){
			try{
				Tile tileToRight = tList.get(location + 1);
				if(tileToRight.getIsWall()){
					tileToRight.randomize();
					location = tileToRight.getGameLocation();
					System.out.println("You moved Right");
					currentTile.resetTile();
					setLocation(location);
				}
			}
		catch(ArrayIndexOutOfBoundsException e1){
			e1.printStackTrace();
			System.out.println("Out Of bounds");
			}
		}
		else{
			System.out.println("Only the arrow keys count as input" + "\nKey you entered: " +whatKey);
			System.out.println(KeyEvent.VK_E);
		}
	}
	
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
	
	
}
