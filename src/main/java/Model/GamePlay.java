package Model;

import Controller.BoardController;
import View.Alert;
import javafx.util.Pair;

public class GamePlay {

    private BoardLogic myBoard;
    private int currentPlayer;
    private GomokuGame game;
    private Closing closing;
    private String gameName;
    private String OpeningName;


    public GamePlay(GomokuGame game, int gridSize) {
        this.myBoard = new BoardLogic(gridSize);
        this.game = game;
        this.game.initGame();
        this.gameName = this.game.getGameName();
        this.OpeningName=this.game.getOpeningRulesName();
        this.currentPlayer = BoardLogic.BLACK_PLAYER;
        this.closing = new Closing(this.myBoard,this.gameName);
    }

    private void checkWinningMove(int x, int y){
        if(this.closing.checkWinner(x,y)){
            String winner_name;
            if(this.currentPlayer ==this.game.getP1().getColor()){
                winner_name  = this.game.getP1().getName();
            }
            else winner_name  = this.game.getP2().getName();

            BoardController.gameOver(winner_name);
        }

    }

    private void checkFullBoard(){
        if(this.closing.fullBoard())
            BoardController.gameOver();
    }


    public void placePiece(final int x, final int y) {

        this.InsertMove(x,y);
        this.myBoard.setPiece(x, y,this.currentPlayer);
        this.checkWinningMove(x,y);
        this.checkFullBoard();
        this.swapPlayers(); //cambia il colore
        this.Print();

    }


    public void unplacePiece(final int x, final int y) {

        this.swapPlayers();
        this.RemoveMove(x,y);
    }

    //utility function to call specific game's opening rule.
    public void Opening(int c){
        this.game.callOpeningRules(c);
    }

    public void Rules(){
        this.game.setInvalidMoves();
    }


    public int InitialMove(){
        Alert.openingRulesAlert(this.game.getOpeningRulesName());

        if(this.OpeningName.equals("Pro") || this.OpeningName.equals("LongPro")){
            if(this.myBoard.boardSize ==16) this.placePiece(7,7);
            else this.placePiece(9,9);
            return 1;
        }
        else return 0;
    }

    //Insert moves in private player's set.
    private void InsertMove( int x,  int y){
        Pair<Integer, Integer> pair = new Pair<>(x, y);

        if(this.currentPlayer ==this.game.getP1().getColor()){
            this.game.getP1().addPosition(pair);
        }
        else{
            this.game.getP2().addPosition(pair);
        }
    }

    private void RemoveMove(int x,  int y){

        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(x,y);
        if(this.currentPlayer ==this.game.getP1().getColor()){
            if(this.game.getP1().checkMove(pair)) this.game.getP1().removePosition(this.game.getP1().getPositions().size()-1);
        }
        else{
            if(this.game.getP2().checkMove(pair)) this.game.getP2().removePosition(this.game.getP2().getPositions().size()-1);
        }
    }

    // private method for swapping the players
    private void swapPlayers() {
        if (this.currentPlayer == BoardLogic.WHITE_PLAYER) {
            this.currentPlayer = BoardLogic.BLACK_PLAYER;
        }
        else {
            this.currentPlayer = BoardLogic.WHITE_PLAYER;
        }
    }


    private void Print(){
        this.game.getP1().PrintPositions();
        this.game.getP2().PrintPositions();
    }


    public boolean isValidMove(int x, int y) {
        if (this.myBoard.getPiece(x,y)!= BoardLogic.EMPTY_SPACE)
            return (false);
        return (true);
    }

    public int getNumMovesOpening(){ return this.game.getNumMovesOpening();}

    public int getCurrentPlayer(){
        return currentPlayer;
    }

}
