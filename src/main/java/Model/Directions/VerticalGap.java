package Model.Directions;

import Model.Directions.Directions;
import javafx.util.Pair;

import java.util.Set;

public class VerticalGap extends Directions {

    @Override
    public boolean outOfGridCheck(int x, int y, int sign) {
        return !(isOutOfGrid(x,updateCoord(y,range4,sign)) && isOutOfGrid(x,updateCoord(x,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range5,sign)) && isOutOfGrid(x,updateCoord(y,-range1,sign))) &&
                !(isOutOfGrid(x,updateCoord(y,range4,sign)) && isWhite(x,updateCoord(y,-range1,sign))) &&
                !(isWhite(x,updateCoord(y,range4,sign)) && isOutOfGrid(x,updateCoord(y,-range1,sign)));
    }

    @Override
    public boolean updateIn(int x, int y, int sign) {
        return isBlack(x,updateCoord(y,range2,sign)) && isBlack(x,updateCoord(y,range3,sign));
    }

    @Override
    public boolean updateOut(int x, int y, int sign) {
        return isEmpty(x,updateCoord(y,range1,sign)) &&
                isEmpty(x,updateCoord(y,-range1,sign)) &&
                isEmpty(x,updateCoord(y,range4,sign));
    }

    @Override
    public void Check(int xCord, int yCord, int sign, Set<Pair<Integer,Integer>> aux){
        int x1=xCord;
        int x2=xCord;
        int y1=yCord+ sign * 2;
        int y2=yCord+ sign*3;
        super.Auxiliary_check(sign,xCord,yCord,x1,y1,x2,y2,aux);
    }


//        return !isBlack(x,updateCoord(y,range1,sign)) && !isBlack(x,updateCoord(y,-range1,sign)) && !isBlack(x,updateCoord(y,range4,sign));
//    }
//
//    @Override
//    public boolean updateOutOpp(int x, int y, int sign) {
//        return !isWhite(x,updateCoord(y,range1,sign)) && !isWhite(x,updateCoord(y,range4,sign)) && !isWhite(x,updateCoord(y,-range1,sign));
//    }
}
