package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public abstract class Monster extends GameEntity{

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
	
	public Monster (Mediator mediator, int powerLevel) {
		super(mediator);
		
		this.powerLevel = powerLevel;
		this.name = "Unknown";
		this.type = "Unknown";
		this.moveList = new ArrayList<>();
		
		// setup attributes and progression
		maxLife = 3 + (int)(powerLevel * 2);
		phyAtk = 8 + (int)(powerLevel * 0.5);
		mgcAtk = 8 + (int)(powerLevel * 0.5);
		phyDef = 8 + (int)(powerLevel * 0.5);
		mgcDef = 8 + (int)(powerLevel * 0.5);
		agility = 8 + (int)(powerLevel * 0.5);
		crit = 0.1;
		
		fillLife();
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCurrLife() {
		return currLife;
	}
	
	public int getMaxLife() {
		return maxLife;
	}

	public int getPhyAtk() {
		return phyAtk;
	}

	public int getMgcAtk() {
		return mgcAtk;
	}

	public int getPhyDef() {
		return phyDef;
	}

	public int getMgcDef() {
		return mgcDef;
	}

	public int getAgility() {
		return agility;
	}

	public double getCrit() {
		return crit;
	}
	
	public void powerUp() {
		maxLife = (int)(maxLife * 1.5);
		phyAtk = (int)(phyAtk * 1.2);
		mgcAtk = (int)(phyAtk * 1.2);
		phyDef = (int)(phyAtk * 1.2);
		mgcDef = (int)(phyAtk * 1.2);
		agility = (int)(phyAtk * 1.2);
		fillLife();
	}
	
	public void fillLife() {
		currLife = maxLife;
	}
	
	public boolean takeDamage(int damage) {
		System.out.println("The enemy takes " + damage + " damage.");
		if (currLife - damage <= 0) {
			currLife = 0;
			return false; // monster is dead
		}
		currLife -= damage;
		return true;
	}
	
	public void recoverLife(int amount) {
		System.out.println("The enemy recovers " + amount + " life.");
		if (currLife + amount >= maxLife) {
			currLife = maxLife;
		}
		currLife += amount;
	}
	
	public void combatPrompt() {
		int max = moveList.size() - 1;
		int min = 0;
		int random = ((int)(Math.random() * (max - min)) + min);
		sendMove(moveList.get(random));
	}
	
	protected void sendMove(String move) {
		// To be overloaded on sub classes
	}
}
