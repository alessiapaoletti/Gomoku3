//package test;
import Model.GomokuGame;
import Model.GomokuFactory;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;

/*
 * Test class for the GomokuGame class and GomokuFactory implementation.
 */

public class GomokuGameTest {

    @Test
    /*
    * Testing GomokuFactory and GetName()
    */
    public void Initialize(){
        GomokuGame targetGomoku=GomokuFactory.getGame("Omok").orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        assertEquals(targetGomoku.GetName(),"Omok");
    }
}