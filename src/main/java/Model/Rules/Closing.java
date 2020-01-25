package Model.Rules;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.HotFormations.Five;
import Model.Piece;
import Model.Player;


import java.util.*;

public abstract class Closing {
    private Player black;
    private Player white;
    Closing (){}

    public void setPlayers(Player p1, Player p2){
        this.black=p1;
        this.white=p2;
    }

    public abstract boolean checkCount(Piece piece, Directions direction, int sign,Five f);

    private boolean findFive(Piece piece, Directions.Dir direction){
        Directions dir = DirectionFactory.getDir(direction).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        Five f = new Five();
        f.setPlayers(this.black, this.white);
        return (f.consecutiveFivePiece(piece, -1, piece.getPieceType(),dir) && this.checkCount(piece,dir,-1,f))
                || (f.consecutiveFivePiece(piece, 1, piece.getPieceType(),dir) && this.checkCount(piece,dir,1,f));
    }

    public boolean isWinning(List<Piece> moves) {
        boolean gameOver = false;
        List<Directions.Dir> directions = Arrays.asList(Directions.Dir.HORIZONTAL, Directions.Dir.VERTICAL,
                Directions.Dir.DIAGONAL1, Directions.Dir.DIAGONAL2);
        for (Directions.Dir dir : directions) {
            for(Piece i : moves) {
                gameOver= this.findFive(i, dir);
                if(gameOver) break;
            }
            if(gameOver) break;
        }
        return gameOver;
    }

    public boolean fullBoard(int dim){
        return (black.getMoves().size() + white.getMoves().size()) == dim * dim;
    }
}
