package test.java.Model.HotFormations;
import  Model.Directions.*;
import Model.HotFormations.*;
import Model.HotFormations.Three;
import Model.Piece;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ThreeTest extends FiveTest{
    Directions dir = DirectionFactory.getDir(Directions.Dir.HORIZONTAL);
    Three th;
    Set<Piece> pieceSet= new HashSet<>();
    void CreateThree(Three.ThreeTypes three){
        th = ThreeFactory.getThree(three).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        th.setDim(19);
        super.FillPlayer(super.black);
        super.black.addMove(new Piece(6,0, Piece.PieceType.BLACK));
        super.black.addMove(new Piece(7,0, Piece.PieceType.BLACK));
        th.setPlayers(super.black, super.white);
    };

    void UpdateInCheck(Three.ThreeTypes three){
        this.CreateThree(three);
        assertTrue(th.updateIn(new Piece(0,0, Piece.PieceType.BLACK),1,Piece.PieceType.BLACK,dir));
    };

    void UpdateOutCheck(Three.ThreeTypes three){
        this.CreateThree(three);
        assertFalse(th.updateOut(new Piece(0,0, Piece.PieceType.BLACK),1,dir));
    };

    void outOfGridCheck(Three.ThreeTypes three){
        this.CreateThree(three);
        assertTrue(th.outOfGridCheck(new Piece(2,0, Piece.PieceType.BLACK),1,dir));
    };

    @Test
    void UpdateCheck(){
        List<Three.ThreeTypes> three = Arrays.asList(Three.ThreeTypes.THREE, Three.ThreeTypes.GAPTHREE);
        for(Three.ThreeTypes i : three){
            this.UpdateInCheck(i);
            this.UpdateOutCheck(i);
            this.outOfGridCheck(i);
        }
    };

    @Test
    void FillSetcheck(){
        this.CreateThree(Three.ThreeTypes.THREE);
        super.black.getMoves().clear();
        super.black.addMove(new Piece(17,0, Piece.PieceType.BLACK));
        super.black.addMove(new Piece(18,0, Piece.PieceType.BLACK));
        super.black.addMove(new Piece(19,0, Piece.PieceType.BLACK));
        th.setPlayers(super.black, super.white);
        th.check(new Piece(17,0, Piece.PieceType.BLACK),1,pieceSet,dir);
        assertEquals(0,pieceSet.size());
    };

    @Test
    void FillSetGapcheck(){
        this.CreateThree(Three.ThreeTypes.GAPTHREE);
        super.black.getMoves().clear();
        super.black.addMove(new Piece(5,0, Piece.PieceType.BLACK));
        super.black.addMove(new Piece(7,0, Piece.PieceType.BLACK));
        super.black.addMove(new Piece(8,0, Piece.PieceType.BLACK));
        th.setPlayers(super.black, super.white);
        th.check(new Piece(5,0, Piece.PieceType.BLACK),1,pieceSet,dir);
        assertEquals(3,pieceSet.size());
    };

}