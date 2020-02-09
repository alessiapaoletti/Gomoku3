package ControllerJF;

import Controller.GameStatusControllerInterface;
import Model.Player.*;
import Model.Piece.*;
import Model.GamePlay;
import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import ViewJF.BoardView;
import ViewJF.ControlSkin;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BoardController extends Control {

    private BoardView boardView;
    private GamePlay gamePlay;
    private GameStatusControllerInterface gameStatusController;
    private TurnManager turnManager;
    private final StackPane mainLayout;
    private AlertController alertController;
    private int cellX = 0;
    private int cellY = 0;

    BoardController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType) {
        GomokuGame gomokuGame = new GomokuFactory().getGame(gomokuType);
        gomokuGame.setPlayers(blackPlayer, whitePlayer);
        this.boardView = new BoardView(gomokuGame.getGridSize());
        this.gamePlay = new GamePlay(gomokuGame, openingType);
         alertController= new AlertController();
        this.setSkin(new ControlSkin(this));
        this.getChildren().add(this.boardView);
        this.mainLayout = new StackPane();
        this.mainLayout.getChildren().add(this);
    }

    public void setGameStatusController(GameStatusControllerInterface g) {
        this.gameStatusController = g;
        this.turnManager = new TurnManager((GameStatusController) this.gameStatusController);
    }

    public BoardView getBoardView(){
        return this.boardView;
    }

    public void clickEventHandler() {
        alertController.callGetAlertOpening(gamePlay.getGame().getOpeningRules().getOpeningType());
        this.setOnMouseClicked((event) -> {
            if(placePiece(event.getX(), event.getY())) {
                TurnManager.getTurnManager(gamePlay.getGame().getOpeningRules().getOpeningType(), numMovesDone());
                startGame(event.getX(), event.getY());
            }
        });
    }

    public int numMovesDone(){
        return this.gamePlay.getGame().getOpeningRules().getBlackPlayer().listSize() + this.gamePlay.getGame().getOpeningRules().getWhitePlayer().listSize();
    }

    public void coordinateSet(final double x, final double y ){
        this.cellX = (int)((x - this.boardView.getGrid().getStartX() + (this.boardView.getGrid().getCellWidth() / 2.0)) / this.boardView.getGrid().getCellWidth());
        this.cellY = (int)((y - this.boardView.getGrid().getStartY() + (this.boardView.getGrid().getCellHeight() / 2.0)) / this.boardView.getGrid().getCellHeight());
    }

    public boolean placePiece(final double x, final double y) {
        this.coordinateSet(x,y);
        if(this.gamePlay.isValidMove(this.cellX,this.cellY) && !this.gamePlay.isOutOfBound(this.cellX, this.cellY) ){
            this.boardView.setPiece(this.cellX, this.cellY, this.gamePlay.getCurrentPlayer().getColor());
            this.gamePlay.placePiece(this.cellX, this.cellY);

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

    public void displacePiece(final double x, final double y) {
        this.coordinateSet(x,y);
        this.gamePlay.displacePiece(this.cellX, this.cellY);
        this.boardView.removePiece(this.cellX, this.cellY);
        this.boardView.setPiece(this.cellX, this.cellY, PieceColor.EMPTY);
    }

    public void startOpening(){
        if (this.numMovesDone() == gamePlay.getNumMovesOpening() || this.numMovesDone() <= 5) {
            this.gamePlay.getGame().getOpeningRules().callOpening(this.alertController,this.gameStatusController);
        }
    }

    public void startGame(final double x, final double y){
        this.startOpening();
        try {
            this.gamePlay.getGame().checkInvalidMoves();
        }
        catch (Error | Exception e){
            alertController.callInvalidMoveError(e.toString().substring(17));
            this.gameStatusController.swapColorTurn();
            this.displacePiece(x,y);
        }
    }

    public void gameOver(String ... winner){
        Stage stage = (Stage) boardView.getScene().getWindow();
        //AlertGameOver alertGameOver = new AlertGameOver();
        //String result =  alertGameOver.gameOverAlert(winner);
        if("OK".equals(alertController.callGameOverAlert(winner)))
            stage.close();
        this.gameStatusController.swapColorTurn();
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("GOMOKU GAME");
        primaryStage.setScene(new Scene(this.mainLayout, 600, 600));
        primaryStage.show();
    }
}

