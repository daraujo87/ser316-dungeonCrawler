package ser316.dungeonCrawler.character;

public abstract class CharacterClass extends PlayerCharacter {

	public CharacterClass(PlayerCharacter pc) {
		super(pc.getMediator());
		
		this.baseType = pc.baseType;
		this.charClass = pc.charClass;
		this.level = pc.level;
		this.maxLife = pc.maxLife;
		this.maxMana = pc.maxMana;
		this.currLife = pc.currLife;
		this.currMana = pc.currMana;
		
		// Character attributes
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
		
		this.moves = pc.moves;
	}
}
