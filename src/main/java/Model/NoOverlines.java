package Model;

import Model.Directions.DirectionFactory;
import Model.Directions.Directions;

public class NoOverlines extends Closing {

    @Override
    public boolean checkCount(Piece piece, String direction,int sign){
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        return dir.FiveBoundaries(piece.getX(), piece.getY(), sign, piece.pieceType.name());
    }

}
