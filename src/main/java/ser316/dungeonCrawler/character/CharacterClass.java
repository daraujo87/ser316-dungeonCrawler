package ser316.dungeonCrawler.character;

/**
 * CharacterClass is the abstract class that is used as the basis 
 * for other character classes (Warrior, Thief, etc.) using a
 * Decorator design pattern.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 * Built for SER 316 - Spring B 2022
 * Arizona State University
 * 
 */
public abstract class CharacterClass extends PlayerCharacter {

	/**
	 * Constructor
	 * @param pc the PlayerCharacter instance that will be decorated by a Character Class
	 */
	public CharacterClass(PlayerCharacter pc) {
		super(pc.getMediator());
		
		// Base attributes
		this.baseType = pc.baseType;
		this.charClass = pc.charClass;
		this.level = pc.level;
		this.maxLife = pc.maxLife;
		this.maxMana = pc.maxMana;
		this.currLife = pc.currLife;
		this.currMana = pc.currMana;
		
		// Physical attributes
		this.phyAtk = pc.phyAtk;
		this.mgcAtk = pc.mgcAtk;
		this.phyDef = pc.phyDef;
		this.mgcDef = pc.mgcDef;
		this.agility = pc.agility;
		this.crit = pc.crit;
		this.exp = pc.exp;
		
		// Attribute bonuses
		this.bonusPhyAtk = pc.bonusPhyAtk;
		this.bonusMgcAtk = pc.bonusMgcAtk;
		this.bonusPhyDef = pc.bonusPhyDef;
		this.bonusMgcDef = pc.bonusMgcDef;
		this.bonusAgility = pc.bonusAgility;
		this.bonusCrit = pc.bonusCrit;
		
		// Character equipments
		this.weapon = pc.weapon;
		this.armor = pc.armor;
		this.accessory = pc.accessory;
		
		// Move list
		this.moves = pc.moves;
	}
}
