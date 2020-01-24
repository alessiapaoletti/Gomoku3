package Model.Directions;
import Model.BoardLogic;
import Model.Piece;
import javafx.util.Pair;
import java.util.Set;

public class VerticalGap extends Directions {

    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(x,updateCoord(y,range4,sign)) && isOutOfGrid(x,updateCoord(x,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range5,sign)) && isOutOfGrid(x,updateCoord(y,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range4,sign)) && super.isPieceIn(x,updateCoord(y,-range1,sign),"white")) &&
                !(super.isPieceIn(x,updateCoord(y,range4,sign),"white") && isOutOfGrid(x,updateCoord(y,-range1,sign)));
    }

    @Override
    public boolean updateIn(int x, int y, int sign,String col) {
        return super.isPieceIn(x,updateCoord(y,range2,sign),col)
                && super.isPieceIn(x,updateCoord(y,range3,sign),col);
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(x,updateCoord(y,range1,sign)) &&
                isEmpty(x,updateCoord(y,-range1,sign)) &&
                isEmpty(x,updateCoord(y,range4,sign));
    }

    @Override
    public void check(int x, int y, int sign, Set<Piece> pieceSet){
        int y1=y+ sign * 2;
        int y2=y+ sign*3;
        super.auxiliaryCheck(sign,x,y, x,y1, x,y2,pieceSet);
    }

    @Override
    public boolean consecutiveFivePiece(int x, int y, int sign,String col) {
        return false;
    }

    @Override
    public boolean FiveBoundaries(int x, int y, int sign, String col) {
        return false;
    }
}
