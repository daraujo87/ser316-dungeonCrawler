package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

/**
 * Devils are the most powerful monster types.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class Devil extends Monster {

    /**
     * Constructor.
     * 
     * @param m          the mediator
     * @param powerLevel the Monster's power level
     * @param name       the Monster's name
     */
    public Devil(Mediator m, int powerLevel, String name) {
        super(m, powerLevel);

        this.name = name;
        type = "Devil";

        maxLife = 5 + (int) (powerLevel * 2);
        phyDef = 10 + (int) (powerLevel * 0.6);
        mgcDef = 10 + (int) (powerLevel * 0.6);
        agility = 10 + (int) (powerLevel * 0.7);
        crit = 0.2;

        // Adds the devil's moves based on its power level
        moveList.add("Attack");
        if (powerLevel >= 20) {
            moveList.add("Vicious Strike");
        }
        if (powerLevel >= 30) {
            moveList.add("Hellfire");
        }

        fillLife();
    }

    /**
     * Sends the combat move to the mediator.
     * 
     * @param move the move's name
     */
    @Override
    protected void sendMove(String move) {

        if (move.equals("Attack")) {
            System.out.println(name + " prods you with his trident.");
            mediator.notify(this, "PhyAtk");
            return;
        }

        if (move.equals("Vicious Strike")) {
            System.out.println(name + " attacks with demonic strenght.");
            mediator.notify(this, "CritAtk");
            return;
        }

        if (move.equals("Hellfire")) {
            System.out.println(name + " engulfs you in hell fire.");
            mediator.notify(this, "CritMgcAtk");
            return;
        }

    }
}
