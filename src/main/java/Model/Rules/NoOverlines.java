package Model.Rules;

import Model.Directions.Directions;
import Model.HotFormations.Five;
import Model.Piece;

public class NoOverlines extends Closing {

    @Override
    public boolean checkCount(Piece piece, Directions direction, int sign, Five f){
        return f.fiveBoundaries(piece, sign, piece.getPieceType() ,direction);
    }
}
