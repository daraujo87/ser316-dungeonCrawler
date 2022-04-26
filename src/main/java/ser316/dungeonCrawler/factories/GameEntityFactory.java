package ser316.dungeonCrawler.factories;

import ser316.dungeonCrawler.core.GameEntity;
import ser316.dungeonCrawler.core.Mediator;

/**
 * GameEntityFactory is the abstract class that is used as the basis for all
 * other Factories.
 * 
 * @author Diego Araujo (daraujo2@asu.edu)
 * 
 *         Built for SER 316 - Spring B 2022 Arizona State University
 * 
 */
public abstract class GameEntityFactory {

    /**
     * Creates a GameEntity object assigning a reference to the mediator.
     * 
     * @param m the mediator
     * @return
     */
    public GameEntity create(Mediator m) {
        return new GameEntity(m);
    }
}
