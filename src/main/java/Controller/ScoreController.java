package Controller;

import Model.GamePlay;
import Model.GomokuGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ScoreController implements Initializable {

    @FXML private javafx.scene.control.Label p1Board;
    @FXML private javafx.scene.control.Label p2Board;
    @FXML private javafx.scene.control.Label c1Board;
    @FXML private javafx.scene.control.Label c2Board;
    @FXML private javafx.scene.control.Label gameV;
    @FXML private javafx.scene.control.Label openV;
    @FXML private javafx.scene.control.Button exitB;

    GamePlay gamePlay;

    public ScoreController() {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1Board.setText(GomokuGame.getP1().getName());
        p2Board.setText(GomokuGame.getP2().getName());

        c1Board.setText(GomokuGame.getP1().getNameColor());
        c2Board.setText(GomokuGame.getP2().getNameColor());

        gameV.setText(gamePlay.game.gameName);
        openV.setText(String.valueOf(GomokuGame.getOpeningRulesName()));
    }

    public void newGame() throws IOException {
        close();
        Main.startLogin(new Stage());
        //GomokuGame.currentPlayer = BoardLogic.BLACK_PLAYER;
        System.out.println("new game with different players (new board starting from the login window) ");
    }

    @FXML
    public void close(){
        Stage stage = (Stage) exitB.getScene().getWindow();
        stage.close();

        Stage stageBoard = (Stage) BoardController.boardView.getScene().getWindow();
        stageBoard.close();
    }


    public void swapLabels(){
        System.out.println("Swapping");
        c1Board.setText("White");
        c2Board.setText("Black");
    }

    public ScoreController start() throws IOException {
        URL myFxmlURL = ClassLoader.getSystemResource("ScoreView.fxml");;
        FXMLLoader loader = new FXMLLoader(myFxmlURL);
        Parent anotherRoot = loader.load();

        Scene anotherScene = new Scene(anotherRoot);
        Stage anotherStage = new Stage();
        anotherStage.setTitle("Score");
        anotherStage.setX(135);
        anotherStage.setY(65);
        anotherStage.setScene(anotherScene);
        anotherStage.show();
        return loader.getController();
    }

}
