package Model.Rules.Closing;

import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.HotFormations.Five;
import Model.Piece;
import Model.PieceColor;
import Model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClosingTest {

    private Player black=new Player("mario", PieceColor.BLACK);
    private Player white=new Player("mario",PieceColor.WHITE);


    private NoOverlines noOverlines = new NoOverlines();
    private Overlines overlines = new Overlines();


    private int gridDim = 14;

    private void clearMoves (){
        this.black.getMoves().clear();
        this.white.getMoves().clear();
    }

    private void fullBoardConfiguration(){
        clearMoves();
        for (int i = 0; i<gridDim; i ++ ) {
            for (int j = 0; j <gridDim; j++)
                this.black.addMove(new Piece(i, j, PieceColor.BLACK));
        }
    }

    @Test
    public void testFullBoard(){
      /*  overlines.setPlayers(black, white);
        noOverlines.setPlayers(black, white);
        assertFalse(overlines.fullBoard(gridDim));
        assertFalse(noOverlines.fullBoard(gridDim));

        this.fullBoardConfiguration();
        assertTrue(overlines.fullBoard(gridDim));
        assertTrue(noOverlines.fullBoard(gridDim)); */
    }


    private void horizontalWinning(Player p){
        p.getMoves().clear();
        for(int i=0;i<5;i++) p.addMove(new Piece(i,0, p.getColor()));
    }

    @Test
    public void isWinnigHorizontal(){
        overlines.setPlayers(this.black,this.white);

        assertFalse(overlines.isWinning(this.black.getMoves()));
        horizontalWinning(this.black);
        assertTrue(overlines.isWinning(this.black.getMoves()));

        horizontalWinning(this.white);
        assertTrue(overlines.isWinning(this.white.getMoves()));

        noOverlines.setPlayers(this.black,this.white);
        horizontalWinning(this.black);
        assertTrue(noOverlines.isWinning(this.black.getMoves()));

        horizontalWinning(this.white);
        assertTrue(noOverlines.isWinning(this.white.getMoves()));
    }



    @Test
    public void checkCountOverlines(){
        Directions dir = DirectionFactory.getDir(Directions.Dir.HORIZONTAL);
        Five f=new Five();
        assertTrue(overlines.checkCount(new Piece(5,7,PieceColor.BLACK), dir, 1, f));
    }



}