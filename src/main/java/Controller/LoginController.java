package Controller;
import Model.*;

import View.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginController {

    private GomokuGame targetGomoku;


    private ObservableList<String> methods= FXCollections.observableArrayList("Standard","Omok", "Freestyle");
    private ObservableList<String> openings= FXCollections.observableArrayList("Standard","Swap","Swap2");

    @FXML private javafx.scene.control.Button eBottim;
    @FXML private javafx.scene.control.TextField player1;
    @FXML private javafx.scene.control.TextField player2;
    @FXML private ChoiceBox choice;
    @FXML private ChoiceBox choiceOpening;

    public LoginController() {}

    @FXML private void initialize(){
        choice.setItems(methods);
        choiceOpening.setItems(openings);
    }

    @FXML
    public void startGame() throws IOException {

        System.out.println("start game!");

        if (!(player1.getText().equals("")) && !(player2.getText().equals(""))) {

            Player p1 = new Player(player1.getText(),"Black");
            Player p2 = new Player(player2.getText(), "White");

            startGameUsingFactory(p1, p2, choice.getSelectionModel().getSelectedItem().toString(), choiceOpening.getSelectionModel().getSelectedItem().toString());
            Stage stage = (Stage) eBottim.getScene().getWindow();
            stage.close();

            Stage mainStage = new Stage(StageStyle.DECORATED);
            BoardController myBoard = new BoardController( targetGomoku);
            myBoard.initBoardController();
            myBoard.start(mainStage);

            ScoreController scoreController = new ScoreController().start();
            scoreController.setView(myBoard.getMyView());


        } else {
            Alert.loginAlert();
        }
}


    @FXML
    public void close(){
        Stage stage = (Stage) eBottim.getScene().getWindow();
        stage.close();
    }

    private void startGameUsingFactory(Player p1, Player p2, String game,String m){
        this.targetGomoku = GomokuFactory.getGame(game).orElseThrow(() -> new IllegalArgumentException("Invalid operator"));
        this.targetGomoku.setPlayers(p1, p2);

        int gridSize = 14; //default size
        if (game.equals("Omok")) gridSize = 18; //different size for the Omok version
        this.targetGomoku.setGridSize(gridSize);

        this.targetGomoku.setOpeningRulesName(m);
    }

}
