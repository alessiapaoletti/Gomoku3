package Model;

public class BoardLogic {

    Piece[][] piecesMatrix; // matrix for the internal representation of the board and the pieces that are in place
    int boardSize;

    public BoardLogic(final int gridSize){
        this.boardSize = gridSize;
        this.piecesMatrix = new Piece[gridSize + 1][gridSize + 1];
        this.initPieces();
    }

    private void initPieces(){
        for (int i = 0; i <= this.boardSize; i++) {
            for (int j = 0; j <= this.boardSize; j++)
                this.piecesMatrix[i][j] = new Piece(i,j, Piece.PieceType.EMPTY);

        }
    }

    public boolean isOutOfGrid(final int x, final int y) {
        return (x >= 0 && x < this.boardSize) && (y >= 0 && y < this.boardSize);
    }

    public static boolean isPieceBlack(final int x, final int y){
        Piece newPiece = new Piece(x,y, Piece.PieceType.BLACK);
        Player blackPlayer = GomokuGame.getBlackPlayer();
        return blackPlayer.checkMove(newPiece);
    }

    public static boolean isPieceWhite(final int x, final int y){
        Piece newPiece = new Piece(x,y, Piece.PieceType.WHITE);
        Player whitePlayer = GomokuGame.getWhitePlayer();
        return whitePlayer.checkMove(newPiece);
    }

    Piece.PieceType getPiece(final int x, final int y) {
        if (isOutOfGrid(x, y))
            return (this.piecesMatrix[x][y].getPieceType());
        return Piece.PieceType.NOT_VALID;
    }

    void setPiece(final int x, final int y, Piece.PieceType player){
        this.piecesMatrix[x][y].setPieceType(player);
    }
}


