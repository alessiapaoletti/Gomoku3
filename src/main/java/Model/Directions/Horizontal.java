package Model.Directions;

import Model.Directions.Directions;
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
        return isBlack(updateCoord(x, range1, sign), y) && isBlack(updateCoord(x, range2, sign), y);
    }


    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(updateCoord(x, range3, sign), y) && isEmpty(updateCoord(x, -range1, sign), y) &&
                isEmpty(updateCoord(x, range4, sign), y) && isEmpty(updateCoord(x, -range2, sign), y);
    }
    @Override
    public void Check(int xCord, int yCord, int sign, Set<Pair<Integer,Integer>> aux){
        int x1=xCord + sign;
        int x2=xCord + sign*2;
        int y1=yCord;
        int y2=yCord;
        super.Auxiliary_check(sign,xCord,yCord,x1,y1,x2,y2,aux);
    }
}


//        return !isBlack(updateCoord(x,range3,sign),y) && !isBlack(updateCoord(x,-range1,sign),y) &&
//                !isBlack(updateCoord(x,range4,sign),y) && !isBlack(updateCoord(x,-range2,sign),y);
//
//    }
//
//    @Override
//    public boolean updateOutOpp(int x, int y, int sign) {
//        return !isWhite(updateCoord(x,range3,sign),y) && !isWhite(updateCoord(x,-range1,sign),y) &&
//                !isWhite(updateCoord(x,range4,sign),y) && !isWhite(updateCoord(x,-range2,sign),y);
//    }
//}
