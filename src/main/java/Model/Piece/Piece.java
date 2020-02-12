package Model.Piece;

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

}