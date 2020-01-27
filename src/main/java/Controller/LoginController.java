package Controller;

import Model.GomokuGame.GomokuType;
import Model.Piece;
import Model.Player;
import Model.Rules.Opening.OpeningType;
import View.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    private ObservableList<GomokuType> gomokuTypes = FXCollections.observableArrayList(GomokuType.Standard,GomokuType.Omok, GomokuType.Freestyle);
    private ObservableList<OpeningType> openingTypes = FXCollections.observableArrayList(OpeningType.Standard,OpeningType.Swap,OpeningType.Swap2);

    @FXML private javafx.scene.control.Button exitButton;
    @FXML private javafx.scene.control.TextField player1;
    @FXML private javafx.scene.control.TextField player2;
    @FXML private ChoiceBox choiceGomokuType;
    @FXML private ChoiceBox choiceOpening;

    public LoginController() {}

    @FXML private void initialize(){
        choiceGomokuType.setItems(gomokuTypes);
        choiceOpening.setItems(openingTypes);
    }

    @FXML
    public void startGame() {

        if (checkPlayersName() && checkGameSetUp()) {

            Player p1 = new Player(player1.getText(), Piece.PieceType.BLACK);
            Player p2 = new Player(player2.getText(), Piece.PieceType.WHITE);
            GomokuType gomokuType = (GomokuType) choiceGomokuType.getSelectionModel().getSelectedItem();
            OpeningType openingType = (OpeningType) choiceOpening.getSelectionModel().getSelectedItem();

            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();

            Stage mainStage = new Stage(StageStyle.DECORATED);
            mainStage.setResizable(false);
            BoardController boardController = new BoardController(p1,p2,gomokuType, openingType);
            boardController.clickOpeningCounter(); /*questa funzione va qui ? */
            boardController.start(mainStage);

            ScoreController scoreController = new ScoreController(p1, p2,gomokuType, openingType, boardController.getMyView());
            scoreController.start();
        } else
            Alert.loginAlert();
    }

    private boolean checkPlayersName(){
        return !(player1.getText().equals("")) && !(player2.getText().equals(""));
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
