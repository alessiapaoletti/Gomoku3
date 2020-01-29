package Model;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GamePlayTest {

    private Player black=new Player("b", PieceColor.BLACK);
    private Player white=new Player("w", PieceColor.WHITE);
    private GomokuGame gomokuGame = GomokuFactory.getGame(GomokuType.Standard);
    private GamePlay Pgame;
    private void SetConditions(){
        for(int i=0;i<5;i++){ this.black.addMove(new Piece(i,0,PieceColor.BLACK));}
        gomokuGame.setPlayers(this.black,this.white);
        Pgame=new GamePlay(gomokuGame, OpeningType.Standard);
    }

    private void SetFullBoard(){
        for(int i=0;i<14;i++){
            for(int j=0;j<14;j++){ this.black.addMove(new Piece(i,j,PieceColor.BLACK));}
        }
        gomokuGame.setPlayers(this.black,this.white);
        Pgame=new GamePlay(gomokuGame, OpeningType.Standard);
    }
    
    @Test
     public void TestCurrentPlayer(){
        this.SetConditions();
        assertEquals(Pgame.getCurrentPlayer().getName(),this.black.getName());
    }

    @Test
    public void TestWinningPlayer(){
        this.SetConditions();
        assertEquals(Pgame.checkWinningMove(),this.black.getName());
    }

    @Test
    public void TestInsertion(){
        this.SetConditions();
        Pgame.placePiece(9,2);
        assertTrue(Pgame.getCurrentPlayer().isPlayerMove(new Piece(9,2,Pgame.getCurrentPlayer().getColor())));
    }

    @Test
    public void TestDeletion(){
        this.SetConditions();
        Pgame.placePiece(9,2);
        Pgame.displacePiece(9,2);
        assertFalse(Pgame.getCurrentPlayer().isPlayerMove(new Piece(9,2,Pgame.getCurrentPlayer().getColor())));
    }
    @Test
    public void TestSwap(){
        this.SetConditions();
        assertEquals(Pgame.getCurrentPlayer().getName(),this.black.getName());
        Pgame.swapPlayers();
        assertEquals(Pgame.getCurrentPlayer().getName(),this.white.getName());
    }
    @Test
    public void CheckFullBoard(){
        //this.SetFullBoard();
        //assertTrue(Pgame.checkFullBoard());
    }

    @Test
    public void TestValidPiece(){
        this.SetConditions();
        assertTrue(Pgame.isValidMove(10,2));
    }

    @Test
    public void TestOutofBound(){
        this.SetConditions();
        assertTrue(Pgame.isOutOfBound(20,2));
    }

    @Test
    public void TestgetNumOpenings(){
        this.SetConditions();
        assertEquals(Pgame.getNumMovesOpening(),2);
    }

    @Test
    public void TestgetGame(){
        this.SetConditions();
        assertEquals(Pgame.getGame().getOpeningRules().getOpeningType(),OpeningType.Standard);
    }
}