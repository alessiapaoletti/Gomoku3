package Model.GomokuGame;

import Model.PieceColor;
import Model.Player;
import Model.Rules.Opening.OpeningType;
import org.junit.Test;
import static org.junit.Assert.*;


public class GomokuGameTest {
    @Test
    public void gomokuFactoryTest(){
        GomokuGame standardGomoku = GomokuFactory.getGame(GomokuType.Standard);
        assertEquals(standardGomoku.gameType, GomokuType.Standard);
        assertEquals(standardGomoku.getGridSize(), 14);

        GomokuGame freeGomoku = GomokuFactory.getGame(GomokuType.Freestyle);
        assertEquals(freeGomoku.gameType, GomokuType.Freestyle);
        assertEquals(freeGomoku.getGridSize(), 14);

        GomokuGame omokGomoku = GomokuFactory.getGame(GomokuType.Omok);
        assertEquals(omokGomoku.gameType, GomokuType.Omok);
        assertEquals(omokGomoku.getGridSize(), 18);
    }

    private Player p1 = new Player("A", PieceColor.BLACK);
    private Player p2 = new Player("B", PieceColor.WHITE);

    private GomokuGame game = GomokuFactory.getGame(GomokuType.Omok);

    @Test
    public void setGameEnvironmentTest(){
        game.setPlayers(p1, p2);
        game.setGameEnvironment(OpeningType.Standard);
        assertEquals(game.getOpeningRules().getOpeningType(), OpeningType.Standard);
    }

}