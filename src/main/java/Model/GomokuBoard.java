package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import Controller.BoardController;

import java.io.IOException;
import java.net.URL;

public class GomokuBoard {

    private final StackPane sp_mainlayout;
    static private final int gridSize  = GomokuGame.getGridDim();
    static private  String nameg;

    public GomokuBoard(Stage mainStage,GomokuGame n) throws IOException {
        BoardController controller = new BoardController(gridSize, n);
        this.sp_mainlayout = new StackPane();
        this.sp_mainlayout.getChildren().add(controller);
        nameg=n.GetName();
        this.start(mainStage);
    }

    private void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("GOMOKU version: "+nameg);
        primaryStage.setScene(new Scene(this.sp_mainlayout, Board.APPLICATION_WIDTH, Board.APPLICATION_HEIGHT));
        primaryStage.show();

        URL myFxmlURL = ClassLoader.getSystemResource("ScoreView.fxml");
        Parent anotherRoot = FXMLLoader.load(myFxmlURL);
        Scene anotherScene = new Scene(anotherRoot);
        Stage anotherStage = new Stage();
        anotherStage.setTitle("Score");
        anotherStage.setX(135);
        anotherStage.setY(65);
        anotherStage.setScene(anotherScene);
        anotherStage.show();
    }

    public static String getNameg(){
        return nameg;
    }
}
