package Model;

import Model.Piece.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class PieceTest {

    private Piece piece1;
    private Piece piece2;

    @Test
    public void samePositionTest() {
        this.piece1 = new Piece(2,4, PieceColor.BLACK);
        this.piece2 = new Piece(2, 4 , PieceColor.WHITE);
        assertTrue(this.piece1.samePosition(piece2));
    }

    @Test
    public void equalsTest() {
        this.piece1 = new Piece(2,4, PieceColor.WHITE);
        this.piece2 = new Piece(2, 4 , PieceColor.WHITE);
        assertEquals(piece1, piece2);
    }

    @Test
    public void getPieceTypeTest() {
        this.piece1 = new Piece(2,3,PieceColor.WHITE);
        assertThat(piece1.getPieceType(), is(PieceColor.WHITE));
    }

    @Test
    public void getXTest() {
        this.piece1 = new Piece(5,7,PieceColor.WHITE);
        assertThat(this.piece1.getX(), is(5));
    }

    @Test
    public void getYTest() {
        this.piece2 = new Piece(5,7,PieceColor.WHITE);
        assertThat(this.piece2.getY(), is(7));
    }
}
