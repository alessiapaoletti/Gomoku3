package Model.Directions;

import Model.Piece.Piece;

public interface Directions {

    enum Dir{
        HORIZONTAL,
        VERTICAL,
        DIAGONAL1,
        DIAGONAL2
    }

    Piece updatePiece(Piece piece, int increment, int sign);

}