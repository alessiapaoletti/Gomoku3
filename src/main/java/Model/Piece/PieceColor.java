package Model.Piece;

public enum PieceColor {
        EMPTY { @Override public PieceColor oppositeColor() { return EMPTY; }},
        BLACK { @Override public PieceColor oppositeColor() { return WHITE; }},
        WHITE { @Override public PieceColor oppositeColor() { return BLACK; }};


        abstract public PieceColor oppositeColor();
}
