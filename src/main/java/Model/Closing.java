package Model;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import java.util.*;
import java.util.stream.Stream;

abstract class Closing {
    Closing (){}
    public abstract boolean checkCount(Piece piece, String direction,int sign);

    private boolean findFive(Piece piece, String direction){
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        return (dir.consecutiveFivePiece(piece.getX(), piece.getY(), -1, piece.pieceType.name()) && this.checkCount(piece,direction,-1))
                || (dir.consecutiveFivePiece(piece.getX(), piece.getY(), 1, piece.pieceType.name()) && this.checkCount(piece,direction,1));
    }

    boolean isWinning(List<Piece> moves) {
        boolean gameOver = false;
        List<String> directions = Arrays.asList("Horizontal","Vertical","Diagonal1","Diagonal2");
        for (String dir : directions) {
            for(Piece i : moves) {
                gameOver= this.findFive(i, dir);
                if(gameOver) break;
            }
            if(gameOver) break;
        }
        return gameOver;
    }

    /*
    Function that returns true if the board is full and false otherwise
    **/
    boolean fullBoard(int dim,int MovesP1,int MovesP2){ return (MovesP1 + MovesP2) == dim * dim; }

}
