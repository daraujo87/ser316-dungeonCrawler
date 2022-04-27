package ser316.dungeonCrawler.core;

import org.junit.Test;

public class MediatorTest {

    @Test
    public void test() throws Exception {
        // Just runs the automated game
        // coverage will vary, depending on the run, but should be above 80%
        // (it's 74% with the other classes alone) 
        Mediator m = new GameRunner();
        ((GameRunner) m).initializeGame();
    }

}
