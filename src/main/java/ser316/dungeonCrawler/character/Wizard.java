package ser316.dungeonCrawler.character;

/**
 * Wizard is one of the character classes that can be picked during creation.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class Wizard extends CharacterClass {

    /**
     * Constructor.
     * 
     * @param pc the base Player Character instance
     */
    public Wizard(PlayerCharacter pc) {
        super(pc);
        charClass = "Wizard";

        // basic Wizard attack
        moves.add("Magic Missile");
    }

    /**
     * Wizard level up progression.
     */
    @Override
    public boolean levelUp() {
        if (super.levelUp()) {
            maxLife += 1;
            maxMana += 2;
            phyAtk += 0;
            mgcAtk += 2;
            phyDef += 0;
            mgcDef += 2;
            agility += 1;
            crit += 0.03;
            recoverAll();

            switch (level) {
                case (5):
                    moves.add("Chill Touch");
                    break;
                case (10):
                    moves.add("Fireball");
                    break;
                default:
                    break;
            }
            return true;
        }
        return false;
    }

    /**
     * Sends character's combat move to the mediator.
     * 
     * @param move the move's name
     */
    @Override
    protected void sendMove(String move) {
        super.sendMove(move);

        if (move.equals("Magic Missile")) {
            System.out.println("You shoot magic missiles from your hands.");
            mediator.notify(this, "MgcAtk");
            return;
        }

        if (move.equals("Chill Touch")) {
            System.out.println("You drain life from your enemy.");
            mediator.notify(this, "DrainAtk");
            return;
        }

        if (move.equals("Fireball")) {
            System.out.println("You unleash an explosive fire ball!");
            mediator.notify(this, "CritMgcAtk");
            return;
        }
    }
}
