package Model;

import Model.GomokuGame.GomokuGame;
import Model.Rules.Opening.OpeningType;

public class GamePlay {
    private PieceColor currentPlayer;
    private GomokuGame game;

    public GamePlay(GomokuGame game, OpeningType openingType) {
        this.game = game;
        this.game.setGameEnvironment(openingType);
        this.currentPlayer = PieceColor.BLACK;
    }

    public Player getCurrentPlayer(){
        if(this.currentPlayer==PieceColor.BLACK)
            return game.getBlackPlayer();
        else
            return game.getWhitePlayer();
    }

    public String checkWinningMove(){
        String winnerName = "";
//        this.game.closing.setPlayers(this.game.getBlackPlayer(), this.game.getWhitePlayer());
        this.game.closing.setPlayers(this.game.getOpeningRules().getBlackPlayer(),this.game.getOpeningRules().getWhitePlayer());

        if(this.game.closing.isWinning(this.getCurrentPlayer().getMoves()))
            winnerName=this.getCurrentPlayer().getName();
        return winnerName;
    }

    public boolean checkFullBoard(){
        return this.game.closing.fullBoard(this.game.getGridSize());
    }

    public void placePiece(final int x, final int y) {
        Piece newPiece = new Piece(x,y, getCurrentPlayer().getColor());
        this.insertMove(newPiece);
    }

    public void displacePiece(final int x, final int y) {
        this.changeTurn();
        Piece bannedPiece = new Piece(x,y, PieceColor.EMPTY);
        this.removeMove(bannedPiece);
    }

    private void insertMove(Piece newPiece){
        this.getCurrentPlayer().addMove(newPiece);
    }

    private void removeMove(Piece bannedPiece){
        if(this.getCurrentPlayer().isPlayerMove(bannedPiece)) this.getCurrentPlayer().removeMove(this.getCurrentPlayer().getMoves().size()-1);
    }

    public void changeTurn() {
        if (this.currentPlayer == PieceColor.WHITE)
            this.currentPlayer = PieceColor.BLACK;
        else
            this.currentPlayer = PieceColor.WHITE;
    }

    public boolean isValidMove(final int x, final int y) {
        Piece newPiece = new Piece(x,y, PieceColor.EMPTY);
        return !game.getBlackPlayer().isPlayerMove(newPiece) && !game.getWhitePlayer().isPlayerMove(newPiece);
    }

    public int getNumMovesOpening(){ return this.game.getOpeningRules().getNumMoves();}

    public boolean isOutOfBound(final int x, final int y){
        return ((x < 0 || x > this.game.getGridSize()) || (y < 0 || y > this.game.getGridSize()) );
    }

    public GomokuGame getGame() {
        return this.game;
    }


//    private void printAllMoves(){
//        game.getP1().printMoves();
//        game.getP2().printMoves();
//    }
}
