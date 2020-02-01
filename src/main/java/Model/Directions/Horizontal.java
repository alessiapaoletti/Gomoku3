package Model.Directions;

import Model.Piece;

public class Horizontal extends Directions {

    @Override
    public Piece updatePiece(Piece piece, int increment, int sign) {
        int x = piece.getX() + increment * sign;
        return new Piece(x, piece.getY(), piece.getPieceType());
    }
}
