package Model.Directions;

import Model.BoardLogic;
import Model.Piece;
import javafx.util.Pair;

import java.util.Set;

public class Horizontal extends Directions {
    Horizontal(){}

    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(updateCoord(x, range3, sign), y) || isOutOfGrid(updateCoord(x, -range1, sign), y)) &&
                !(isOutOfGrid(updateCoord(x, range4, sign), y) && isOutOfGrid(updateCoord(x, -range2, sign), y));
    }

    @Override
    public boolean updateIn(int x, int y, int sign) {
        return BoardLogic.isPieceBlack(updateCoord(x, range1, sign), y)
                && BoardLogic.isPieceBlack(updateCoord(x, range2, sign), y);
    }


    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(updateCoord(x, range3, sign), y) && isEmpty(updateCoord(x, -range1, sign), y) &&
                isEmpty(updateCoord(x, range4, sign), y) && isEmpty(updateCoord(x, -range2, sign), y);
    }
    @Override
    public void check(int x, int y, int sign, Set<Piece> pieceSet){
        int x1= x + sign;
        int x2= x + sign*2;
        super.auxiliaryCheck(sign,x,y,x1, y,x2, y,pieceSet);
    }
}
