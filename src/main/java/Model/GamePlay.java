package Model;
import Model.Rules.Closing;
import Model.Rules.ClosingFactory;
import View.Alert;

public class GamePlay {
    private Piece.PieceType currentPlayer;
    private GomokuGame game;
    private Closing closing;

    public GamePlay(GomokuGame game) {
        this.game = game;
        this.game.initGame();
        String gameName = this.game.getGameName();
        this.currentPlayer = Piece.PieceType.BLACK;
        this.closing = ClosingFactory.getClosing(gameName).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        this.closing.setPlayers(this.game.getBlackPlayer(),this.game.getWhitePlayer());
    }

    public Player getCurrentPlayer(){
        if(this.currentPlayer==game.getP1().getColor())
            return game.getP1();
        else
            return game.getP2();
    }

    public String checkWinningMove(){
        String winnerName = "";
        this.closing.setPlayers(this.game.getBlackPlayer(), this.game.getWhitePlayer());
        if(this.closing.isWinning(this.getCurrentPlayer().getMoves()))
            winnerName=this.getCurrentPlayer().getName();
        return winnerName;
    }

    public boolean checkFullBoard(){
        return this.closing.fullBoard(this.game.getGridDim());
    }

    public void placePiece(final int x, final int y) {
        Piece newPiece = new Piece(x,y, getCurrentPlayer().getColor());
        this.insertMove(newPiece);
        this.printAllMoves();
    }

    public void displacePiece(final int x, final int y) {
        this.swapPlayers();
        Piece bannedPiece = new Piece(x,y,Piece.PieceType.EMPTY);
        this.removeMove(bannedPiece);
    }

    public void opening(int c){
        this.game.callOpeningRules(c);
    }

    public void rules(){
        this.game.setInvalidMoves(this.game.getGridDim());
    }

    public int initialMove(){
        Alert.openingRulesAlert(game.getOpeningRulesName());
        return 0;
    }

    private void insertMove(Piece newPiece){
        //newPiece.setPieceType(getCurrentPlayer().getColor());
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

    private void printAllMoves(){
        game.getP1().printMoves();
        game.getP2().printMoves();
    }

    public boolean isValidMove(final int x, final int y) {
        Piece newPiece = new Piece(x,y,Piece.PieceType.EMPTY);
        return !game.getP1().isPlayerMove(newPiece) && !game.getP2().isPlayerMove(newPiece);
    }

    public int getNumMovesOpening(){ return this.game.getNumMovesOpening();}
}
