import java.util.ArrayList;

public class FightTurn{

private Player fought = null;
	public FightTurn(){
		
	}
	
	public FightTurn(Player p, int direction, ArrayList<Tile> tList, Player attack){
		try{
			setP(fight(p,direction,tList,attack));
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	private Player fight(Player p, int direction, ArrayList<Tile> tList, Player attack){
		Player attacked = null;
		if(direction == 0){
			if(tList.get(p.getLocation()+1).getP()!= null){
				attacked = tList.get(p.getLocation()+1).getP();
				//Recall that fightOther returns true if the thing is dead.
				if(p.fightOther(attacked)){
					tList.get(attacked.getLocation()).setP(null);
					tList.get(attacked.getLocation()).resetTile();
					p.dropItemsDeath(tList.get(p.getLocation()));
				}
				else{
					attacked = null;
				}
				
			}
		}
		else if(direction == 1){
			if(tList.get(p.getLocation()-1).getP()!=null){
				attacked = tList.get(p.getLocation()-1).getP();
				if(p.fightOther(attacked)){
					tList.get(attacked.getLocation()).setP(null);
					tList.get(attacked.getLocation()).resetTile();
					p.dropItemsDeath(tList.get(p.getLocation()));
				}
				else{
					attacked = null;
				}
				
			}
		}
		else if(direction == 2){
			if(tList.get(p.getLocation()-10).getP()!=null){
				attacked = tList.get(p.getLocation()-1).getP();
				if(p.fightOther(attacked)){
					tList.get(attacked.getLocation()).setP(null);
					tList.get(attacked.getLocation()).resetTile();
					p.dropItemsDeath(tList.get(p.getLocation()));
				}
				else{
					attacked = null;
				}
				
			}
		}
		else if(direction == 3){
			if(tList.get(p.getLocation()+10).getP()!=null){
				attacked = tList.get(p.getLocation()).getP();
				if(p.fightOther(attacked)){
					tList.get(attacked.getLocation()).setP(null);
					tList.get(attacked.getLocation()).resetTile();
					p.dropItemsDeath(tList.get(p.getLocation()));
				}
				else{
					attacked = null;
				}
			}
		}
		return attacked;
	}

	public Player getP()
	{
		return fought;
	}

	public void setP(Player p)
	{
		this.fought = p;
	}
	
	
}
