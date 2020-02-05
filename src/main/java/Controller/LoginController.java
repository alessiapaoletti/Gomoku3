package Controller;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.WhitePlayer;
import View.Alert.*;
import Model.Rules.Opening.OpeningType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.lang.reflect.InvocationTargetException;

public class LoginController {

    private ObservableList<GomokuType> gomokuTypes = FXCollections.observableArrayList(GomokuType.Standard,GomokuType.Omok, GomokuType.Freestyle);
    private ObservableList<OpeningType> openingTypes = FXCollections.observableArrayList(OpeningType.Standard,OpeningType.Swap,OpeningType.Swap2);

    @FXML private javafx.scene.control.Button exitButton;
    @FXML private javafx.scene.control.TextField playerBlack;
    @FXML private javafx.scene.control.TextField playerWhite;
    @FXML private ChoiceBox choiceGomokuType;
    @FXML private ChoiceBox choiceOpening;

    public LoginController() {}

    @FXML private void initialize(){
        choiceGomokuType.setItems(gomokuTypes);
        choiceOpening.setItems(openingTypes);
    }

    @FXML
    public void startGame() throws InvocationTargetException, IllegalAccessException{

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
            boardController.setGameStatusController(gameStatusController);
            gameStatusController.start();
        } else {
            AlertLogin alertLogin = new AlertLogin();
            alertLogin.loginAlert();
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

}
