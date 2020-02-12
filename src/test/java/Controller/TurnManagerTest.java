package Controller;

import Model.GomokuGame.GomokuType;
import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurnManagerTest {

    private BlackPlayer blackPlayer = new BlackPlayer("A");
    private WhitePlayer whitePlayer = new WhitePlayer("B");

   private  GameStatusController gameStatusController = new GameStatusController(blackPlayer, whitePlayer,
           GomokuType.Standard, OpeningType.Standard);
   private TurnManager turnManager = new TurnManager(gameStatusController);

    private double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    @Test
    public void turnManagerStd() {
        turnManager.turnManagerStd((int) getRandomIntegerBetweenRange(1, 15));
        assertEquals(whitePlayer.getName(), gameStatusController.getCurrentPlayerName());
    }

    @Test
    public void turnManagerSwap() {
        turnManager.turnManagerSwap((int) getRandomIntegerBetweenRange(1, 2));
        assertEquals(blackPlayer.getName(), gameStatusController.getCurrentPlayerName());

        turnManager.turnManagerSwap((int) getRandomIntegerBetweenRange(3, 15));
        assertEquals(whitePlayer.getName(), gameStatusController.getCurrentPlayerName());
    }

    @Test
    public void getTurnManager() {
        turnManager.getTurnManager(OpeningType.Swap2, (int) getRandomIntegerBetweenRange(1, 2));
        assertEquals(blackPlayer.getName(), gameStatusController.getCurrentPlayerName());

        turnManager.getTurnManager(OpeningType.Swap2, (int) getRandomIntegerBetweenRange(3, 15));
        assertEquals(whitePlayer.getName(), gameStatusController.getCurrentPlayerName());
    }
}