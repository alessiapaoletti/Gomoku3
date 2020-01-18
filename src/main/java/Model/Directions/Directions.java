package Model.Directions;

import Model.GomokuGame;
import Model.Piece;
import Model.Player;
import javafx.util.Pair;

import java.util.Set;

public abstract class Directions {

    protected boolean in = true;
    protected boolean out = true;
    protected boolean outOpp = true;


    final int range1 = 1;
    final int range2 = 2;
    final int range3 = 3;
    final int range4 = 4;
    final int range5 = 5;

    public abstract  boolean outOfGridCheck(int x, int y, int sign);
    public abstract boolean updateIn(int x, int y, int sign );
    public abstract boolean updateOut(int x, int y, int sign );
    //public abstract boolean updateOutOpp(int x, int y, int sign );
    public abstract void Check(int x, int y, int sign, Set<Pair<Integer, Integer>> aux);
    /* queste funzioni non credo vadano qui..

   GetBlack e geWhite da implementare nella classe GomukoGame?  */

    boolean isBlack(int x, int y){
        Player blackPlayer = GomokuGame.GetBlack();
        Piece newPiece=new Piece(blackPlayer.getColor().get());
        newPiece.setX(x);
        newPiece.setY(y);
        return blackPlayer.checkMoves(newPiece);
    }

    boolean isWhite(int x, int y){
        Player whitePlayer = GomokuGame.GetWhite();
        Piece newPiece=new Piece(whitePlayer.getColor().get());
        newPiece.setX(x);
        newPiece.setY(y);
        return whitePlayer.checkMoves(newPiece);
    }

    boolean isEmpty(int x, int y){
        return !isBlack(x,y) && !isWhite(x,y);
    }

    boolean isOutOfGrid(int x, int y){
        return ((x <0 || x>GomokuGame.getGridDim()) || (y<0 || y>GomokuGame.getGridDim()));
    }

    int updateCoord(int cord, int increment, int sign) {
        return cord + increment * sign;
    }

//    protected int updateCoord1(int cord, int sign){
//        return updateCoord(cord, range1, sign);
//    }
//
//    protected int updateCoord3(int cord, int sign){
//        return updateCoord(cord, range3, -sign);
//    }

    protected void FillIn(int xCord, int yCord, int xCord1, int yCord1, int xCord2, int yCord2, Set<Pair<Integer,Integer>> aux){
        aux.add(new Pair<>(xCord,yCord));
        aux.add(new Pair<>(xCord1,yCord1));
        aux.add(new Pair<>(xCord2,yCord2));
    };

    protected void Auxiliary_check(int sign,int xCord, int yCord, int xCord1, int yCord1, int xCord2, int yCord2, Set<Pair<Integer,Integer>> aux) {
        if (this.updateIn(xCord, yCord, sign) && this.updateOut(xCord, yCord, sign) /*&& this.updateOutOpp(xCord, yCord, sign)*/
                && this.outOfGridCheck(xCord, yCord, sign)) {
            this.FillIn(xCord1, yCord1, xCord2, yCord2, xCord, yCord, aux);
        }
    }

}
