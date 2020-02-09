package Model.HotFormations;

import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.Piece.*;
import org.junit.Test;
import Model.HotFormations.ThreeFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ThreeTest extends FiveTest {

    private Directions dir = new DirectionFactory().getDir(Directions.Dir.HORIZONTAL);
    private Three th;
    private Set<Piece> pieceSet = new HashSet<>();

    private void createThree(Three.ThreeTypes three) {
        th = new ThreeFactory().getThree(three);
        th.setDim(19);
        super.fillPlayer(super.black);
        super.black.addMove(new Piece(6, 0, PieceColor.BLACK));
        super.black.addMove(new Piece(7, 0, PieceColor.BLACK));
        th.setPlayers(super.black, super.white);
    }

    private void updateInCheck(Three.ThreeTypes three) {
        this.createThree(three);
        assertTrue(th.updateIn(new Piece(0, 0, PieceColor.BLACK), 1, PieceColor.BLACK, dir));
    }

    private void updateOutCheck(Three.ThreeTypes three) {
        this.createThree(three);
        assertFalse(th.updateOut(new Piece(0, 0, PieceColor.BLACK), 1, dir));
    }

    private void outOfGridCheck(Three.ThreeTypes three) {
        this.createThree(three);
        assertTrue(th.outOfGridCheck(new Piece(2, 0, PieceColor.BLACK), 1, dir));
    }

    @Test
    public void updateCheck() {
        List<Three.ThreeTypes> three = Arrays.asList(Three.ThreeTypes.THREE, Three.ThreeTypes.GAPTHREE);
        for (Three.ThreeTypes i : three) {
            this.updateInCheck(i);
            this.updateOutCheck(i);
            this.outOfGridCheck(i);
        }
    }

    private void fillSetaux(Three.ThreeTypes three, int x, int x1) {
        this.createThree(three);
        super.black.getMoves().clear();
        for (int i = x; i < x1; i++) super.black.addMove(new Piece(i, 0, PieceColor.BLACK));
    }

    private void checkSetaux(int x, int Exp) {
        th.setPlayers(super.black, super.white);
        th.check(new Piece(x, 0, PieceColor.BLACK), 1, pieceSet, dir);
        assertEquals(Exp, pieceSet.size());
    }

    @Test
    public void fillSetcheck() {
        this.fillSetaux(Three.ThreeTypes.THREE, 17, 20);
        this.checkSetaux(17, 0);
    }

    @Test
    public void fillSetGapcheck() {
        this.fillSetaux(Three.ThreeTypes.GAPTHREE, 5, 9);
        this.checkSetaux(5, 0);
        super.black.removeMove(1);
        this.checkSetaux(5, 3);
    }
}