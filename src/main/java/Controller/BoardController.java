package Controller;

import Model.GamePlay;
import Model.GomokuGame;
import Model.Piece;
import View.Alert;
import View.BoardView;
import View.ControlSkin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class BoardController extends Control {

    public static BoardView myView;
    private GamePlay myGame;
    public static ScoreController scoreController;
    private int clicksCount = 0; //clicks count added in order to set the opening moves check.
    private final StackPane sp_mainlayout;
    private static String gameName;

    static String getGameName(){
        return gameName;
    }

    BoardController(int gridSize, GomokuGame game) {
        this.myView = new BoardView(gridSize);
        this.myGame = new GamePlay(game, gridSize);
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


    public void placePiece(final double x, final double y) {
        int cellX = (int)((x - this.myView.start_x + (this.myView.cell_width / 2.0)) / this.myView.cell_width);
        int cellY = (int)((y - this.myView.start_y + (this.myView.cell_height / 2.0)) / this.myView.cell_height);
        System.out.println(cellX);
        System.out.println(cellY);

        if(this.myGame.isValidMove(cellX, cellY)){
            this.myView.setPiece(cellX, cellY, this.myGame.getCurrentPlayer());
            this.myGame.placePiece(cellX, cellY);
            if(this.myGame.checkFullBoard())
                this.gameOver();
            if(!this.myGame.checkWinningMove(cellX, cellY).isEmpty() ){
                this.gameOver(this.myGame.checkWinningMove(cellX, cellY));
            }
        }
    }

    private void UnplacePiece(final double x, final double y) {
        int cellX = (int)((x - this.myView.start_x + (this.myView.cell_width / 2.0)) / this.myView.cell_width);
        int cellY = (int)((y - this.myView.start_y + (this.myView.cell_height / 2.0)) / this.myView.cell_height);
        this.myGame.unplacePiece(cellX, cellY);
        this.myView.removePiece(cellX, cellY);
        this.myView.setPiece(cellX, cellY, Piece.PieceType.EMPTY);
    }

    // function that allows the opening functions to work on the board.
    public void startOpening(final double x, final double y, int c){
        this.placePiece(x,y);
        this.myGame.opening(c);
    }


    public void startGame(final double x, final double y){
        this.placePiece(x,y);
        try {
            this.myGame.rules();
        }
        catch (Error e){
            Alert.invalidMoveAlert(e.toString());
            this.UnplacePiece(x,y);   //tolgo  l'ultima pedina inserita
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


    void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("GOMOKU version: "+ gameName);
        primaryStage.setScene(new Scene(this.sp_mainlayout, 600, 600));
        primaryStage.show();

        URL myFxmlURL = ClassLoader.getSystemResource("ScoreView.fxml");

        FXMLLoader loader = new FXMLLoader(myFxmlURL);
        Parent root = loader.load();
        scoreController = loader.getController();

        Scene myScene = new Scene(root);
        Stage myStage = new Stage();
        myStage.setTitle("Score");
        myStage.setX(135);
        myStage.setY(65);
        myStage.setScene(myScene);
        myStage.show();
    }


    /* Resize the width and the height of the window when dragging the mouse  */
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.myView.resize(width, height);

    }
}

