package Model;


public class Piece  {

    public enum PieceType{
        NOT_VALID,
        EMPTY,
        BLACK,
        WHITE;
        PieceType() {}
    }

    private PieceType pieceType;

    public Piece(PieceType p){
        this.pieceType = p;
    }

    public PieceType getPlayer(){
        return this.pieceType;
    }

    public void setPlayer(PieceType p){
        this.pieceType = p;
    }
}
