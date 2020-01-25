package Model.Directions;
import Model.Piece;

public abstract class Directions {

    public enum Dir{
        HORIZONTAL,
        VERTICAL,
        DIAGONAL1,
        DIAGONAL2
    }

    //public abstract void check(Piece piece, int i, Set<Piece> pieceSet);
    public abstract Piece updatePiece(Piece piece, int increment, int sign);

}