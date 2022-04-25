package ser316.dungeonCrawler.character;

import java.util.ArrayList;
import java.util.Scanner;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

public abstract class PlayerCharacter extends GameEntity {

	protected String baseType;
	protected String charClass;
	protected int level;

	protected int maxLife;
	protected int maxMana;
	protected int currLife;
	protected int currMana;

	// Character attributes
	protected int phyAtk;
	protected int mgcAtk;
	protected int phyDef;
	protected int mgcDef;
	protected int agility;
	protected double crit;
	protected int exp;

	// Attribute bonuses
	protected int bonusPhyAtk;
	protected int bonusMgcAtk;
	protected int bonusPhyDef;
	protected int bonusMgcDef;
	protected int bonusAgility;
	protected double bonusCrit;

	// Character equipments
	protected String weapon;
	protected String armor;
	protected String accessory;

	protected ArrayList<String> moves;

	public PlayerCharacter(Mediator mediator) {
		super(mediator);

		baseType = "Base";
		charClass = "None";

		maxLife = 15;
		maxMana = 5;

		exp = 0;

		phyAtk = 10;
		mgcAtk = 10;
		phyDef = 10;
		mgcDef = 10;
		agility = 10;
		crit = 0.1;

		bonusPhyAtk = 0;
		bonusMgcAtk = 0;
		bonusPhyDef = 0;
		bonusMgcDef = 0;
		bonusAgility = 0;
		bonusCrit = 0.0;

		weapon = "None";
		armor = "None";
		accessory = "None";

		moves = new ArrayList<>();

		// TODO add inventory
	}

	// Getters and Setters
	public String getType() {
		return baseType;
	}

	public String getCharClass() {
		return charClass;
	}

