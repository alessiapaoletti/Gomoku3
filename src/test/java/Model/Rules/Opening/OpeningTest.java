package Model.Rules.Opening;

import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import Model.GomokuGame.GomokuType;
import Model.Piece;
import Model.PieceColor;
import Model.Player;
import Model.BlackPlayer;
import Model.WhitePlayer;
import org.junit.Test;
import static org.junit.Assert.*;

public class OpeningTest {

    @Test
    public void openingFactoryTest(){
        Opening openingStd = OpeningFactory.getOpening(OpeningType.Standard);
        assertEquals(openingStd.getOpeningType(), OpeningType.Standard);
        assertEquals(openingStd.numMoves, 2);

        Opening openingSwap = OpeningFactory.getOpening(OpeningType.Swap);
        assertEquals(openingSwap.getOpeningType(), OpeningType.Swap);
        assertEquals(openingSwap.numMoves, 3);

        Opening openingSwap2 = OpeningFactory.getOpening(OpeningType.Swap2);
        assertEquals(openingSwap2.getOpeningType(), OpeningType.Swap2);
        assertEquals(openingSwap2.numMoves, 3);
    }

    BlackPlayer p1 = new BlackPlayer("A");
    WhitePlayer p2 = new WhitePlayer("B");

    /*@Test(expected = Error.class)
    public void checkErrorTest(){
        p1.addMove(new Piece(1,1, PieceColor.BLACK));
        p1.addMove(new Piece(1,2, PieceColor.BLACK));

        p2.addMove(new Piece(2,2, PieceColor.WHITE));
        p2.addMove(new Piece(1,2, PieceColor.BLACK)); // -->attenzione errore nella funzione checkError

        GomokuGame gomokuGame = GomokuFactory.getGame(GomokuType.Standard);
        gomokuGame.setPlayers(p1, p2);
        gomokuGame.setGameEnvironment(OpeningType.Standard);
        gomokuGame.getOpeningRules().openingBehaviour(2);
    }*/

    @Test
    public void utilitySwapTest(){
        p1.addMove(new Piece(1,1, PieceColor.BLACK));
        p1.addMove(new Piece(2,2, PieceColor.BLACK));

        p2.addMove(new Piece(3,3, PieceColor.WHITE));

        GomokuGame gomokuGame = GomokuFactory.getGame(GomokuType.Standard);
        gomokuGame.setPlayers(p1, p2);
        gomokuGame.setGameEnvironment(OpeningType.Swap);
        SwapOpening swapOpening = (SwapOpening) gomokuGame.getOpeningRules();
        swapOpening.utilitySwap();

        assertEquals(gomokuGame.getWhitePlayer().getColor(), PieceColor.WHITE);
        assertEquals(gomokuGame.getBlackPlayer().getColor(), PieceColor.BLACK);

        assertEquals(gomokuGame.getWhitePlayer().getMoves().size(), 1);
        assertEquals(gomokuGame.getBlackPlayer().getMoves().size(), 2);
    }

    @Test
    public void utilitySwap2Test(){
        p1.addMove(new Piece(1,1, PieceColor.BLACK));
        p1.addMove(new Piece(2,2, PieceColor.BLACK));
        p1.addMove(new Piece(3,3, PieceColor.BLACK));

        p2.addMove(new Piece(4,4, PieceColor.WHITE)); //--> ATTENZIONE: AL GIOCATORE BIANCO POSSO AGGIUNGERE PEDINE NERE E VIC
        p2.addMove(new Piece(5,5, PieceColor.WHITE));

        GomokuGame gomokuGame = GomokuFactory.getGame(GomokuType.Standard);
        gomokuGame.setPlayers(p1, p2);
        gomokuGame.setGameEnvironment(OpeningType.Swap2);
        SwapOpening swap2Opening = (Swap2Opening) gomokuGame.getOpeningRules();
        swap2Opening.utilitySwap();

        assertEquals(gomokuGame.getWhitePlayer().getColor(), PieceColor.WHITE);
        assertEquals(gomokuGame.getBlackPlayer().getColor(), PieceColor.BLACK);

        assertEquals(gomokuGame.getWhitePlayer().getMoves().size(), 2);
        assertEquals(gomokuGame.getBlackPlayer().getMoves().size(), 3);

    }

}