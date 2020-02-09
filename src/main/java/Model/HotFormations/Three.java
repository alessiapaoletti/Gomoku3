package Model.HotFormations;

import Model.Piece.*;
import Model.Directions.Directions;

import java.util.Set;

public abstract class Three extends HotFormations{

    private int dimBoard;
    public enum ThreeTypes{
        THREE,
        GAPTHREE
    }

    public abstract boolean outOfGridCheck(Piece p, int sig, Directions d);
    public abstract boolean updateOut(Piece p, int sign, Directions d);
    public abstract boolean updateIn(Piece p, int sign, PieceColor pt, Directions d);
    public abstract void check(Piece piece, int sign, Set<Piece> pieceSet, Directions d);

    public void setDim(int dim){this.dimBoard =dim;}

    boolean isOutOfGrid(Piece piece){
        return ((piece.getX() <0 || piece.getX()>this.dimBoard) || (piece.getY()<0 || piece.getY()>this.dimBoard));
    }

    private void fillIn(Piece p, Piece p1, Piece p2, Set<Piece> pieceSet){
        pieceSet.add(p);
        pieceSet.add(p1);
        pieceSet.add(p2);
    }

    void auxiliaryCheck(int sign, Piece p, Piece p1, Piece p2, Set<Piece> pieceSet, Directions d) {
        if (this.updateIn(p, sign, PieceColor.BLACK, d) && this.updateOut(p, sign, d) && this.outOfGridCheck(p, sign, d))
            this.fillIn(p1, p2, p, pieceSet);
    }

}
