import java.util.ArrayList;
import java.util.Random;

public class Game
{
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private ArrayList<Human> pList = new ArrayList<Human>();
	private ArrayList<Player> eList = new ArrayList<Player>();
	private Random rand = new Random();
	private int gameSize = 10;
	
	public ArrayList<Tile> gettList()
	{
		return tList;
	}

	public void settList(ArrayList<Tile> tList)
	{
		this.tList = tList;
	}
	
	public ArrayList<Player> geteList()
	{
		return eList;
	}

	public void seteList(ArrayList<Player> eList)
	{
		this.eList = eList;
	}

	public ArrayList<Human> getpList()
	{
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
		for(int i = 0; i < (gameSize * gameSize); i++){
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
	
	public void randomizeGame(Game game){
		this.settList(new ArrayList<Tile>());
		this.createMaze(this.getTList(), this.getpList().get(0));
	}

	public int getGameSize()
	{
		return gameSize;
	}

	public void setGameSize(int gameSize)
	{
		this.gameSize = gameSize;
	}
	
	
}
