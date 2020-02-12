package Controller;

import Model.GamePlay;
import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import Model.GomokuGame.GomokuType;
import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import View.BoardView;

class BoardController {

    BoardView boardView;
    private GamePlay gamePlay;
    GameStatusController gameStatusController;
    private TurnManager turnManager;
    private AlertController alertController = new AlertController();
    private boolean gameOver = false;
    private  int X = 0;
    private int Y = 0;

    BoardController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType) {
        GomokuGame gomokuGame = new GomokuFactory().getGame(gomokuType);
        gomokuGame.setPlayers(blackPlayer, whitePlayer);
        this.boardView = new BoardView(gomokuGame.getGridSize(), gomokuType.name());
        this.gamePlay = new GamePlay(gomokuGame, openingType);
        this.gameStatusController = new GameStatusController(blackPlayer, whitePlayer, gomokuType, openingType);
        this.gamePlay.getGame().getOpeningRules().setGameStatusControllerInterface(gameStatusController);
        this.turnManager = new TurnManager(this.gameStatusController);
    }

    void callGame(){
        this.alertController.callGetAlertOpening(gamePlay.getGame().getOpeningRules().getOpeningType());
        this.boardView.createBoard();
        this.gameStatusController.start();
        this.carryOnGame();
    }

    private void carryOnGame(){
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

    int numMovesDone(){
        return this.gamePlay.getGame().getOpeningRules().getBlackPlayer().listSize()
                + this.gamePlay.getGame().getOpeningRules().getWhitePlayer().listSize();
    }

    private void coordinateSet(){
        this.X = this.boardView.getX(this.gamePlay.getCurrentPlayer().getColorName());
        this.Y = this.boardView.getY(this.gamePlay.getCurrentPlayer().getColorName());
    }

    private boolean placePiece() {
        this.coordinateSet();
        if(this.gamePlay.isValidMove(this.X,this.Y) && !this.gamePlay.isOutOfBound(this.X, this.Y) ){
            this.boardView.setPiece(this.X, this.Y, this.gamePlay.getCurrentPlayer().getColor());
            this.gamePlay.placePiece(this.X, this.Y);


            if(!this.gamePlay.checkWinningMove().isEmpty() ){
                this.gameOver(this.gamePlay.checkWinningMove());
            }else {
                if (this.gamePlay.checkFullBoard()) {
                    this.gameOver();
                }
            }
            this.gamePlay.changeTurn();
            return true;
        } else {
            this.alertController.callInvalidCoordinateError(Integer.toString(this.gamePlay.getGame().getGridSize()));
            return false;

        }
    }

    private void displacePiece() {
        this.gamePlay.displacePiece(this.X, this.Y);
        this.boardView.removePiece(this.X, this.Y);
    }

    void startOpening(){
        if (this.numMovesDone() == gamePlay.getNumMovesOpening() || this.numMovesDone() <= 5) {
            this.printBoardOpening();
            this.gamePlay.getGame().getOpeningRules().callOpening(this.alertController, this.gameStatusController);
        }
    }

    private void printBoardOpening(){
        if((this.gamePlay.getGame().getOpeningRules().getNumUserInteraction()==1 &&
                this.numMovesDone() == gamePlay.getNumMovesOpening()) ||
                (this.gamePlay.getGame().getOpeningRules().getNumUserInteraction()==2 && this.numMovesDone() == 5)){
            this.boardView.createBoard();
            System.out.println("\n");
        }
    }

    private void startGame(){
        this.startOpening();
        try {
            this.gamePlay.getGame().checkInvalidMoves();
        } catch (Error | Exception e) {
           this.alertController.callInvalidMoveError();
            this.gameStatusController.swapColorTurn();
            this.displacePiece();
        }
    }

    void gameOver(String ... winner){
        this.alertController.callGameOverAlert(winner);
        this.gameOver = true;
    }
}

