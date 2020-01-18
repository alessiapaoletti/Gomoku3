package Model.Directions;

import Model.Directions.Directions;
import javafx.util.Pair;

import java.util.Set;

public class Vertical extends Directions {


    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(x,updateCoord(y,range3,sign)) || isOutOfGrid(x,updateCoord(y,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range4,sign)) && isOutOfGrid(x,updateCoord(y,-range2,sign)));
    }

    @Override
    public boolean updateIn(int x, int y, int sign) {
        return isBlack(x,updateCoord(y,range1,sign)) &&
                isBlack(x,updateCoord(y,range2,sign));
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(x,updateCoord(y,range3,sign)) &&
                isEmpty(x,updateCoord(y,-range1,sign)) &&
                isEmpty(x,updateCoord(y,range4,sign)) &&
                isEmpty(x,updateCoord(y,-range2,sign));
    }
//        return !isBlack(x,updateCoord(y,range3,sign)) && !isBlack(x,updateCoord(y,-range1,sign)) &&
//                !isBlack(x,updateCoord(y,range4,sign)) && !isBlack(x,updateCoord(y,-range2,sign));
//    }
//
//    @Override
//    public boolean updateOutOpp(int x, int y, int sign) {
//        return !isWhite(x,updateCoord(y,range3,sign)) && !isWhite(x,updateCoord(y,-range1,sign)) &&
//                !isWhite(x,updateCoord(y,range4,sign)) && !isWhite(x,updateCoord(y,-range2,sign));
//    }

    @Override
    public void Check(int xCord, int yCord, int sign, Set<Pair<Integer,Integer>> aux){
        int y1=yCord + sign;
        int y2=yCord + sign*2;
        int x1=xCord;
        int x2=xCord;
        super.Auxiliary_check(sign,xCord,yCord,x1,y1,x2,y2,aux);
    }
}
