import java.awt.Color;
import java.util.ArrayList;

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
}