package ser316.dungeonCrawler.monsters;

import ser316.dungeonCrawler.core.Mediator;

/**
 * The Undead are the most resilient monster types.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class Undead extends Monster {

    /**
     * Constructor.
     * 
     * @param m          the mediator
     * @param powerLevel the Monster's power level
     * @param name       the Monster's name
     */
    public Undead(Mediator m, int powerLevel, String name) {
        super(m, powerLevel);

        this.name = name;
        type = "Undead";

        maxLife = 1 + (int) (powerLevel * 2);
        phyAtk = 6 + (int) (powerLevel * 0.5);
        mgcAtk = 10 + (int) (powerLevel * 0.6);
        phyDef = 12 + (int) (powerLevel * 0.6);
        mgcDef = 5 + (int) (powerLevel * 0.6);
        agility = 10 + (int) (powerLevel * 0.5);
        crit = 0.1;

        // Adds the undead's moves based on its power level
        moveList.add("Attack");
        if (powerLevel >= 10) {
            moveList.add("Claw");
        }
        if (powerLevel >= 20) {
            moveList.add("Life Drain");
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
            System.out.println(name + " attack you with their weapons.");
            mediator.notify(this, "PhyAtk");
            return;
        }

        if (move.equals("Claw")) {
            System.out.println(name + " attack with vicious claws.");
            mediator.notify(this, "CritAtk");
            return;
        }

        if (move.equals("Life Drain")) {
            System.out.println(name + " attempt to drain your life.");
            mediator.notify(this, "DrainAtk");
            return;
        }

    }

}
