package Controller;


import Model.GomokuBoard;
import Model.GomokuGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class ScoreController implements Initializable {

    @FXML private javafx.scene.control.Label p1Board;
    @FXML private javafx.scene.control.Label p2Board;
    @FXML private javafx.scene.control.Label c1Board;
    @FXML private javafx.scene.control.Label c2Board;
    @FXML private javafx.scene.control.Label gameV;
    @FXML private javafx.scene.control.Label openV;
    @FXML private javafx.scene.control.Button exitB;

    public ScoreController() { }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1Board.setText(GomokuGame.getP1().getName());
        p2Board.setText(GomokuGame.getP2().getName());

        c1Board.setText(GomokuGame.getP1().getNameColor());
        c2Board.setText(GomokuGame.getP2().getNameColor());

        gameV.setText(String.valueOf(GomokuBoard.getNameg()));
        openV.setText(String.valueOf(GomokuGame.getOp()));
    }

    public void newGame() throws IOException {
        close();
        Main.startLogin(new Stage());
        System.out.println("new game with different players (new board starting from the login window) ");
    }

    @FXML
    public void close(){
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) BoardController.myBoard.getScene().getWindow();
        stageBoard.close();
    }

}
