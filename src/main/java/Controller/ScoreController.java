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
    @FXML private javafx.scene.control.Label s1Board;
    @FXML private javafx.scene.control.Label s2Board;
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

        s1Board.setText(String.valueOf(GomokuGame.getP1().getScore()));
        s2Board.setText(String.valueOf(GomokuGame.getP2().getScore()));

        gameV.setText(String.valueOf(GomokuBoard.getNameg()));
        openV.setText(String.valueOf(GomokuGame.getOp()));
    }

    public void newGame() throws IOException {
        close();
        Main.startLogin(new Stage());
        System.out.println("new game with different players (new board starting from the login window) ");
    }

    public void saveScore() throws FileNotFoundException {
        String filename = "score.txt";
        File f = new File(filename);

        PrintWriter out;
        if ( f.exists() && !f.isDirectory() ) out = new PrintWriter(new FileOutputStream(new File(filename), true));
        else out = new PrintWriter(filename);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        out.append(dtf.format(now) + "\n");
        out.append("Player 1: " + GomokuGame.getP1().getName() + " " + GomokuGame.getP1().getNameColor() + " " + GomokuGame.getP1().getScore() + "\n");
        out.append("Player 2: " + GomokuGame.getP2().getName() + " " + GomokuGame.getP2().getNameColor() + " " + GomokuGame.getP2().getScore() + "\n\n");
        out.close();
    }

    @FXML
    public void close(){
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) BoardController.myBoard.getScene().getWindow();
        stageBoard.close();
    }

}
