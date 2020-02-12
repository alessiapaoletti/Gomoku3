package Model.GomokuGame;

import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import org.junit.Test;
import static org.junit.Assert.*;


public class GomokuGameTest {
    @Test
    public void gomokuFactoryTest(){
        GomokuGame standardGomoku = new GomokuFactory().getGame(GomokuType.Standard);
        assertEquals(standardGomoku.getGridSize(), 14);

        GomokuGame freeGomoku = new GomokuFactory().getGame(GomokuType.Freestyle);
        assertEquals(freeGomoku.getGridSize(), 14);

        GomokuGame omokGomoku = new GomokuFactory().getGame(GomokuType.Omok);
        assertEquals(omokGomoku.getGridSize(), 18);
    }

    private BlackPlayer p1 = new BlackPlayer("A");
    private WhitePlayer p2 = new WhitePlayer("B");

    private GomokuGame game = new GomokuFactory().getGame(GomokuType.Omok);

    @Test
    public void setGameEnvironmentTest(){
        game.setPlayers(p1, p2);
        game.setGameEnvironment(OpeningType.Standard);
        assertEquals(game.getOpeningRules().getOpeningType(), OpeningType.Standard);
    }

}