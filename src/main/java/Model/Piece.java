package Model;
import java.awt.*;
import java.util.Objects;

public class Piece  {

    private Point position;

    public Point getPosition() {
        return this.position;
    }

    public enum PieceType{
        NOT_VALID,
        EMPTY,
        BLACK,
        WHITE;
        PieceType() {}
    }

    //private Point position;
    private PieceType pieceType;

    public Piece(int x, int y, PieceType p){

        position = new Point(x,y);
        this.pieceType = p;
    }

    public Piece(int x, int y ){
        position = new Point(x,y);

    }
    //metodi Point
    public int getX() {return (int) position.getX(); }
    public int getY() {return (int) position.getY(); }

    PieceType getPieceType(){
        return this.pieceType;
    }

    void setPieceType(PieceType p){
        this.pieceType = p;
    }

    boolean equalsCoordinates(Piece piece){
        return this.position.equals(piece.getPosition());
    }

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
        return position.equals(piece.position) &&
                pieceType.equals(piece.pieceType);
    }

    @Override
    public int hashCode(){
        return Objects.hash(position,pieceType);
    }
}
