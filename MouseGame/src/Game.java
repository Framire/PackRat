import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game
{
	private ArrayList<Tile> tList = new ArrayList<Tile>();
	private ArrayList<Player> pList = new ArrayList<Player>();
	private int e = KeyEvent.VK_RIGHT;
	
	public ArrayList<Tile> gettList()
	{
		return tList;
	}

	public void settList(ArrayList<Tile> tList)
	{
		this.tList = tList;
	}

	public ArrayList<Player> getpList()
	{
		return pList;
	}

	public void setpList(ArrayList<Player> pList)
	{
		this.pList = pList;
	}

	public int getE()
	{
		return e;
	}

	public void setE(int e)
	{
		this.e = e;
	}

	public Game(){
		
	}
	
	public Game(ArrayList<Tile> tlist, ArrayList<Player> pList){
		setTList(createMaze(tlist, pList));
		setpList(pList);
	}
	
	public void setTList(ArrayList<Tile> list){
		this.tList = list;
	}
	
	public ArrayList<Tile> getTList(){
		return tList;
	}
	
	private ArrayList<Tile> createMaze(ArrayList<Tile> list, ArrayList<Player> pList){	
		for(int i = 0; i < 100; i++){
			Tile tile = new Tile();
			list.add(tile);
			
			tile.setGameLocation(i);
			if(i == pList.get(0).getLocation() || i == 0){
				tile.randomize();
				tile.setIsWall(true);
				System.out.println("Match");
			}
		}
		return list;
		
	}
}
