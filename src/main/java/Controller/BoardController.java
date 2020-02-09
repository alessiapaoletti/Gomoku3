package Controller;

import Model.GamePlay;
import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import Model.GomokuGame.GomokuType;
import Model.Player.*;
import Model.Rules.Opening.OpeningType;
import View.BoardView;

public class BoardController {

    public BoardView boardView;
    public GamePlay gamePlay;
    public GameStatusController gameStatusController;
    public TurnManager turnManager;
    public AlertController alertController = new AlertController();
    private boolean gameOver = false;
    private int X = 0;
    private int Y = 0;

    public BoardController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType) {
        GomokuGame gomokuGame = new GomokuFactory().getGame(gomokuType);
        gomokuGame.setPlayers(blackPlayer, whitePlayer);
        this.boardView = new BoardView(gomokuGame.getGridSize(),gomokuType.toString().toUpperCase());
        this.gamePlay = new GamePlay(gomokuGame, openingType);
        this.gameStatusController = new GameStatusController(blackPlayer, whitePlayer,gomokuType, openingType);
        this.gamePlay.getGame().getOpeningRules().setGameStatusControllerInterface(gameStatusController);
        this.turnManager = new TurnManager(this.gameStatusController);
    }

    public void callGame(){
        this.alertController.callGetAlertOpening(gamePlay.getGame().getOpeningRules().getOpeningType());
        this.boardView.createBoard();
        this.gameStatusController.start();
        this.carryOnGame();
    }

    public void carryOnGame(){
        while (!gameOver) {
            this.gameStatusController.maintainTurn();
            if(placePiece()) {
                startGame();
                turnManager.getTurnManager(gamePlay.getGame().getOpeningRules().getOpeningType(), numMovesDone());
            }
            this.boardView.createBoard();
            this.gameStatusController.start();
        }
    }

    public int numMovesDone(){
        return this.gamePlay.getGame().getOpeningRules().getBlackPlayer().listSize() + this.gamePlay.getGame().getOpeningRules().getWhitePlayer().listSize();
    }

    public void coordinateSet(){
        this.X=this.boardView.getX(this.gamePlay.getCurrentPlayer().getColorName());
        this.Y=this.boardView.getY(this.gamePlay.getCurrentPlayer().getColorName());
    }

    public boolean placePiece() {
        this.coordinateSet();
        if(this.gamePlay.isValidMove(this.X,this.Y) && !this.gamePlay.isOutOfBound(this.X, this.Y) ){
            this.boardView.setPiece(this.X, this.Y, this.gamePlay.getCurrentPlayer().getColor());
            this.gamePlay.placePiece(this.X, this.Y);

            if(this.gamePlay.checkFullBoard())
                this.gameOver();
            if(!this.gamePlay.checkWinningMove().isEmpty() ){
                this.gameOver(this.gamePlay.checkWinningMove());
            }
            this.gamePlay.changeTurn();
            return true;
        }
        return false;
    }

    public void displacePiece() {
        this.gamePlay.displacePiece(this.X, this.Y);
        this.boardView.removePiece(this.X, this.Y);
    }

    public void startOpening(){
        if (this.numMovesDone() == gamePlay.getNumMovesOpening() || this.numMovesDone() <= 5) {
            this.gamePlay.getGame().getOpeningRules().callOpening(this.alertController,this.gameStatusController);
        }
    }

    public void startGame(){
        this.startOpening();
        try {
            this.gamePlay.getGame().checkInvalidMoves();
        }
        catch (Error | Exception e){
           this.alertController.callInvalidMoveError();
            this.gameStatusController.swapColorTurn();
            this.displacePiece();
        }
    }

    public void gameOver(String ... winner){
        this.alertController.callGameOverAlert(winner);
        this.gameOver = true;
    }


}

