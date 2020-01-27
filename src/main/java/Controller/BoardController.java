package Controller;

import Model.GamePlay;
import Model.GomokuGame.GomokuGame;
import Model.Piece;
import View.Alert;
import View.BoardView;
import View.ControlSkin;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BoardController extends Control {

    private BoardView myView;
    private GamePlay myGame;
    private int clicksCount = 0;
    private final StackPane sp_mainlayout;
    private static String gameName;


    BoardView getMyView(){
        return myView;
    }

     BoardController(GomokuGame game) {
        this.myView = new BoardView(game.getGridDim());
        this.myGame = new GamePlay(game);
        this.setSkin(new ControlSkin(this));
        this.getChildren().add(this.myView);

        this.sp_mainlayout = new StackPane();
        this.sp_mainlayout.getChildren().add(this);
        gameName = game.getGameName();
    }


    void initBoardController(){
        clicksCount =this.myGame.initialMove();
        this.setOnMouseClicked((event) -> {
            clicksCount++;

            if(clicksCount == myGame.getNumMovesOpening() || clicksCount == this.myGame.getNumMovesOpening() +2) {
                startOpening(event.getX(), event.getY(), clicksCount);
            }

            startGame(event.getX(), event.getY());
        });
    }


    private void placePiece(final double x, final double y) {
        int cellX = (int)((x - this.myView.start_x + (this.myView.cell_width / 2.0)) / this.myView.cell_width);
        int cellY = (int)((y - this.myView.start_y + (this.myView.cell_height / 2.0)) / this.myView.cell_height);

        if(this.myGame.isValidMove(cellX, cellY) && !this.myGame.isOutOfBound(cellX, cellY) ){
            this.myView.setPiece(cellX, cellY, this.myGame.getCurrentPlayer().getColor());
            this.myGame.placePiece(cellX, cellY);

            if(this.myGame.checkFullBoard())
                this.gameOver();
            if(!this.myGame.checkWinningMove().isEmpty() ){
                this.gameOver(this.myGame.checkWinningMove());
            }

            this.myGame.swapPlayers();

        }
    }

    private void displacePiece(final double x, final double y) {
        int cellX = (int)((x - this.myView.start_x + (this.myView.cell_width / 2.0)) / this.myView.cell_width);
        int cellY = (int)((y - this.myView.start_y + (this.myView.cell_height / 2.0)) / this.myView.cell_height);
        this.myGame.displacePiece(cellX, cellY);
        this.myView.removePiece(cellX, cellY);
        this.myView.setPiece(cellX, cellY, Piece.PieceType.EMPTY);
    }

    private void startOpening(final double x, final double y, int c){
        this.placePiece(x,y);
        this.myGame.opening(c);
    }


    private void startGame(final double x, final double y){
        this.placePiece(x,y);
        try {
            this.myGame.rules();
        }
        catch (Error e){
            Alert.invalidMoveAlert(e.toString());
            this.displacePiece(x,y);
        }
    }


    private void gameOver(String winner){
        Stage stage = (Stage) myView.getScene().getWindow();
        String result = View.Alert.gameOverAlert(winner);
        if("OK".equals(result))
            stage.close();
    }

    private void gameOver(){
        Stage stage = (Stage) myView.getScene().getWindow();
        String result = View.Alert.gameOverAlert();
        if("OK".equals(result))
            stage.close();
    }


    void start(Stage primaryStage) {
        primaryStage.setTitle("GOMOKU version: "+ gameName);
        primaryStage.setScene(new Scene(this.sp_mainlayout, 600, 600));
        primaryStage.show();

    }

}

