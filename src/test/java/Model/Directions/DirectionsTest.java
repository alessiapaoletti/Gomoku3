package test.java.Model.Directions;
import Model.Piece;
import Model.Directions.Directions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {

    private Piece CreateDir(Directions.Dir dir,int range,int x,int y,int sign){
        Directions DirTest = Model.Directions.DirectionFactory.getDir(dir);
        return DirTest.updatePiece(new Piece(x,y, Piece.PieceType.BLACK),range,sign);
    };

    private void Initialization(Directions.Dir dir,int ExpX,int ExpY,int sign){
        Piece p=this.CreateDir(dir,2,1,2,sign);
        assertEquals(p.getX(),ExpX);
        assertEquals(p.getY(),ExpY);
    };

    @Test
    public void CheckUpdateHor(){
        this.Initialization(Directions.Dir.HORIZONTAL,3,2,1);
        this.Initialization(Directions.Dir.HORIZONTAL,-1,2,-1);
    };

    @Test
    public void CheckUpdateVer(){
        this.Initialization(Directions.Dir.VERTICAL,1,4,1);
        this.Initialization(Directions.Dir.VERTICAL,1,0,-1);
    };

    @Test
    public void CheckUpdateDiag1(){
        this.Initialization(Directions.Dir.DIAGONAL1,3,4,1);
        this.Initialization(Directions.Dir.DIAGONAL1,-1,0,-1);
    };

    @Test
    public void CheckUpdateDiag2(){
        this.Initialization(Directions.Dir.DIAGONAL2,3,0,1);
        this.Initialization(Directions.Dir.DIAGONAL2,-1,4,-1);
    };
}