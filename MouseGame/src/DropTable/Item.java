package DropTable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item
{
	private double weight;
	private String name;
	private BufferedImage icon = null;
	private int itemID = 0;
	private int value = 0;
	public Item(){
		try{
			icon = ImageIO.read(new File(""));
		}
		catch(IOException e){
			System.out.println("Cannot read file for image!");
		}
	}
	
	public boolean isEqual(Item other){
		boolean areEqual = false;
		if(other.getItemID() == this.itemID){
			areEqual = true;
		}
		return areEqual;
	}
	
	public String toString() {
		String itemInfo = "Item Name: %s, ID: %d", name, itemID;
		
		return itemInfo;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public BufferedImage getIcon()
	{
		return icon;
	}

	public void setIcon(BufferedImage icon)
	{
		this.icon = icon;
	}

	public int getItemID()
	{
		return itemID;
	}

	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}
	
	
}
