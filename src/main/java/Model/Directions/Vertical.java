package Model.Directions;

import Model.BoardLogic;
import Model.Piece;
import javafx.util.Pair;

import java.util.Set;

public class Vertical extends Directions {


    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(x,updateCoord(y,range3,sign)) || isOutOfGrid(x,updateCoord(y,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range4,sign)) && isOutOfGrid(x,updateCoord(y,-range2,sign)));
    }

    @Override
    public boolean updateIn(int x, int y, int sign,String col) {
        return super.isPieceIn(x,updateCoord(y,range1,sign),col)
                && super.isPieceIn(x,updateCoord(y,range2,sign),col);
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(x,updateCoord(y,range3,sign)) &&
                isEmpty(x,updateCoord(y,-range1,sign)) &&
                isEmpty(x,updateCoord(y,range4,sign)) &&
                isEmpty(x,updateCoord(y,-range2,sign));
    }

    @Override
    public void check(int x, int y, int sign, Set<Piece> pieceSet){
        int y1=y + sign;
        int y2=y + sign*2;
        super.auxiliaryCheck(sign,x,y, x,y1, x,y2,pieceSet);
    }

    public boolean consecutiveFivePiece(int x, int y, int sign,String col) {
        return updateIn(x, y, sign,col)
                && super.isPieceIn(x, updateCoord(y, range3, sign),col)
                && super.isPieceIn(x, updateCoord(y, range4, sign),col);
    }

    @Override
    public boolean FiveBoundaries(int x, int y, int sign, String col) {
        return !super.isPieceIn(x,updateCoord(y, -range1, sign), col)
                && !super.isPieceIn(x,updateCoord(y, range5, sign), col);
    }
}
