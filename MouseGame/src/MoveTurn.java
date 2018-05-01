import java.util.ArrayList;

public class MoveTurn
{
	private Player attacked = null;
	public MoveTurn(){
		
	}
	
	public MoveTurn(Player p, int direction, ArrayList<Tile> tList){
		try{
			setAttacked(makeMove(p,direction,tList));
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	private Player makeMove(Player p, int direction, ArrayList<Tile> tList){
		boolean fight = false;
		Player attack = null;
		if(direction == 0){
			Tile tileTo = tList.get(p.getLocation()+1);
			if(tList.get(p.getLocation()+1).getP()== null){
				p.moveRight(tList);
				fight = true;
			}
			else{
				if(p.fightOther(tileTo.getP())){
					attack = tileTo.getP();
					tileTo.setP(null);
					tileTo.resetTile();
				}
			}
		}
		else if(direction == 1){
			Tile tileTo = tList.get(p.getLocation()-1);
			if(tileTo.getP()==null){
				p.moveLeft(tList);
				fight = true;
			}
			else{
				if(p.fightOther(tileTo.getP())){
					attack = tileTo.getP();
					tileTo.setP(null);
					tileTo.resetTile();
				}
			}
		}
		else if(direction == 2){
			Tile tileTo = tList.get(p.getLocation()+10);
			if(tileTo.getP()==null){
				p.moveSouth(tList);
				fight = true;
			}
			else{
				if(p.fightOther(tileTo.getP())){
					attack = tileTo.getP();
					tileTo.setP(null);
					tileTo.resetTile();
				}
			}
		}
		else if(direction == 3){
			Tile tileTo = tList.get(p.getLocation()-10);
			if(tileTo.getP()==null){
				p.moveNorth(tList);
				fight = true;
			}
			else{
				if(p.fightOther(tileTo.getP())){
					attack = tileTo.getP();
					tileTo.setP(null);
					tileTo.resetTile();
				}
				
			}
		}
		return attack;
	}

	public Player getAttacked()
	{
		return attacked;
	}

	public void setAttacked(Player attacked)
	{
		this.attacked = attacked;
	}
	
	
}
