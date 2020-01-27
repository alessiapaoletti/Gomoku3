package Controller;
import Model.GomokuGame.GomokuType;
import Model.Player;
import Model.Rules.Opening.OpeningType;
import View.BoardView;
import View.ScoreView;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScoreController extends Control {

    private static ScoreView scoreView;
    private BoardView myView;

    ScoreController(Player p1, Player p2, GomokuType gomokuType, OpeningType openingType, BoardView myView){
        this.myView = myView;
        scoreView = new ScoreView(p1, p2, gomokuType, openingType);
    }

    void start(){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(scoreView);
        Stage primaryStage = new Stage();
        primaryStage.setX(1080);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(stackPane, 200, 240));
        primaryStage.show();

        this.initClose();
        this.initNewGameButton();
    }

    private void initClose(){
        scoreView.getCloseButton().setOnAction(actionEvent -> this.closeScoreView());
    }

    private void initNewGameButton(){
        scoreView.getNewGameButton().setOnAction(actionEvent ->  {
            this.closeScoreView();
            try {
                Main.startLogin(new Stage());
            }
            catch (java.io.IOException e){
                e.printStackTrace();
            }
        });
    }

    private void closeScoreView(){
        Stage stage = (Stage) scoreView.getCloseButton().getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) this.myView.getScene().getWindow();
        stageBoard.close();
    }

    public static void swapLabels(){
        scoreView.swapColors();
    }

}