	public int getLevel() {
		return level;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public void setMaxLife(int life) {
		this.maxLife = life;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public int getCurrLife() {
		return currLife;
	}

	public void setMaxMana(int mana) {
		this.maxMana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}
	
	public int getCurrMana() {
		return currMana;
	}
	
	public int getPhyAtk() {
		return phyAtk;
	}

	public void setPhyAtk(int phyAtk) {
		this.phyAtk = phyAtk;
	}

	public int getMgcAtk() {
		return mgcAtk;
	}

	public void setMgcAtk(int mgcAtk) {
		this.mgcAtk = mgcAtk;
	}

	public int getPhyDef() {
		return phyDef;
	}

	public void setPhyDef(int phyDef) {
		this.phyDef = phyDef;
	}

	public int getMgcDef() {
		return mgcDef;
	}

	public void setMgcDef(int mgcDef) {
		this.mgcDef = mgcDef;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public double getCrit() {
		return crit;
	}

	public void setCrit(double crit) {
		this.crit = crit;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getBonusPhyAtk() {
		return bonusPhyAtk;
	}

	public void setBonusPhyAtk(int bonusPhyAtk) {
		this.bonusPhyAtk = bonusPhyAtk;
	}

	public int getBonusMgcAtk() {
		return bonusMgcAtk;
	}

	public void setBonusMgcAtk(int bonusMgcAtk) {
		this.bonusMgcAtk = bonusMgcAtk;
	}

	public int getBonusPhyDef() {
		return bonusPhyDef;
	}

	public void setBonusPhyDef(int bonusPhyDef) {
		this.bonusPhyDef = bonusPhyDef;
	}

	public int getBonusMgcDef() {
		return bonusMgcDef;
	}

	public void setBonusMgcDef(int bonusMgcDef) {
		this.bonusMgcDef = bonusMgcDef;
	}

	public int getBonusAgility() {
		return bonusAgility;
	}

	public void setBonusAgility(int bonusAgility) {
		this.bonusAgility = bonusAgility;
	}

	public double getBonusCrit() {
		return bonusCrit;
	}

	public void setBonusCrit(double bonusCrit) {
		this.bonusCrit = bonusCrit;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getArmor() {
		return armor;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	// Attribute total getters
	public int getTotalPhyAtk() {
		return phyAtk + bonusPhyAtk;
	}

	public int getTotalMgcAtk() {
		return mgcAtk + bonusMgcAtk;
	}

	public int getTotalPhyDef() {
		return phyDef + bonusPhyDef;
	}

	public int getTotalMgcDef() {
		return mgcDef + bonusMgcDef;
	}

	public int getTotalAgility() {
		return agility + bonusAgility;
	}

	public double getTotalCrit() {
		return crit + bonusCrit;
	}

	public ArrayList<String> getMoves() {
		return moves;
	}

	public boolean levelUp() {
		if (exp >= 100) {
			level += 1;
			exp = 0;
			return true;
		}
		return false;
	}

	public void recoverAll() {
		currLife = maxLife;
		currMana = maxMana;
		System.out.println("Life and Mana fully recovered.");
	}

	public void recoverLife(int amount) {
		if (amount <= 0) {
			return;
		}
		if (currLife + amount > maxLife) {
			currLife = maxLife;
			System.out.println("Life fully recovered.");
		} else {
			currLife += amount;
			System.out.println("Recovered " + amount + " life.");
		}
	}

	public void recoverMana(int amount) {
		if (amount <= 0) {
			return;
		}
		if (currMana + amount > maxMana) {
			currMana = maxMana;
			System.out.println("Mana fully recovered.");
		} else {
			currMana += amount;
			System.out.println("Recovered " + amount + " mana.");
		}
	}

	public void takeDamage(int amount) {
		if (amount <= 0) {
			return;
		}
		if (currLife - amount < 0) {
			currLife = 0;
			System.out.println("You are dead!");
		} else {
			currLife -= amount;
			System.out.println("Took " + amount + " damage!");
		}
	}

	public void spendMana(int amount) {
		if (amount <= 0) {
			return;
		}
		if (currMana - amount < 0) {
			currMana = 0;
		} else {
			currMana -= amount;
		}
	}

	public void storePrompt(ArrayList<String> inventory) {
		// The only difference between an in-dungeon shop and the town shop is the
		// return to town option
		inventory.add("Return to town");
		fallcrestPrompt(inventory);
	}

	public void fallcrestPrompt(ArrayList<String> inventory) {
		inventory.add("Delve deeper");

		String option = "";
		Scanner scan = new Scanner(System.in);
		while (option.equals("")) {
			System.out.println("Select an option:");
			// print options
			for (int i = 0; i < inventory.size(); i++) {
				System.out.println((i + 1) + " - " + inventory.get(i));
			}
			
			// get user input and validate if option is valid
			option = scan.nextLine();
			int intOption = -1;
			try {
				intOption = Integer.parseInt(option)-1;
			} catch (NumberFormatException e) {
				intOption = -1;
			}
			if (intOption >= 0 && intOption < inventory.size()) {
				if (inventory.get(intOption).equals("Return to town")) {
					// call return to town
					return;
				}
				if (inventory.get(intOption).equals("Delve deeper")) {
					mediator.notify(this, "Delve deeper");
					return;
				}
				// call purchase item
			} else {
				System.out.println("Option not recognized.");
			}
		}
	}

	public void dungeonPrompt() {
		
	}

	public void combatPrompt() {
		System.out.println("Your turn.");
		String option = "";
		Scanner scan = new Scanner(System.in);
		
		while (option.equals("")) {
			System.out.println("Select move:");
			
			// print options
			for (int i = 0; i < moves.size(); i++) {
				System.out.println((i + 1) + " - " + moves.get(i));
			}
			
			// get user input and validate if option is valid
			option = scan.nextLine();
			int intOption = -1;
			try {
				intOption = Integer.parseInt(option)-1;
			} catch (NumberFormatException e) {
				intOption = -1;
			}
			if (intOption >= 0 && intOption < moves.size()) {
				sendMove(moves.get(intOption));
			} else {
				System.out.println("Move not recognized.");
			}
		}
	}
	
	protected void sendMove(String move) {
		// Override on character class
	}
}
