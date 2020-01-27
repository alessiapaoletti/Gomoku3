package Controller;
import Model.*;

import Model.GomokuGame.GomokuFactory;
import Model.GomokuGame.GomokuGame;
import View.Alert;
import javafx.collections.FXCollections;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



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
    public void startGame() {

        if (!(player1.getText().equals("")) && !(player2.getText().equals(""))) {

            Player p1 = new Player(player1.getText(), Piece.PieceType.BLACK);
            Player p2 = new Player(player2.getText(), Piece.PieceType.WHITE);

            startGameUsingFactory(p1, p2, choice.getSelectionModel().getSelectedItem().toString(), choiceOpening.getSelectionModel().getSelectedItem().toString());
            Stage stage = (Stage) eBottim.getScene().getWindow();
            stage.close();

            Stage mainStage = new Stage(StageStyle.DECORATED);
            mainStage.setResizable(false);
            BoardController boardController = new BoardController(targetGomoku);
            boardController.initBoardController();
            boardController.start(mainStage);

            ScoreController scoreController = new ScoreController(this.targetGomoku, boardController.getMyView());
            scoreController.start();


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

        int gridSize = 14;
        if (game.equals("Omok")) gridSize = 18;
        this.targetGomoku.setGridSize(gridSize);

        this.targetGomoku.setOpeningRulesName(m);
    }

}
