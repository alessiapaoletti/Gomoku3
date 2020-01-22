package Model.Directions;

import Model.BoardLogic;
import Model.GomokuGame;
import Model.Piece;
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
    public abstract void check(int x, int y, int sign, Set<Piece> pieceSet);

    boolean isEmpty(int x, int y){
        return !BoardLogic.isPieceBlack(x,y) && !BoardLogic.isPieceWhite(x,y);
    }

    /*questa funzione non ci dovrebbe essere, bisognerebbe chiamare la funzione is outOfGrid della boardLogic*/
    boolean isOutOfGrid(int x, int y){
        return ((x <0 || x>GomokuGame.getGridDim()) || (y<0 || y>GomokuGame.getGridDim()));
    }

    int updateCoord(int cord, int increment, int sign) {
        return cord + increment * sign;
    }

    private void fillIn(int x, int y, int x1, int y1, int x2, int y2, Set<Piece> pieceSet){
        pieceSet.add(new Piece(x,y, Piece.PieceType.BLACK));
        pieceSet.add(new Piece(x1,y1,Piece.PieceType.BLACK));
        pieceSet.add(new Piece(x2,y2,Piece.PieceType.BLACK));
        System.out.println("inside fillIN");
        System.out.println(pieceSet.isEmpty());
    }

    void auxiliaryCheck(int sign, int x, int y, int x1, int y1, int x2, int y2, Set<Piece> pieceSet) {
//        System.out.println("---------");
//        System.out.println(this.updateIn(x, y, sign));
//        System.out.println(this.updateOut(x, y, sign) );
//        System.out.println(this.outOfGridCheck(x, y, sign));
//        System.out.println("---------");
        if (this.updateIn(x, y, sign) && this.updateOut(x, y, sign) && this.outOfGridCheck(x, y, sign))
            this.fillIn(x1, y1, x2, y2, x, y, pieceSet);
    }
}
