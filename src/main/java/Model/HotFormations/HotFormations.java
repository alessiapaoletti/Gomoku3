package Model.HotFormations;
import Model.Piece;
import Model.Player;

abstract class HotFormations {

    int range1 = 1;
    int range2 = 2;
    int range3 = 3;
    int range4 = 4;
    int range5 = 5;

    private Player black;
    private Player white;

    public void setPlayers(Player p1, Player p2){
        this.black=p1;
        this.white=p2;
    }
/*
    public void printPlayer(){
        this.black.printMoves();
        this.white.printMoves();
    }
*/
    boolean isPieceIn(Piece piece, Piece.PieceType color){
        if(color== Piece.PieceType.BLACK)
            return this.black.isPlayerMove(new Piece(piece.getX(), piece.getY(), Piece.PieceType.BLACK));
        else
            return this.white.isPlayerMove(new Piece(piece.getX(), piece.getY(), Piece.PieceType.WHITE));
    }

    boolean isEmpty(Piece p){
        return !isPieceIn(p, Piece.PieceType.BLACK) && !isPieceIn(p, Piece.PieceType.WHITE);
    }
}
