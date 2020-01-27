package Model;
import java.util.Objects;

public class Piece  {

    public enum PieceType{
        EMPTY,
        BLACK,
        WHITE
    }

    private int x;
    private int y;
    private PieceType pieceType;

    public Piece(int x, int y, PieceType p){
        this.x = x;
        this.y = y;
        this.pieceType = p;
    }

    public boolean samePosition(Piece piece) {return this.x ==piece.x && this.y == piece.y ; }

    public PieceType getPieceType(){return  this.pieceType; }
    public int getX() {return this.x; }
    public int getY() {return this.y;  }


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