package Controller;


import Model.Board;
import Model.GomokuBoard;
import Model.GomokuGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class ScoreController implements Initializable {

    private final AnchorPane rootPane ;
    @FXML private javafx.scene.control.Label p1Board;
    @FXML private javafx.scene.control.Label p2Board;
    @FXML private javafx.scene.control.Label c1Board;
    @FXML private javafx.scene.control.Label c2Board;
    @FXML private javafx.scene.control.Label s1Board;
    @FXML private javafx.scene.control.Label s2Board;
    @FXML private javafx.scene.control.Label gameV;
    @FXML private javafx.scene.control.Label openV;
    @FXML private javafx.scene.control.Button exitB;
    @FXML private javafx.scene.control.Button undomoveB;

    public ScoreController() {

        rootPane = new AnchorPane();


    }

    public AnchorPane getRootPane() {
        return rootPane ;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1Board.setText(GomokuGame.getP1().getName());
        p2Board.setText(GomokuGame.getP2().getName());

        c1Board.setText(GomokuGame.getP1().getNameColor());
        c2Board.setText(GomokuGame.getP2().getNameColor());

        s1Board.setText(String.valueOf(GomokuGame.getP1().getScore()));
        s2Board.setText(String.valueOf(GomokuGame.getP2().getScore()));

        gameV.setText(String.valueOf(GomokuBoard.getNameg()));
        //openV.setText(String.valueOf(GomokuGame.getOp()));
    }

    @FXML
    public void undomove(){
        /* to do*/
        System.out.println("undo last moves");
    }

    public void resetGame() {
        /* to do */
        System.out.println("reset the game (same board)");
    }

    public void newGame(){
        /* to do */
        System.out.println("new game with different players (new board starting from the login window) ");
    }

    public void saveScore() throws FileNotFoundException {
        String filename = "score.txt";
        File f = new File(filename);

        PrintWriter out = null;
        if ( f.exists() && !f.isDirectory() ) {
            out = new PrintWriter(new FileOutputStream(new File(filename), true));
        }
        else {
            out = new PrintWriter(filename);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        out.append(dtf.format(now) + "\n");
        out.append("Player 1: " + GomokuGame.getP1().getName() + " " + GomokuGame.getP1().getNameColor() + " " + String.valueOf(GomokuGame.getP1().getScore()) + "\n");
        out.append("Player 2: " + GomokuGame.getP2().getName() + " " + GomokuGame.getP2().getNameColor() + " " + String.valueOf(GomokuGame.getP2().getScore()) + "\n\n");


        out.close();
    }

    public void exit(){
        System.out.println("Close all ");
    }

    @FXML
    public void close(){
        Stage stage = (Stage) exitB.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
