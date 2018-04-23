import java.awt.Color;
import java.util.Random;

public class Enemy extends Player
{
	public Enemy(){
		Random rand = new Random();
		setC(Color.green);
		setLocation(rand.nextInt(99)+ 1);
		System.out.println(this);
	}
}
