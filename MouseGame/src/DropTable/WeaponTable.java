package dropTable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

//List of all weapons in the game, comes from a file named wepList.
public class WeaponTable
{
	private Hashtable<Weapon, Integer> wepTable = new Hashtable<Weapon,Integer>();
	
	public WeaponTable() {
		createWepTable();
	}
	
	private Hashtable<Weapon,Integer> createWepTable(){
		//Read wepList for all the weapon types in the game. Start with creating IDs for each thing
		File file = new File("wepList");
		
		try {
			FileReader fr = new FileReader(file);
			Scanner sc = new Scanner(fr);
			
			String wepName = "";
			int wepID = -1;
			
			while(sc.hasNextLine()) {
				wepName = sc.next();
				wepID = sc.nextInt();
				Weapon wep = new Weapon(wepName, wepID);
				wepTable.put(wep, wepID);
			}
		} 
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in Weapon Drop Table");
		}
		return wepTable;
		
		
	}

	public Hashtable<Weapon, Integer> getWepTable() {
		return wepTable;
	}

	public void setWepTable(Hashtable<Weapon, Integer> wepTable) {
		this.wepTable = wepTable;
	}
}
