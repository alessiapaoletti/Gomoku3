package Model;

public class BoardLogic {

    Piece[][] piecesMatrix; // matrix for the internal representation of the board and the pieces that are in place
    int boardSize;

//    public static final int EMPTY_SPACE = 0;
//    public static final int BLACK_PLAYER = 1;
//    public static final int WHITE_PLAYER = 2;


    public BoardLogic(final int gridSize){
        this.boardSize = gridSize;
        this.piecesMatrix = new Piece[gridSize + 1][gridSize + 1];
        this.initPieces();

    }

    private void initPieces(){
        for (int i = 0; i <= this.boardSize; i++) {
            for (int j = 0; j <= this.boardSize; j++) {
                this.piecesMatrix[i][j] = new Piece(Piece.PieceType.EMPTY);
            }
        }
    }


    boolean validCoordinates(final int x, final int y) {
        if ((x >= 0 && x < this.boardSize) && (y >= 0 && y < this.boardSize)) {
            return (true);
        }
        return (false);
    }



    Piece.PieceType getPiece(final int x, final int y) {
        if (validCoordinates(x, y))
            return (this.piecesMatrix[x][y].getPlayer());
        return Piece.PieceType.NOT_VALID;
    }

    void setPiece(int x, int y, Piece.PieceType player){
        this.piecesMatrix[x][y].setPlayer(player);
    }


}


