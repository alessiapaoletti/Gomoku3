import Model.GomokuGame.GomokuGame;
import GomokuFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * Test class for the GomokuGame class and GomokuFactory implementation.
 */

public class GomokuGameTest {
    /*  * Testing GomokuFactory and GetName()   */
    @Test
    public void Initialize(){
        GomokuGame targetGomoku= GomokuFactory.getGame("Omok").orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        //assertEquals(targetGomoku.GetName(),"Omok");
    }
    @Test
    public void InitPlayer(){


    }
}