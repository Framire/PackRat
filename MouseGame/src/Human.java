import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This is the player themself. They have additional functions that npcs will not.
 */
public class Human extends Player
{	
	private String name = "Dude";
	private ArrayList<String> info;
	//Default profile.
	public Human(){
		setC(Color.yellow);
	}
	
	//If we have an already existing person then we use this to generate the saved version.
	public Human(String name, int level, int exp, int st, int dex, int ch, int intel, int wi,
			int mon,int luck, int pie){
		setName(name);
		setLevel(level);
		setExp(exp);
		setStrength(st);
		setDexterity(dex);
		setIntelligence(intel);
		setWill(wi);
		setMoney(mon);
		setLuck(luck);
		setPiety(pie);
		setDamage(getDamage(), getStrength());
		setC(Color.YELLOW);
		}
	
	public boolean reviveMe(){
		boolean revived = false;
		
		if(getHealth() <= 0){
			revived = true;
			setLocation(0);
			setHealth(10);
		}
		return revived;
	}
	
	public Player humanAttack(ArrayList<Tile> tList, int location){
		Tile tileTo = tList.get(location);
		Player attacked = null;
		if(tileTo.getP()!= null){
			this.fightOther(tileTo.getP());
			attacked = tileTo.getP();
			System.out.println("Murdered");
		}
		return attacked;
	}
	
	public String saveInfo(){
		String toReturn = "";
		toReturn = this.getName() + "\n" + this.getLevel() + "\n" + this.getExp() + "\n" + this.getMoney()+
				"\n" + this.getStrength() + "\n" + this.getDexterity() + "\n" + this.getCharisma() + "\n" +
				this.getIntelligence() + "\n" + this.getWill() + "\n" + this.getLuck() + "\n" + this.getPiety();
		
		return toReturn;
	}
	
	public void saveGame(){
		try
		{
			FileWriter fw = new FileWriter("profile.txt");
			fw.write(this.saveInfo());
			fw.close();
			System.out.println("Save Completed");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}