
package Model;

import Controller.BoardController;
import View.Alert;
import static Model.GomokuGame.*;
import static Model.GomokuGame.currentPlayer;

public class BoardLogic {

    private Piece[][] piecesMatrix; // matrix for the internal representation of the board and the pieces that are in place
    int boardSize;
    public static final int EMPTY_SPACE = 0;
    public static final int BLACK_PLAYER = 1;
    public static final int WHITE_PLAYER = 2;

    public BoardLogic(final int inputSize){
        this.boardSize = inputSize;
        this.piecesMatrix = new Piece[inputSize+1][inputSize+1];
    }

    public Piece[][] getPiecesMatrix(){ return this.piecesMatrix; }

    public boolean validCoords(final int x, final int y) {
        return (x >= 0 && x < boardSize) && (y >= 0 && y < boardSize);
    }

    // private method for getting a piece on the board. this will return the board
    // value unless we access an index that doesnt exist. this is to make the code
    // for determining reverse chains much easier
    public int getPiece(final int x, final int y) {
        if (validCoords(x, y)) return (piecesMatrix[x][y].getPiece());
        else return (-1);
    }

    private void InsertMove( int x,  int y){
        Piece m=new Piece(currentPlayer);
        m.setX(x);
        m.setY(y);
        if(currentPlayer == getP1().getColor().get()){
            getP1().addPosition(m);
        }
        else{
            getP2().addPosition(m);
        }
    }

    private void RemoveMove(int x,  int y){
        Piece m=new Piece(currentPlayer);
        m.setX(x);
        m.setY(y);
        if(currentPlayer == getP1().getColor().get()){
            if(getP1().checkMoves(m)) getP1().removePosition(getP1().getPositions().size()-1);
        }
        else{
            if(getP2().checkMoves(m)) getP2().removePosition(getP2().getPositions().size()-1);
        }
        getPiecesMatrix()[x][y].setPiece(BoardLogic.EMPTY_SPACE);
        //this.myBoard.pieces[x][y].removePiece();
    }

    private void swapPlayers() {
        if (currentPlayer == BoardLogic.WHITE_PLAYER) {
            currentPlayer = BoardLogic.BLACK_PLAYER;
        }
        else {
            currentPlayer =BoardLogic.WHITE_PLAYER;
        }
    }

    private void Print(){
        getP1().PrintPositions();
        getP2().PrintPositions();
    }

    public boolean isValidMove(int x, int y) {
        return getPiecesMatrix()[x][y].getPiece() == BoardLogic.EMPTY_SPACE;
    }



    // public method that will try to place a piece in the given x (col ),y (row )coordinate
    public void placePieceBl(final int x, final int y) {
        if (getPiece(x, y) != 0)
            return;

        if (!this.isValidMove(x, y))
            return;

        getPiecesMatrix()[x][y].setPiece(currentPlayer);
        this.InsertMove(x,y);

        if(GamePlay.game.closingRules.checkWinner(x,y)){
            String winner_name;
            if(currentPlayer == GomokuGame.getP1().getColor().get()){
                winner_name  = GomokuGame.getP1().getName();
            }
            else winner_name  = GomokuGame.getP2().getName();

            BoardController.gameOver(winner_name );
        }

        if(GamePlay.game.closingRules.fullBoard()) BoardController.gameOver();

        this.swapPlayers(); //cambia il colore
        this.Print();
    }

    // public method that will try to unplace a piece in the given x (col ),y (row )coordinate
    public void unplacePieceBl(final int x, final int y) {
        this.swapPlayers();
        getPiecesMatrix()[x][y].removePiece();
        this.RemoveMove(x,y);
    }

}

