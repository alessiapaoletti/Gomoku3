package Model;


public class Piece  {

    public enum PieceType{
        NOT_VALID(-1),
        EMPTY(0),
        BLACK(1),
        WHITE(2);
        public int colorPiece;
        PieceType(int i) {
            this.colorPiece = i;
        }
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
