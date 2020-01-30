package Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player blackPlayer = new Player("Mario",PieceColor.BLACK);
    private Player whitePlayer = new Player("Pietro",PieceColor.WHITE);
    private final Piece pieceBlack = new Piece(5,6,PieceColor.BLACK);
    private Piece pieceWhite = new Piece(2,5,PieceColor.WHITE);

    @Test
    public void testAddMove(){
        blackPlayer.addMove(pieceBlack);
        int sizeList = blackPlayer.getMoves().size();
        assertEquals(blackPlayer.getMoves().get(sizeList - 1), pieceBlack);
    }

    @Test
    public void removeMoveTest(){
        blackPlayer.addMove(pieceBlack);

        Piece q = new Piece(5,7,PieceColor.BLACK);
        blackPlayer.addMove(q);
        blackPlayer.removeMove(blackPlayer.getMoves().size() - 1);

        assertEquals(blackPlayer.getMoves().get(blackPlayer.getMoves().size() - 1), pieceBlack);
    }

    @Test
    public void getNameTest(){
        assertNotEquals("Nora", this.whitePlayer.getName());
        assertEquals("Pietro",this.whitePlayer.getName());
    }

    @Test
    public void getColorTest(){
        assertEquals(PieceColor.BLACK, this.blackPlayer.getColor());
    }

    @Test
    public void getColorNameTest(){
        assertEquals("WHITE",this.whitePlayer.getColorName());
    }

    @Test
    public void setColorTest(){
        this.blackPlayer.setColor(PieceColor.BLACK);
        assertEquals(this.blackPlayer.getColor(), PieceColor.BLACK);
    }

    @Test
    public void getMovesTest(){
        Piece newPieceWhite = new Piece(2,5,PieceColor.WHITE);
        List<Piece> newList = new ArrayList<>();
        newList.add(pieceWhite);
        newList.add(newPieceWhite);

        whitePlayer.addMove(pieceWhite);
        whitePlayer.addMove(newPieceWhite);

        assertEquals(this.whitePlayer.getMoves(), newList);
    }

    @Test
    public void isPlayerMovesTest(){
        Piece newPieceBlack = new Piece(4,3,PieceColor.BLACK);
        this.blackPlayer.addMove(newPieceBlack);
        assertTrue(this.blackPlayer.isPlayerMove(newPieceBlack));
    }

   
}
