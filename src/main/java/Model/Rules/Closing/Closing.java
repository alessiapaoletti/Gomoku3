package Model.Rules.Closing;

import Model.BlackPlayer;
import Model.Directions.DirectionFactory;
import Model.Directions.Directions;
import Model.HotFormations.Five;
import Model.Piece;
import Model.WhitePlayer;


import java.util.*;

public abstract class Closing {

    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;

    Closing (){}

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public abstract boolean checkCount(Piece piece, Directions direction, int sign,Five f);

    private boolean findFive(Piece piece, Directions.Dir direction){
        Directions dir = DirectionFactory.getDir(direction);
        Five f = new Five();
        f.setPlayers(this.blackPlayer, this.whitePlayer);
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
        //return (blackPlayer.getMoves().size() + whitePlayer.getMoves().size()) == (dim+1) * (dim+1);
        return (blackPlayer.listSize() + whitePlayer.listSize()) == (dim+1) * (dim+1);

    }
}
