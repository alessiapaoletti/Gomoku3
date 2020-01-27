package Controller;


import Model.GomokuGame;
import View.BoardView;
import View.ScoreView;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScoreController extends Control {

    private static ScoreView scoreView;
    private GomokuGame game;
    private BoardView myView;


    public ScoreController(GomokuGame game, BoardView myView){
        this.game = game;
        this.myView = myView;
        this.scoreView = new ScoreView(game.getP1(), game.getP2(), game.getGameName(), game.getOpeningRulesName());
    }


    void start(){

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(this.scoreView);
        Stage primaryStage = new Stage();
        primaryStage.setX(1080);
        primaryStage.setTitle("Score ");
        primaryStage.setScene(new Scene(stackPane, 190, 220));
        primaryStage.show();

        this.initClose();
        this.initNewGameButton();
    }

    private void initClose(){

        this.scoreView.getCloseButton().setOnAction(actionEvent ->  {

            this.closeScoreView();
        });
    }

    private void initNewGameButton(){
        this.scoreView.getNewGameButton().setOnAction(actionEvent ->  {
            this.closeScoreView();
            try {
                Main.startLogin(new Stage());
            }
            catch (java.io.IOException e){

            }
        });
    }

    private void closeScoreView(){
        Stage stage = (Stage) this.scoreView.getCloseButton().getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) this.myView.getScene().getWindow();
        stageBoard.close();
    }

    public static void swapLabels(){
        scoreView.swapColors();
    }

}
