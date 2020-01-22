package Model;
import View.Alert;

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
        this.OpeningName= GomokuGame.getOpeningRulesName();
        this.currentPlayer = Piece.PieceType.BLACK;
        this.closing = new Closing(this.myBoard, gameName);
    }

    public String checkWinningMove(final int x, final int y){

        String winner_name = "";
        if(this.closing.checkWinner(x,y)){

            if(this.currentPlayer == GomokuGame.getP1().getColor()){
                winner_name  = GomokuGame.getP2().getName();
            }
            else winner_name  = GomokuGame.getP1().getName();
        }
        return winner_name;
    }

    public boolean checkFullBoard(){
        return this.closing.fullBoard();
           // BoardController.gameOver();
    }


    public void placePiece(final int x, final int y) {
        Piece newPiece = new Piece(x,y);
        this.insertMove(newPiece);
        this.myBoard.setPiece(x, y,this.currentPlayer);
        //this.checkWinningMove(x,y);
        //this.checkFullBoard();
        this.swapPlayers(); //cambia il colore
        this.printAllPositions();

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
        this.game.setInvalidMoves();
    }

    public int initialMove(){
        Alert.openingRulesAlert(GomokuGame.getOpeningRulesName());
        return 0;
    }

    private void insertMove(Piece newPiece){
        if(this.currentPlayer == GomokuGame.getP1().getColor()) {
            GomokuGame.getP1().addPosition(newPiece);
            newPiece.setPieceType(GomokuGame.getP1().getColor());
        }
        else {
            GomokuGame.getP2().addPosition(newPiece);
            newPiece.setPieceType(GomokuGame.getP2().getColor());
        }
    }

    private void removeMove(Piece bannedPiece){
        Piece.PieceType colorFirstPlayer = GomokuGame.getP1().getColor();

        if(this.currentPlayer == colorFirstPlayer)
            if(GomokuGame.getP1().isPlayerMove(bannedPiece)) GomokuGame.getP1().removePosition(GomokuGame.getP1().getPositions().size()-1);
        else
            if(GomokuGame.getP2().isPlayerMove(bannedPiece)) GomokuGame.getP2().removePosition(GomokuGame.getP2().getPositions().size()-1);
        myBoard.setPiece(bannedPiece.getX(),bannedPiece.getY(),Piece.PieceType.EMPTY);  //place empty on the board
    }

    // private method for swapping the players
    private void swapPlayers() {
        if (this.currentPlayer == Piece.PieceType.WHITE) {
            this.currentPlayer = Piece.PieceType.BLACK;
        }
        else
            this.currentPlayer = Piece.PieceType.WHITE;
    }

    private void printAllPositions(){
        GomokuGame.getP1().printPositions();
        GomokuGame.getP2().printPositions();
    }

    public boolean isValidMove(final int x, final int y) {
        return this.myBoard.getPiece(x, y) == Piece.PieceType.EMPTY;
    }

    public int getNumMovesOpening(){ return this.game.getNumMovesOpening();}

    public Piece.PieceType getCurrentPlayer(){
        return currentPlayer;
    }

}
