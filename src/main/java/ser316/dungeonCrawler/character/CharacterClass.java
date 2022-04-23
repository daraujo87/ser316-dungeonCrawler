package ser316.dungeonCrawler.character;

import java.util.ArrayList;

public abstract class CharacterClass extends PlayerCharacter {

	public CharacterClass(PlayerCharacter pc) {
		super(pc.getMediator());
		
		this.baseType = pc.baseType;
		this.charClass = pc.charClass;
		this.level = pc.level;
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
	}
}
