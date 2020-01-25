package Model.HotFormations;

import Model.Piece;
import Model.Directions.Directions;
import java.util.Set;

public class GapThree extends Three {
    @Override
    public boolean outOfGridCheck(Piece p, int sign, Directions dir) {
        return !(isOutOfGrid(dir.updatePiece(p,range4,sign)) && isOutOfGrid(dir.updatePiece(p,-range1,sign))) &&
                !(isOutOfGrid(dir.updatePiece(p,range5,sign)) && isOutOfGrid(dir.updatePiece(p,-range1,sign))) &&
                !(isOutOfGrid(dir.updatePiece(p,range4,sign)) && super.isPieceIn(dir.updatePiece(p,-range1,sign), Piece.PieceType.WHITE)) &&
                !(super.isPieceIn(dir.updatePiece(p,range4,sign), Piece.PieceType.WHITE) && isOutOfGrid(dir.updatePiece(p,-range1,sign)));

    }

    @Override
    public boolean updateIn(Piece p, int sign,Piece.PieceType col, Directions dir) {
        return super.isPieceIn(dir.updatePiece(p,range2,sign),col)
                && super.isPieceIn(dir.updatePiece(p,range3,sign),col);
    }

    @Override
    public boolean updateOut(Piece p, int sign, Directions dir) {
        return isEmpty(dir.updatePiece(p, range1, sign)) &&
                isEmpty(dir.updatePiece(p, -range1, sign)) &&
                isEmpty(dir.updatePiece(p, range4, sign));
    }

    @Override
    public void check(Piece p, int sign, Set<Piece> pieceSet, Directions dir){
        Piece p1=dir.updatePiece(p,range2,sign);
        Piece p2=dir.updatePiece(p,range3,sign);
        super.auxiliaryCheck(sign,p,p1,p2,pieceSet, dir);
    }
}
