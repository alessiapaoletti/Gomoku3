package Model.HotFormations;

import Model.Piece;
import Model.PieceColor;
import Model.BlackPlayer;
import Model.WhitePlayer;

abstract class HotFormations {

    int range1 = 1;
    int range2 = 2;
    int range3 = 3;
    int range4 = 4;
    int range5 = 5;

    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    boolean isPieceIn(Piece piece, PieceColor color){
        if(color == PieceColor.BLACK)
            return this.blackPlayer.isPlayerMove(new Piece(piece.getX(), piece.getY(), PieceColor.BLACK));
        else
            return this.whitePlayer.isPlayerMove(new Piece(piece.getX(), piece.getY(), PieceColor.WHITE));
    }

    boolean isEmpty(Piece p){
        return !isPieceIn(p, PieceColor.BLACK) && !isPieceIn(p, PieceColor.WHITE);
    }
}
