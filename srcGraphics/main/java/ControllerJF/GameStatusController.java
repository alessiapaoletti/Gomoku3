package ControllerJF;

import Controller.GameStatusControllerInterface;
import Model.GomokuGame.GomokuType;
import Model.BlackPlayer;
import Model.WhitePlayer;
import Model.Rules.Opening.OpeningType;
import ViewJF.BoardView;
import ViewJF.GameStatusView;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameStatusController extends Control implements GameStatusControllerInterface {

    private GameStatusView gameStatusView;
    private BoardView boardView;

    GameStatusController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType, BoardView boardView){
        this.boardView = boardView;
        this.gameStatusView = new GameStatusView(blackPlayer, whitePlayer, gomokuType, openingType);
    }

    void start(){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(this.gameStatusView);
        Stage primaryStage = new Stage();
        primaryStage.setX(1080);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(stackPane, 200, 240));
        primaryStage.show();

        this.initClose();
        this.initNewGameButton();
    }

    private void initClose(){
        this.gameStatusView.getCloseButton().setOnAction(actionEvent -> this.closeScoreView());
    }

    private void initNewGameButton(){
        this.gameStatusView.getNewGameButton().setOnAction(actionEvent ->  {
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
        Stage stage = (Stage) this.gameStatusView.getCloseButton().getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) this.boardView.getScene().getWindow();
        stageBoard.close();
    }

    public  void swapLabel(){
        this.gameStatusView.swapColors();
    }

    public static void swapColorTurn(){ //this.gameStatusView.fillColorPlayer();
    }

}
