package Model;
public class Piece  {

    public enum PieceType{
        NOT_VALID,
        EMPTY,
        BLACK,
        WHITE;
        PieceType() {}
    }

    private int x;
    private int y;
    private PieceType pieceType;

    public Piece(int x, int y, PieceType p){
        this.x = x;
        this.y = y;
        this.pieceType = p;
    }

    public Piece(int x, int y ){
        this.x = x;
        this.y = y;
    }


    //public Pair<Integer, Integer> getCoordinates(){ return new Pair<>(this.x, this.y); }

    public int getX() {return this.x; }
    public int getY() {return this.y; }

    PieceType getPieceType(){
        return this.pieceType;
    }

    void setPieceType(PieceType p){
        this.pieceType = p;
    }

}
