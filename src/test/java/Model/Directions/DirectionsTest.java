package test.java.Model.Directions;
import Model.Piece;
import Model.Directions.Directions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {

    private Piece CreateDir(Directions.Dir dir,int range,int x,int y,int sign){
        Directions DirTest = Model.Directions.DirectionFactory.getDir(dir).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        return DirTest.updatePiece(new Piece(x,y, Piece.PieceType.BLACK),range,sign);
    };

    @Test
    public void CheckUpdateHor(){
        Piece p=this.CreateDir(Directions.Dir.HORIZONTAL,2,1,2,1);
        assertEquals(p.getX(),3);
        assertEquals(p.getY(),2);
        p=this.CreateDir(Directions.Dir.HORIZONTAL,2,1,2,-1);
        assertEquals(p.getX(),-1);
        assertEquals(p.getY(),2);
    };

    @Test
    public void CheckUpdateVer(){
        Piece p=this.CreateDir(Directions.Dir.VERTICAL,2,1,2,1);
        assertEquals(p.getX(),1);
        assertEquals(p.getY(),4);
        p=this.CreateDir(Directions.Dir.VERTICAL,2,1,2,-1);
        assertEquals(p.getX(),1);
        assertEquals(p.getY(),0);
    };

    @Test
    public void CheckUpdateDiag1(){
        Piece p=this.CreateDir(Directions.Dir.DIAGONAL1,2,1,2,1);
        assertEquals(p.getX(),3);
        assertEquals(p.getY(),4);
        p=this.CreateDir(Directions.Dir.DIAGONAL1,2,1,2,-1);
        assertEquals(p.getX(),-1);
        assertEquals(p.getY(),0);
    };

    @Test
    public void CheckUpdateDiag2(){
        Piece p=this.CreateDir(Directions.Dir.DIAGONAL2,2,1,2,1);
        assertEquals(p.getX(),3);
        assertEquals(p.getY(),0);
        p=this.CreateDir(Directions.Dir.DIAGONAL2,2,1,2,-1);
        assertEquals(p.getX(),-1);
        assertEquals(p.getY(),4);
    };
}