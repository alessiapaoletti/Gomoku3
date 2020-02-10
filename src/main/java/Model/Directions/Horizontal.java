package Model.Directions;

import Model.Piece.Piece;

public class Horizontal implements Directions {

    @Override
    public Piece updatePiece(Piece piece, int increment, int sign) {
        int x = piece.getX() + increment * sign;
        return new Piece(x, piece.getY(), piece.getPieceType());
    }
}
