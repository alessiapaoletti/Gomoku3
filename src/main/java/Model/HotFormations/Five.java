package Model.HotFormations;

import Model.Directions.Directions;
import Model.Piece;
import Model.PieceColor;

public class Five extends HotFormations{
    public boolean consecutiveFivePiece(Piece p, int sign, PieceColor col, Directions dir) {
        return isPieceIn(dir.updatePiece(p, range1, sign),col)
                && isPieceIn(dir.updatePiece(p, range2, sign),col)
                && isPieceIn(dir.updatePiece(p, range3, sign),col)
                && isPieceIn(dir.updatePiece(p, range4, sign),col);
    }

    public boolean fiveBoundaries(Piece p, int sign, PieceColor col, Directions dir) {
        return !isPieceIn(dir.updatePiece(p, -range1, sign), col)
                && !isPieceIn(dir.updatePiece(p, range5, sign), col);
    }
}
