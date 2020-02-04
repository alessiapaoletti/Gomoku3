package main.java.ControllerCL;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;
import main.java.ViewCL.GameStatusView;

public class GameStatusController {

    private static  GameStatusView gameStatusView;
    //private BoardView boardView;

    public GameStatusController(BlackPlayer p1, WhitePlayer p2, GomokuType gomokuType, OpeningType openingType){
       // this.boardView = boardView;
        gameStatusView = new GameStatusView(p1, p2, gomokuType, openingType);
    }

    public void start(){
        gameStatusView.initBackGround();
        /*StackPane stackPane = new StackPane();
        stackPane.getChildren().add(gameStatusView);
        Stage primaryStage = new Stage();
        primaryStage.setX(1080);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(stackPane, 200, 240));
        primaryStage.show();

        this.initClose();
        this.initNewGameButton();*/
    }

   /*  private void initClose(){
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
*/
}
