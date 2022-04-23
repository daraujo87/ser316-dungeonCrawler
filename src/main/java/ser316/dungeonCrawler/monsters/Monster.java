package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public class Monster extends GameEntity{

	protected int powerLevel;
	protected int maxLife;
	protected int currLife;
	protected int phyAtk;
	protected int mgcAtk;
	protected int phyDef;
	protected int mgcDef;
	protected int agility;
	protected double crit;
	protected String name, type;
	protected ArrayList<String> moveList;
	
	public Monster (Mediator mediator, int powerLevel, String name, ArrayList<String> moveList) {
		super(mediator);
		
		this.powerLevel = powerLevel;
		this.name = name;
		this.moveList = moveList;
		
		// setup attributes and progression
		maxLife = 3 + (int)(powerLevel * 2);
		phyAtk = 8 + (int)(powerLevel * 0.5);
		mgcAtk = 8 + (int)(powerLevel * 0.5);
		phyDef = 8 + (int)(powerLevel * 0.5);
		mgcDef = 8 + (int)(powerLevel * 0.5);
		agility = 8 + (int)(powerLevel * 0.5);
		crit = 0.1;
	}
	
	public String getType() {
		return type;
	}
	
	public void fillLife() {
		currLife = maxLife;
	}
	
	public boolean takeDamage(int damage) {
		if (currLife - damage <= 0) {
			return false; // monster is dead
		}
		
		currLife -= damage;
		return true;
	}
	
	public void recoverLife(int amount) {
		if (currLife + amount >= maxLife) {
			currLife = maxLife;
		}
		currLife += amount;
	}
}