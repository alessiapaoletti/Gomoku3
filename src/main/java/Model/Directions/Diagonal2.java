package Model.Directions;

import Model.Piece.Piece;

public class Diagonal2 implements Directions {

    @Override
    public Piece updatePiece(Piece piece, int increment, int sign) {
        int x = piece.getX() + increment * sign;
        int y = piece.getY() - increment * sign;
        return new Piece(x, y, piece.getPieceType());
    }
}
