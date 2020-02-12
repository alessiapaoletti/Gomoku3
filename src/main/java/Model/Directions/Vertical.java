package Model.Directions;

import Model.Piece.Piece;

public class Vertical implements Directions {

    @Override
    public Piece updatePiece(Piece piece, int increment, int sign) {
        int y = piece.getY() + increment * sign;
        return new Piece(piece.getX(), y, piece.getPieceType());
    }

}
