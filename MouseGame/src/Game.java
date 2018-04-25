import java.util.ArrayList;
import java.util.Random;

public class Game
{
	//Confusing part, needs to add enemies still. 
	//To add enemies to game you gotta do something with a new list.
	//then pass that to everything that needs.
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private ArrayList<Human> pList = new ArrayList<Human>();
	private ArrayList<Enemy> eList = new ArrayList<Enemy>();
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private Random rand = new Random();
	
	public ArrayList<Tile> gettList()
	{
		return tList;
	}

	public void settList(ArrayList<Tile> tList)
	{
		this.tList = tList;
	}
	
	public ArrayList<Enemy> geteList()
	{
		return eList;
	}

	public void seteList(ArrayList<Enemy> eList)
	{
		this.eList = eList;
	}

	public ArrayList<Human> getpList()
	{
		if(rand.nextDouble() > .5)
			eList.add(new Enemy());
		return pList;
	}

	public void setpList(ArrayList<Human> pList)
	{
		this.pList = pList;
	}

	public Game(){
		
	}
	
	public Game(ArrayList<Tile> tlist, Human human){
		setTList(createMaze(tlist, human));
		ArrayList<Human> pList = new ArrayList<Human>();
		pList.add(human);
		setpList(pList);
	}
	
	public void setTList(ArrayList<Tile> list){
		this.tList = list;
	}
	
	public ArrayList<Tile> getTList(){
		return tList;
	}
	
	private ArrayList<Tile> createMaze(ArrayList<Tile> list, Player human){	
		for(int i = 0; i < 100; i++){
			Tile tile = new Tile();
			list.add(tile);
			
			tile.setGameLocation(i);
			if(i == human.getLocation() || i == 0){
				tile.setC(human.getC());
				tile.setIsWall(true);
			}
		}
		return list;
		
	}
}
