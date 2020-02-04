package ControllerCL;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.WhitePlayer;
import View.Alert.*;
import ViewCL.LoginView;
import Model.Rules.Opening.OpeningType;
import ControllerCL.BoardController;
import main.java.ControllerCL.GameStatusController;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private LoginView myview=new LoginView();

    public LoginController() {}

    public void startGame(){
        BlackPlayer blackPlayer = new BlackPlayer(myview.SetBlackPlayer());
        WhitePlayer whitePlayer = new WhitePlayer(myview.SetWhitePlayer());
        GomokuType gomokuType= myview.SetGame();
        OpeningType openingType = myview.SetOpening();
        BoardController boardController = new BoardController(blackPlayer,whitePlayer,gomokuType, openingType);
        //GameStatusController gameStatusController = new GameStatusController(blackPlayer, whitePlayer,gomokuType, openingType);
        boardController.StartGame();
    };
  /*  public void startGame() throws InvocationTargetException, IllegalAccessException{

        if (checkPlayersName() && checkGameSetUp()) {

            BlackPlayer blackPlayer = new BlackPlayer(playerBlack.getText());
            WhitePlayer whitePlayer = new WhitePlayer(playerWhite.getText());
            GomokuType gomokuType = (GomokuType) choiceGomokuType.getSelectionModel().getSelectedItem();
            OpeningType openingType = (OpeningType) choiceOpening.getSelectionModel().getSelectedItem();

            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();

            Stage mainStage = new Stage(StageStyle.DECORATED);
            mainStage.setResizable(false);
            BoardController boardController = new BoardController(blackPlayer,whitePlayer,gomokuType, openingType);
            boardController.clickEventHandler();
            boardController.start(mainStage);

            GameStatusController gameStatusController = new GameStatusController(blackPlayer, whitePlayer,gomokuType, openingType, boardController.getBoardView());
            gameStatusController.start();
        } else{
            AlertLogin alertlog=new AlertLogin();
            alertlog.loginAlert();
        }
    }

    private boolean checkPlayersName(){
        return !(playerBlack.getText().equals("")) && !(playerWhite.getText().equals(""));
    }

    private boolean checkGameSetUp(){
        return !(choiceGomokuType.getSelectionModel().isEmpty())  && !(choiceOpening.getSelectionModel().isEmpty());
    }

    @FXML
    public void close(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
*/
}
