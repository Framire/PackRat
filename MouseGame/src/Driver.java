import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Launches and prepares the game. Checks to see if a profile exists
 * Creates a game object and gameframe
 */
public class Driver
{
	public static void main(String[] args){
		ArrayList<Tile> tList = new ArrayList<Tile>();
		ArrayList<Player> pList = new ArrayList<Player>();
		
		Human human = new Human();
		File saveFile = new File("profile.txt");
		try{
			Scanner input = new Scanner(saveFile);
			
			while(input.hasNextLine()){
				try {
					String name = input.nextLine();
					int level = input.nextInt();
					int exp = input.nextInt();
					int strength = input.nextInt();
					int dexterity = input.nextInt();
					int charisma = input.nextInt();
					int intelligence = input.nextInt();
					int will = input.nextInt();
					int money = input.nextInt();
					int luck = input.nextInt();
					int piety = input.nextInt();
					human = new Human(name,level,exp,strength,dexterity,charisma,intelligence,will,money,luck,piety);
				}
				catch(InputMismatchException e){
					input.next();
				}
			}
			input.close();
			System.out.println(human);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Could not load file!\nCreating new dude");
			human = new Human();
			try
			{
				FileWriter fw = new FileWriter("profile1.txt");
				fw.close();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		pList.add(human);
		
		Game game = new Game(tList,human);
		GameFrame gFrame = new GameFrame(game.getTList(),game);
		
	}
}
