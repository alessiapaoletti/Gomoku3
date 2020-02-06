package Model;
import java.util.Objects;

public class Piece  {

    private int x;
    private int y;
    private PieceColor pieceColor;

    public Piece(int x, int y, PieceColor p){
        this.x = x;
        this.y = y;
        this.pieceColor = p;
    }

    public boolean samePosition(Piece piece) {return this.x ==piece.x && this.y == piece.y ; }

    public PieceColor getPieceType(){return  this.pieceColor; }
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
                pieceColor.equals(piece.pieceColor);
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y,pieceColor);
    }
}