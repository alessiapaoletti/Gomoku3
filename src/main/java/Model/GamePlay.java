package Model;

import Model.GomokuGame.GomokuGame;
import Model.Rules.Opening.OpeningType;

public class GamePlay {
    private Piece.PieceType currentPlayer;
    private GomokuGame game;

    public GamePlay(GomokuGame game, OpeningType openingType) {
        this.game = game;
        this.game.setGameEnvironment(openingType);
        this.currentPlayer = Piece.PieceType.BLACK;
    }

    public Player getCurrentPlayer(){
        if(this.currentPlayer==game.getP1().getColor())
            return game.getP1();
        else
            return game.getP2();
    }

    public String checkWinningMove(){
        String winnerName = "";
        this.game.closing.setPlayers(this.game.getBlackPlayer(), this.game.getWhitePlayer());
        if(this.game.closing.isWinning(this.getCurrentPlayer().getMoves()))
            winnerName=this.getCurrentPlayer().getName();
        return winnerName;
    }

    public boolean checkFullBoard(){
        return this.game.closing.fullBoard(this.game.getGridDim());
    }

    public void placePiece(final int x, final int y) {
        Piece newPiece = new Piece(x,y, getCurrentPlayer().getColor());
        this.insertMove(newPiece);
    }

    public void displacePiece(final int x, final int y) {
        this.swapPlayers();
        Piece bannedPiece = new Piece(x,y,Piece.PieceType.EMPTY);
        this.removeMove(bannedPiece);
    }

    private void insertMove(Piece newPiece){
        this.getCurrentPlayer().addMove(newPiece);
    }

    private void removeMove(Piece bannedPiece){
        if(this.getCurrentPlayer().isPlayerMove(bannedPiece)) this.getCurrentPlayer().removeMove(this.getCurrentPlayer().getMoves().size()-1);
    }

    public void swapPlayers() {
        if (this.currentPlayer == Piece.PieceType.WHITE)
            this.currentPlayer = Piece.PieceType.BLACK;
        else
            this.currentPlayer = Piece.PieceType.WHITE;
    }

    public boolean isValidMove(final int x, final int y) {
        Piece newPiece = new Piece(x,y,Piece.PieceType.EMPTY);
        return !game.getP1().isPlayerMove(newPiece) && !game.getP2().isPlayerMove(newPiece);
    }

    public int getNumMovesOpening(){ return this.game.openingRules.getNumMoves();}

    public boolean isOutOfBound(final int x, final int y){
        return ((x < 0 || x > this.game.getGridDim()) || (y < 0 || y > this.game.getGridDim()) );
    }

    public GomokuGame getGame() {
        return this.game;
    }


//    private void printAllMoves(){
//        game.getP1().printMoves();
//        game.getP2().printMoves();
//    }
}
