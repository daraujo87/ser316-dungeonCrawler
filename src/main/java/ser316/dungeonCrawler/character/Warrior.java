package ser316.dungeonCrawler.character;

/**
 * Warrior is one of the character classes that can be picked during creation.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public class Warrior extends CharacterClass {

    /**
     * Constructor.
     * 
     * @param pc the base Player Character instance
     */
    public Warrior(PlayerCharacter pc) {
        super(pc);
        charClass = "Warrior";

        // basic Warrior attack
        moves.add("Attack");
    }

    /**
     * Warrior level up progression.
     */
    @Override
    public boolean levelUp() {
        if (super.levelUp()) {
            maxLife += 3;
            maxMana += 0;
            phyAtk += 2;
            mgcAtk += 0;
            phyDef += 2;
            mgcDef += 0;
            agility += 1;
            crit += 0.05;
            recoverAll();

            switch (level) {
                case (5):
                    moves.add("Second Wind");
                    break;
                case (10):
                    moves.add("Power Attack");
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

        if (move.equals("Attack")) {
            System.out.println("You attack with your weapon.");
            mediator.notify(this, "PhyAtk");
            return;
        }

        if (move.equals("Second Wind")) {
            System.out.println("You take a moment to recompose yourself.");
            recoverLife((int) (currLife / 5));
            return;
        }

        if (move.equals("Power Attack")) {
            System.out.println("You unleash a powerful attack!");
            mediator.notify(this, "CritAtk");
            return;
        }
    }
}
