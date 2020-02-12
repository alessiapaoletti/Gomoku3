package Model;

import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import Model.GomokuGame.GomokuType;
import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import Model.Piece.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamePlayTest {

    private BlackPlayer black = new BlackPlayer("b");
    private WhitePlayer white = new WhitePlayer("w");

    private GomokuGame gomokuGame = new GomokuFactory().getGame(GomokuType.Standard);
    private GamePlay gamePlay;

    private void setConditions(){
        for(int i=0;i<5;i++){ this.black.addMove(new Piece(i,0,PieceColor.BLACK));}
        gomokuGame.setPlayers(this.black,this.white);
        gamePlay =new GamePlay(gomokuGame, OpeningType.Standard);
    }

    private void setFullBoard(){
        int gridSize = 14;
        for(int i = 0; i<= gridSize; i++){
            for(int j = 0; j<= gridSize; j++){ this.black.addMove(new Piece(i,j,PieceColor.BLACK));}
        }
        gomokuGame.setPlayers(this.black,this.white);
        gamePlay =new GamePlay(gomokuGame, OpeningType.Standard);
    }
    
    @Test
     public void currentPlayerTest(){
        this.setConditions();
        assertEquals(gamePlay.getCurrentPlayer().getName(),this.black.getName());
    }

    @Test
    public void winningPlayerTest(){
        this.setConditions();
        assertEquals(gamePlay.checkWinningMove(),this.black.getName());
    }

    @Test
    public void placePieceTest(){
        this.setConditions();
        gamePlay.placePiece(9,2);
        assertTrue(gamePlay.getCurrentPlayer().isPlayerMove(new Piece(9,2, gamePlay.getCurrentPlayer().getColor())));
    }

    @Test
    public void displacePieceTest(){
        this.setConditions();
        gamePlay.placePiece(9,2);
        gamePlay.displacePiece(9,2);
        assertFalse(gamePlay.getCurrentPlayer().isPlayerMove(new Piece(9,2, gamePlay.getCurrentPlayer().getColor())));
    }
    @Test
    public void swapTest(){
        this.setConditions();
        assertEquals(gamePlay.getCurrentPlayer().getName(),this.black.getName());
        gamePlay.changeTurn();
        assertEquals(gamePlay.getCurrentPlayer().getName(),this.white.getName());
    }
    @Test
    public void checkFullBoard(){
        this.setFullBoard();
        assertTrue(gamePlay.checkFullBoard());
    }

    @Test
    public void isValidMoveTest(){
        this.setConditions();
        assertTrue(gamePlay.isValidMove(10,2));
    }

    @Test
    public void isOutOfBoundTest(){
        this.setConditions();
        assertTrue(gamePlay.isOutOfBound(20,2));
    }

    @Test
    public void getNumMovesOpening(){
        this.setConditions();
        assertEquals(gamePlay.getNumMovesOpening(),2);
    }

    @Test
    public void getGameTest(){
        this.setConditions();
        assertEquals(gamePlay.getGame().getOpeningRules().getOpeningType(),OpeningType.Standard);
    }
}