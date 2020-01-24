package Model;

import java.util.Objects;

public class Piece  {

    public enum PieceType{
        NOT_VALID,
        EMPTY,
        BLACK,
        WHITE;
        PieceType() {}
    }

    //private Point position;
    private int x;
    private int y;
    public PieceType pieceType;

    public Piece(int x, int y, PieceType p){
        this.x = x;
        this.y = y;
        this.pieceType = p;
    }

    public Piece(int x, int y){
        this.x = x;
        this.y = y;
        this.pieceType = PieceType.EMPTY;
    }

    boolean samePosition(Piece piece) {return this.x ==piece.x && this.y == piece.y ; }

    boolean sameColor(Piece piece){
        return this.pieceType == piece.pieceType;
    }

    public int getX() {return this.x; }
    public int getY() {return this.y;  }

    PieceType getPieceType(){
        return this.pieceType;
    }

    void setPieceType(PieceType p){
        this.pieceType = p;
    }

//
//    boolean equalsCoordinates(Piece piece){
//        return this.position.equals(piece.getPosition());
//    }

    /* Override the equals methods for the Piece class*/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return x == piece.x &&
                y == piece.y &&
                pieceType.equals(piece.pieceType);
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y,pieceType);
    }
}
