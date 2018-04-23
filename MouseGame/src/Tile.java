import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Tile extends JPanel
{
	private int red, green, blue;
	private String tileLetter;
	private boolean isWall;
	private boolean isCheese;
	private boolean isPlayer;
	private int gameLocation;
	private int health = 1;
	private Color c;
	
	public Tile() {
		this.chooseWall();
	}
	
	//When given a tile, itself, that tile should randomize itself. Somewhat confusing.
	public Tile(Tile tile) {
		tile.randomize();
		
	}
	
	//Method used to create random numbers, gets used in a few different places.
	public static int randomNum(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt(max-min);
	}
	
	public void resetTile(){
		red = 255;
		green = 255;
		blue = 255;
		c = new Color(red,green,blue);
	}
	
	public void damageWall(int damage){
		health = health - damage;
		red = 25;
		green = 250;
		blue = 250;
		c = new Color(red,green,blue);
		if(health <= 0){
			setIsWall(true);
			red = 250;
			green = 40;
			blue = 1;
			c = new Color(red,green,blue);
		}
	}
	
	public void chooseWall(){
		int chooseColor = randomNum(0,2);
		if(chooseColor == 1){
			setIsWall(false);
			red = 0;
			green = 0;
			blue = 0;
		}
		else{
			setIsWall(true);
			red = 255;
			green = 255;
			blue = 255;
			c = new Color(red,green,blue);
		}
	}
	
	//Gives random values to all of our attributes.
	public void randomize(){
		red = randomNum(0,255);
		green = randomNum(0,255);
		blue = randomNum(0,255);
		
		c = new Color(red,green,blue);
		char chooseLetter = (char) randomNum(65,91);
		tileLetter = "" + chooseLetter;
	}
	
	public int getGameLocation()
	{
		return gameLocation;
	}

	public void setGameLocation(int gameLocation)
	{
		this.gameLocation = gameLocation;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth() - 5;
		int height = getHeight()  - 5;
		Random rand = new Random();
		double random = rand.nextDouble();
		if(getIsWall()){
			g.setColor(c);
			g.fillRect(5, 5, width, height);
		}
		else{
			g.setColor(c);
			g.fillRect(5, 5, width, height);
		}
	}
	
	public String getTileLetter() {
		return tileLetter;
	}

	public void setTileLetter(String tileLetter) {
		this.tileLetter = tileLetter;
	}
	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public static int getContrast(int colorIn) {
		return ((colorIn + 128) %256);
	}
	
	@Override
	public String toString(){
		System.out.println(getIsWall());
		return "";
	}

	public boolean isEqual(String other) {
		boolean toReturn = false;
		if(other.equals(this.getTileLetter()));
			toReturn = true;
		return toReturn;
	}

	public boolean getIsWall()
	{
		return isWall;
	}

	public void setIsWall(boolean isCircle)
	{
		this.isWall = isCircle;
	}

	public boolean isCheese()
	{
		return isCheese;
	}

	public void setCheese(boolean isCheese)
	{
		this.isCheese = isCheese;
	}

	public boolean isPlayer()
	{
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer)
	{
		this.isPlayer = isPlayer;
	}

	public void setWall(boolean isWall)
	{
		this.isWall = isWall;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public Color getC()
	{
		return c;
	}

	public void setC(Color c)
	{
		this.c = c;
	}
	
	
}
