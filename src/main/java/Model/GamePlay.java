package Model;
import View.Alert;

import java.awt.*;

public class GamePlay {

    private BoardLogic myBoard;
    private Piece.PieceType currentPlayer;
    private GomokuGame game;
    private Closing closing;
    private String OpeningName;

    public GamePlay(GomokuGame game, int gridSize) {
        this.myBoard = new BoardLogic(gridSize);
        this.game = game;
        this.game.initGame();
        String gameName = this.game.getGameName();
        this.OpeningName= this.game.getOpeningRulesName();
        this.currentPlayer = Piece.PieceType.BLACK;
        this.closing = ClosingFactory.getClosing(gameName).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
    }

    private Player GetcurrentPlayer(){
        if(this.currentPlayer==game.getP1().getColor())
            return game.getP1();
        else
            return game.getP2();
    };


    public String checkWinningMove(){
       // Piece winningPiece = new Piece(x,y,this.currentPlayer);
        String winner_name = "";
        if(this.closing.isWinning(this.GetcurrentPlayer().getMoves()))
            winner_name=this.GetcurrentPlayer().getName();
        return winner_name;
    }

    public boolean checkFullBoard(){
        return this.closing.fullBoard(this.myBoard.boardSize,this.game.getP1().getMoves().size(),this.game.getP2().getMoves().size());
           // BoardController.gameOver();
    }


    public void placePiece(final int x, final int y) {
        Piece newPiece = new Piece(x,y);
        this.insertMove(newPiece);
        this.myBoard.setPiece(x, y,this.currentPlayer);
        //this.checkWinningMove(x,y);
        //this.checkFullBoard();
        //this.swapPlayers(); //cambia il colore
        this.printAllMoves();

    }

    public void unplacePiece(final int x, final int y) {
        this.swapPlayers();
        Piece bannedPiece = new Piece(x,y);
        this.removeMove(bannedPiece);
    }

    //utility function to call specific game's opening rule.
    public void opening(int c){
        this.game.callOpeningRules(c);
    }

    public void rules(){
        this.game.setInvalidMoves(this.myBoard.boardSize);
    }

    public int initialMove(){
        Alert.openingRulesAlert(game.getOpeningRulesName());
        return 0;
    }

    private void insertMove(Piece newPiece){
        newPiece.setPieceType(GetcurrentPlayer().getColor());
        this.GetcurrentPlayer().addMove(newPiece);
        /*if(this.currentPlayer == GomokuGame.getP1().getColor()) {
            newPiece.setPieceType(GomokuGame.getP1().getColor());
            GomokuGame.getP1().addMove(newPiece);

        }
        else {
            newPiece.setPieceType(GomokuGame.getP2().getColor());
            GomokuGame.getP2().addMove(newPiece);
        }*/
    }


    private void removeMove(Piece bannedPiece){
        //Piece.PieceType colorFirstPlayer = GomokuGame.getP1().getColor();
        if(this.GetcurrentPlayer().isPlayerMove(bannedPiece)) this.GetcurrentPlayer().removeMove(this.GetcurrentPlayer().getMoves().size()-1);
       /* if(this.currentPlayer == colorFirstPlayer)
            if(GomokuGame.getP1().isPlayerMove(bannedPiece)) GomokuGame.getP1().removeMove(GomokuGame.getP1().getMoves().size()-1);
        else
            if(GomokuGame.getP2().isPlayerMove(bannedPiece)) GomokuGame.getP2().removeMove(GomokuGame.getP2().getMoves().size()-1);*/
        myBoard.setPiece(bannedPiece.getX(),bannedPiece.getY(),Piece.PieceType.EMPTY);  //place empty on the board
    }


    // private method for swapping the players
    public void swapPlayers() {
        if (this.currentPlayer == Piece.PieceType.WHITE) {
            this.currentPlayer = Piece.PieceType.BLACK;
        }
        else
            this.currentPlayer = Piece.PieceType.WHITE;
    }

    private void printAllMoves(){
        game.getP1().printMoves();
        game.getP2().printMoves();
    }

    public boolean isValidMove(final int x, final int y) {
        return this.myBoard.getPiece(x, y) == Piece.PieceType.EMPTY;
    }

    public int getNumMovesOpening(){ return this.game.getNumMovesOpening();}

    public Piece.PieceType getCurrentPlayer(){
        return currentPlayer;
    }

}
