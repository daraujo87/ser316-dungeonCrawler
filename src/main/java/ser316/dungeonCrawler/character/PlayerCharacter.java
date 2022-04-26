package ser316.dungeonCrawler.character;

import java.util.ArrayList;
import java.util.Scanner;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

/**
 * PlayerCharacter is the abstract class that is used as the basis for other all
 * character types or races (Human, Elf, etc.). Using a Decorator design pattern
 * a character class will be later added on top of the character type.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public abstract class PlayerCharacter extends GameEntity {

    // Base attributes
    protected String baseType;
    protected String charClass;
    protected int level;
    protected int exp;

    protected int maxLife;
    protected int maxMana;
    protected int currLife;
    protected int currMana;

    // Physical attributes
    protected int phyAtk;
    protected int mgcAtk;
    protected int phyDef;
    protected int mgcDef;
    protected int agility;
    protected double crit;

    // Attribute bonuses (added by equipment)
    protected int bonusPhyAtk;
    protected int bonusMgcAtk;
    protected int bonusPhyDef;
    protected int bonusMgcDef;
    protected int bonusAgility;
    protected double bonusCrit;

    // Character equipment
    protected String weapon;
    protected String armor;
    protected String accessory;

    // List of combat moves
    protected ArrayList<String> moves;

    /**
     * Constructor.
     * 
     * @param mediator the mediator
     */
    public PlayerCharacter(Mediator mediator) {
        super(mediator);

        baseType = "Base";
        charClass = "None";

        maxLife = 25;
        maxMana = 5;

        level = 1;
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

        recoverAll();
    }

    // Getters and Setters
    /**
     * Type getter.
     * 
     * @return
     */
    public String getType() {
        return baseType;
    }

    /**
     * Character Class getter.
     * 
     * @return
     */
    public String getCharClass() {
        return charClass;
    }

    /**
     * Level getter.
     * 
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Character Class setter.
     * 
     * @param charClass the class
     */
    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    /**
     * Max Life setter.
     * 
     * @param life the amount
     */
    public void setMaxLife(int life) {
        this.maxLife = life;
    }

    /**
     * Max Life getter.
     * 
     * @return
     */
    public int getMaxLife() {
        return maxLife;
    }

    /**
     * Current Life getter.
     * 
     * @return
     */
    public int getCurrLife() {
        return currLife;
    }

    /**
     * Max Mana setter.
     * 
     * @param mana the amount
     */
    public void setMaxMana(int mana) {
        this.maxMana = mana;
    }

    /**
     * Max Mana getter.
     * 
     * @return
     */
    public int getMaxMana() {
        return maxMana;
    }

    /**
     * Current Mana getter.
     * 
     * @return
     */
    public int getCurrMana() {
        return currMana;
    }

    /**
     * Physical Attack getter.
     * 
     * @return
     */
    public int getPhyAtk() {
        return phyAtk;
    }

    /**
     * Physical Attack setter.
     * 
     * @param phyAtk the value
     */
    public void setPhyAtk(int phyAtk) {
        this.phyAtk = phyAtk;
    }

    /**
     * Magic Attack getter.
     * 
     * @return
     */
    public int getMgcAtk() {
        return mgcAtk;
    }

    /**
     * Magic Attack setter.
     * 
     * @param mgcAtk the value
     */
    public void setMgcAtk(int mgcAtk) {
        this.mgcAtk = mgcAtk;
    }

    /**
     * Physical Defense getter.
     * 
     * @return
     */
    public int getPhyDef() {
        return phyDef;
    }

    /**
     * Physical Defense setter.
     * 
     * @param phyDef the value
     */
    public void setPhyDef(int phyDef) {
        this.phyDef = phyDef;
    }

    /**
     * Magical Defense getter.
     * 
     * @return
     */
    public int getMgcDef() {
        return mgcDef;
    }

    /**
     * Magical Defense setter.
     * 
     * @param mgcDef the value
     */
    public void setMgcDef(int mgcDef) {
        this.mgcDef = mgcDef;
    }

    /**
     * Agility getter.
     * 
     * @return
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Agility setter.
     * 
     * @param agility the value
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * Critical rating getter.
     * 
     * @return
     */
    public double getCrit() {
        return crit;
    }

    /**
     * Critical rating setter.
     * 
     * @param crit the value
     */
    public void setCrit(double crit) {
        this.crit = crit;
    }

    /**
     * Experience getter.
     * 
     * @return
     */
    public int getExp() {
        return exp;
    }

    /**
     * Basically the Experience setter.
     * 
     * @param exp the amount
     */
    public void gainExp(int exp) {
        System.out.println("You have gained " + exp + " experience.");
        if (this.exp + exp >= 100) {
            this.exp = 100;
            System.out.println("You have gained enough experience to grow in power.\n"
                + "Return to town to level up.");
        } else {
            this.exp += exp;
        }
    }

    /**
     * Bonus Physical Attack getter.
     * 
     * @return
     */
    public int getBonusPhyAtk() {
        return bonusPhyAtk;
    }

    /**
     * Bonus Physical Attack setter.
     * 
     * @param bonusPhyAtk the value
     */
    public void setBonusPhyAtk(int bonusPhyAtk) {
        this.bonusPhyAtk = bonusPhyAtk;
    }

    /**
     * Bonus Magical Attack getter.
     * 
     * @return
     */
    public int getBonusMgcAtk() {
        return bonusMgcAtk;
    }

    /**
     * Bonus Magical Attack setter.
     * 
     * @param bonusMgcAtk the value
     */
    public void setBonusMgcAtk(int bonusMgcAtk) {
        this.bonusMgcAtk = bonusMgcAtk;
    }

    /**
     * Bonus Physical Defense getter.
     * 
     * @return
     */
    public int getBonusPhyDef() {
        return bonusPhyDef;
    }

    /**
     * Bonus Physical Defense setter.
     * 
     * @param bonusPhyDef the value
     */
    public void setBonusPhyDef(int bonusPhyDef) {
        this.bonusPhyDef = bonusPhyDef;
    }

    /**
     * Bonus Magical Defense getter.
     * 
     * @return
     */
    public int getBonusMgcDef() {
        return bonusMgcDef;
    }

    /**
     * Bonus Magical Defense setter.
     * 
     * @param bonusMgcDef the value
     */
    public void setBonusMgcDef(int bonusMgcDef) {
        this.bonusMgcDef = bonusMgcDef;
    }

    /**
     * Bonus Agility getter.
     * 
     * @return
     */
    public int getBonusAgility() {
        return bonusAgility;
    }

    /**
     * Bonus Agility setter.
     * 
     * @param bonusAgility the value
     */
    public void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    /**
     * Bonus Critical rating getter.
     * 
     * @return
     */
    public double getBonusCrit() {
        return bonusCrit;
    }

    /**
     * Bonus Critical rating setter.
     * 
     * @param bonusCrit the value
     */
    public void setBonusCrit(double bonusCrit) {
        this.bonusCrit = bonusCrit;
    }

    /**
     * Equipped Weapon getter.
     * 
     * @return
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * Weapon setter.
     * 
     * @param weapon the item
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    /**
     * Equipped Armor getter.
     * 
     * @return
     */
    public String getArmor() {
        return armor;
    }

    /**
     * Armor setter.
     * 
     * @param armor the item
     */
    public void setArmor(String armor) {
        this.armor = armor;
    }

    /**
     * Equipped Accessory getter.
     * 
     * @return
     */
    public String getAccessory() {
        return accessory;
    }

    /**
     * Accessory setter.
     * 
     * @param accessory the item
     */
    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    /**
     * Total Physical Attack getter.
     * 
     * @return
     */
    public int getTotalPhyAtk() {
        return phyAtk + bonusPhyAtk;
    }

    /**
     * Total Magical Attack getter.
     * 
     * @return
     */
    public int getTotalMgcAtk() {
        return mgcAtk + bonusMgcAtk;
    }

    /**
     * Total Physical Defense getter.
     * 
     * @return
     */
    public int getTotalPhyDef() {
        return phyDef + bonusPhyDef;
    }

    /**
     * Total Magical Defense getter.
     * 
     * @return
     */
    public int getTotalMgcDef() {
        return mgcDef + bonusMgcDef;
    }

    /**
     * Total Agility getter.
     * 
     * @return
     */
    public int getTotalAgility() {
        return agility + bonusAgility;
    }

    /**
     * Total Critical rating getter.
     * 
     * @return
     */
    public double getTotalCrit() {
        return crit + bonusCrit;
    }

    /**
     * Move List getter.
     * 
     * @return
     */
    public ArrayList<String> getMoves() {
        return moves;
    }

    /**
     * Levels Up if the character has enough experience.
     * 
     * @return
     */
    public boolean levelUp() {
        if (exp >= 100) {
            level += 1;
            System.out.println("You have leveled up to level " + level);
            exp = 0;
            return true;
        }
        return false;
    }

    /**
     * Recovers all Life and Mana.
     */
    public void recoverAll() {
        currLife = maxLife;
        currMana = maxMana;
        // System.out.println("Life and Mana fully recovered.");
    }

    /**
     * Recovers Life.
     * 
     * @param amount the amount
     */
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

    /**
     * Recovers Mana.
     * 
     * @param amount the amount
     */
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

    /**
     * Deals damage to the character.
     * 
     * @param amount the amount
     */
    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        if (currLife - amount <= 0) {
            currLife = 0;
            System.out.println("You are dead!");
        } else {
            currLife -= amount;
            System.out.println("You took " + amount + " damage!");
        }
    }

    /**
     * Spends Mana.
     * 
     * @param amount the amount
     */
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

    /**
     * Prompts the player for actions on a Shop floor.
     * 
     * @param inventory the shop's inventory
     */
    public void storePrompt(ArrayList<String> inventory) {
        // The only difference between an in-dungeon shop and the town shop is the
        // return to town option
        inventory.add("Return to town");
        fallcrestPrompt(inventory);
    }

    /**
     * Prompts the player for actions in Town Basically the same as storePrompt, but
     * without the option to go back to town.
     * 
     * @param inventory the shop's inventory
     */
    public void fallcrestPrompt(ArrayList<String> inventory) {
        inventory.add("Delve deeper");

        String option = "";
        Scanner scan = new Scanner(System.in, "UTF-8");
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
                intOption = Integer.parseInt(option) - 1;
            } catch (NumberFormatException e) {
                intOption = -1;
            }
            if (intOption >= 0 && intOption < inventory.size()) {
                if (inventory.get(intOption).equals("Return to surface")) {
                    mediator.notify(this, "Return to surface");
                    return;
                }
                if (inventory.get(intOption).equals("Delve deeper")) {
                    mediator.notify(this, "Delve deeper");
                    return;
                }
                // TODO call purchase item
            } else {
                System.out.println("Option not recognized.");
            }
        }
    }

    /**
     * Prompts the player for actions in a cleared Dungeon floor.
     */
    public void dungeonPrompt() {
        String option = "";
        Scanner scan = new Scanner(System.in, "UTF-8");
        while (option.equals("")) {
            // print options
            System.out.println("Select an option:");
            System.out.println("1 - Delve deeper.");
            System.out.println("2 - Return to surface.");

            // read and process option
            option = scan.nextLine();
            switch (option) {
                case ("1"):
                    mediator.notify(this, "Delve deeper");
                    return;
                case ("2"):
                    mediator.notify(this, "Return to surface");
                    return;
                default:
                    System.out.println("Option not recognized.");
                    option = "";
                    break;
            }
        }
    }

    /**
     * Prompts the player for actions during Combat.
     */
    public void combatPrompt() {
        System.out.println("Your turn.  Life: " + currLife + "/" + maxLife
                + " Mana: " + currMana + "/" + maxMana);
        String option = "";
        Scanner scan = new Scanner(System.in, "UTF-8");

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
                intOption = Integer.parseInt(option) - 1;
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

    /**
     * Sends character's combat move to the mediator.
     * 
     * @param move the move name
     */
    protected void sendMove(String move) {
        // Override on character class
    }
}
