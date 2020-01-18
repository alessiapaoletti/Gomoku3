package Model.Directions;

import Model.Directions.Directions;
import javafx.util.Pair;

import java.util.Set;

public class Diagonal2Gap extends Directions {
    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(updateCoord(x,range4,sign),updateCoord(y,-range4,sign)) && isOutOfGrid(updateCoord(x,-range1,sign),updateCoord(y,range1,sign))) &&
                !(isOutOfGrid(updateCoord(x,range5,sign),updateCoord(y,-range5,sign)) && isOutOfGrid(updateCoord(x,-range1,sign),updateCoord(y,range1,sign))) &&
                !(isOutOfGrid(updateCoord(x,range4,sign),updateCoord(y,-range4,sign)) && isWhite(updateCoord(x,-range1,sign),updateCoord(y,range1,sign))) &&
                !(isWhite(updateCoord(x,range4,sign),updateCoord(y,-range4,sign)) && isOutOfGrid(updateCoord(x,-range1,sign),updateCoord(y,range1,sign)));

    }

    @Override
    public boolean updateIn(int x, int y, int sign) {
        return isBlack(updateCoord(x,range2,sign),updateCoord(y,-range2,sign)) &&
                isBlack(updateCoord(x,range3,sign),updateCoord(y,-range3,sign));
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(updateCoord(x, range1, sign), updateCoord(y, -range1, sign)) &&
                isEmpty(updateCoord(x, -range1, sign), updateCoord(y, range1, sign)) &&
                isEmpty(updateCoord(x, range4, sign), updateCoord(y, -range4, sign));
    }
//        return !isBlack(updateCoord(x,range1,sign),updateCoord(y,-range1,sign)) && !isBlack(updateCoord(x,-range1,sign),updateCoord(y,range1,sign)) &&
//                !isBlack(updateCoord(x,range4,sign),updateCoord(y,-range4,sign));
//    }
//
//    @Override
//    public boolean updateOutOpp(int x, int y, int sign) {
//        return !isWhite(updateCoord(x,range1,sign),updateCoord(y,-range1,sign)) && !isWhite(updateCoord(x,range4,sign),updateCoord(y,-range4,sign)) &&
//                !isWhite(updateCoord(x,-range1,sign),updateCoord(y,range1,sign));
//    }

    @Override
    public void Check(int xCord, int yCord, int sign, Set<Pair<Integer,Integer>> aux){
        int x1=xCord+ sign * 2;
        int x2=xCord+ sign*3;
        int y1=yCord+ sign * (-2);
        int y2=yCord+ sign*(-3);
        super.Auxiliary_check(sign,xCord,yCord,x1,y1,x2,y2,aux);
    };
}
