import java.util.ArrayList;

public class Driver
{
	public static void main(String[] args){
		ArrayList<Tile> tList = new ArrayList<Tile>();
		ArrayList<Player> pList = new ArrayList<Player>();
		
		Player test = new Player();
		int testLocal = 0;
		test.setLocation(testLocal);
		pList.add(test);
		
		Game game = new Game(tList,pList);
		
		GameFrame gFrame = new GameFrame(game.getTList(),game);
	}
}
