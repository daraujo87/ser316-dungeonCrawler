package ser316.dungeonCrawler.monsters;

import java.util.ArrayList;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

/**
 * Monster is the abstract class that is used as the basis for other all monster
 * sub classes. Using a Decorator design pattern a monster type will be later
 * added on top of the monster instance.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public abstract class Monster extends GameEntity {

    // Atributes
    protected int powerLevel;
    protected int maxLife;
    protected int currLife;
    protected int phyAtk;
    protected int mgcAtk;
    protected int phyDef;
    protected int mgcDef;
    protected int agility;
    protected double crit;
    protected String name;
    protected String type;
    protected ArrayList<String> moveList;

    /**
     * Constructor.
     * 
     * @param mediator   the mediator
     * @param powerLevel the monster's power level
     */
    public Monster(Mediator mediator, int powerLevel) {
        super(mediator);

        this.powerLevel = powerLevel;
        this.name = "Unknown";
        this.type = "Unknown";
        this.moveList = new ArrayList<>();

        // setup attributes and base monster progression
        maxLife = 3 + (int) (this.powerLevel * 2);
        phyAtk = 8 + (int) (this.powerLevel * 0.5);
        mgcAtk = 8 + (int) (this.powerLevel * 0.5);
        phyDef = 8 + (int) (this.powerLevel * 0.5);
        mgcDef = 8 + (int) (this.powerLevel * 0.5);
        agility = 8 + (int) (this.powerLevel * 0.5);
        crit = 0.1;

        fillLife();
    }

    /**
     * Monster Type getter.
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Name getter.
     * 
     * @return
     */
    public String getName() {
        return name;
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
     * Max Life getter.
     * 
     * @return
     */
    public int getMaxLife() {
        return maxLife;
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
     * Magical Attack getter.
     * 
     * @return
     */
    public int getMgcAtk() {
        return mgcAtk;
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
     * Magical Defense getter.
     * 
     * @return
     */
    public int getMgcDef() {
        return mgcDef;
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
     * Critical rating getter.
     * 
     * @return
     */
    public double getCrit() {
        return crit;
    }

    /**
     * Powers up the monster into it's boss version.
     */
    public void powerUp() {
        maxLife = (int) (maxLife * 1.5);
        phyAtk = (int) (phyAtk * 1.2);
        mgcAtk = (int) (phyAtk * 1.2);
        phyDef = (int) (phyAtk * 1.2);
        mgcDef = (int) (phyAtk * 1.2);
        agility = (int) (phyAtk * 1.2);
        fillLife();
    }

    /**
     * Fully recovers Life.
     */
    public void fillLife() {
        currLife = maxLife;
    }

    /**
     * Causes damage to the Monster.
     * 
     * @param damage the amount
     * @return
     */
    public boolean takeDamage(int damage) {
        System.out.println("The enemy takes " + damage + " damage.");
        if (currLife - damage <= 0) {
            currLife = 0;
            return false; // monster is dead
        }
        currLife -= damage;
        return true;
    }

    /**
     * Recovers the Monster's life.
     * 
     * @param amount the amount
     */
    public void recoverLife(int amount) {
        System.out.println("The enemy recovers " + amount + " life.");
        if (currLife + amount >= maxLife) {
            currLife = maxLife;
        }
        currLife += amount;
    }

    /**
     * Prompts the Monster for a combat move.
     */
    public void combatPrompt() {
        int max = moveList.size() - 1;
        int min = 0;
        int random = ((int) (Math.random() * (max - min)) + min);
        sendMove(moveList.get(random));
    }

    /**
     * Sends the combat move to the mediator.
     * 
     * @param move the move's name
     */
    protected void sendMove(String move) {
        // To be overloaded on sub classes
    }
}
