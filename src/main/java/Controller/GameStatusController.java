package Controller;

import Model.GomokuGame.GomokuType;
import Model.Player;
import Model.Rules.Opening.OpeningType;
import View.BoardView;
import View.GameStatusView;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameStatusController extends Control {

    private static GameStatusView gameStatusView;
    private BoardView boardView;

    GameStatusController(Player p1, Player p2, GomokuType gomokuType, OpeningType openingType, BoardView boardView){
        this.boardView = boardView;
        gameStatusView = new GameStatusView(p1, p2, gomokuType, openingType);
    }

    void start(){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(gameStatusView);
        Stage primaryStage = new Stage();
        primaryStage.setX(1080);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(stackPane, 200, 240));
        primaryStage.show();

        this.initClose();
        this.initNewGameButton();
    }

    private void initClose(){
        gameStatusView.getCloseButton().setOnAction(actionEvent -> this.closeScoreView());
    }

    private void initNewGameButton(){
        gameStatusView.getNewGameButton().setOnAction(actionEvent ->  {
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
        Stage stage = (Stage) gameStatusView.getCloseButton().getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) this.boardView.getScene().getWindow();
        stageBoard.close();
    }

    public static void swapLabels(){
        gameStatusView.swapColors();
    }

}
