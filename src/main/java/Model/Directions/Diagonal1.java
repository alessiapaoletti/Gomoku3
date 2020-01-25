package Model.Directions;

import Model.Piece;
import java.util.Set;

public class Diagonal1 extends Directions {

    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(updateCoord(x,range3,sign),updateCoord(y,range3,sign)) || isOutOfGrid(updateCoord(x,-range1,sign),updateCoord(y,-range1,sign)))
                && !(isOutOfGrid(updateCoord(x,range4,sign),updateCoord(y,range4,sign)) && isOutOfGrid(updateCoord(x,-range2,sign),updateCoord(y,-range2,sign)));
    }

    @Override
    public boolean updateIn(int x, int y, int sign,Piece.PieceType col) {
        return super.isPieceIn(updateCoord(x,range1,sign),updateCoord(y,range1,sign),col)
                && super.isPieceIn(updateCoord(x,range2,sign),updateCoord(y,range2,sign),col);
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(updateCoord(x,range3,sign),updateCoord(y,range3,sign)) &&
                isEmpty(updateCoord(x,-range1,sign),updateCoord(y,-range1,sign)) &&
                isEmpty(updateCoord(x,range4,sign),updateCoord(y,range4,sign)) &&
                isEmpty(updateCoord(x,-range2,sign),updateCoord(y,-range2,sign));
    }

    @Override
    public void check(int xCord, int yCord, int sign, Set<Piece> pieceSet){
        int x1=xCord + sign;
        int x2=xCord + sign*2;
        int y1=yCord+ sign;
        int y2=yCord+ sign*2;
        super.auxiliaryCheck(sign,xCord,yCord,x1,y1,x2,y2,pieceSet);
    }

    @Override
    public boolean consecutiveFivePiece(int x, int y, int sign, Piece.PieceType col) {
        return updateIn(x, y, sign,col)
                && super.isPieceIn(updateCoord(x,range3,sign),updateCoord(y,range3,sign),col)
                && super.isPieceIn(updateCoord(x,range4,sign),updateCoord(y,range4,sign),col);
    }

    @Override
    public boolean fiveBoundaries(int x, int y, int sign, Piece.PieceType col) {
        return !super.isPieceIn(updateCoord(x, -range1, sign), updateCoord(y,-range1,sign), col)
                && !super.isPieceIn(updateCoord(x, range5, sign), updateCoord(y,range5,sign), col);
    }
}
