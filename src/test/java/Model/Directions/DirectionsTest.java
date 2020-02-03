package Model.Directions;

import Model.Piece;
import Model.Directions.*;
import Model.PieceColor;
import org.junit.Test;
import static org.junit.Assert.*;

public class DirectionsTest {

    private Piece createDir(Directions.Dir dir, int range, int x, int y, int sign){
        Directions DirTest = new DirectionFactory().getDir(dir);
        return DirTest.updatePiece(new Piece(x,y, PieceColor.BLACK),range,sign);
    }

    private void initialization(Directions.Dir dir, int ExpX, int ExpY, int sign){
        Piece p=this.createDir(dir,2,1,2,sign);
        assertEquals(p.getX(),ExpX);
        assertEquals(p.getY(),ExpY);
    }

    @Test
    public void checkUpdateHor(){
        this.initialization(Directions.Dir.HORIZONTAL,3,2,1);
        this.initialization(Directions.Dir.HORIZONTAL,-1,2,-1);
    }

    @Test
    public void checkUpdateVer(){
        this.initialization(Directions.Dir.VERTICAL,1,4,1);
        this.initialization(Directions.Dir.VERTICAL,1,0,-1);
    }

    @Test
    public void checkUpdateDiag1(){
        this.initialization(Directions.Dir.DIAGONAL1,3,4,1);
        this.initialization(Directions.Dir.DIAGONAL1,-1,0,-1);
    }

    @Test
    public void checkUpdateDiag2(){
        this.initialization(Directions.Dir.DIAGONAL2,3,0,1);
        this.initialization(Directions.Dir.DIAGONAL2,-1,4,-1);
    }

}