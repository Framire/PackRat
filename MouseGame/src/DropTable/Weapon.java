package dropTable;

//Describes weapons that the player (or NPCs) may use
public class Weapon extends Item
{
	private int damage = 1;
	private int rarity = 0;
	
	public Weapon() {
		
	}
	
	public Weapon(String name, int id) {
		setName(name);
		this.setItemID(id);
	}
	
	public int getDamage()
	{
		return damage;
	}
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	public int getRarity()
	{
		return rarity;
	}
	public void setRarity(int rarity)
	{
		this.rarity = rarity;
	}
	
	
}
