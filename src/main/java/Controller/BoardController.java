package Controller;

import Model.Board;
import Model.ControlSkin;
import Model.GomokuGame;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.util.Optional;

public class BoardController extends Control {

    public static Board myBoard;
    private int clicks_count = 0; //clicks count added in order to set the opening moves check.

    public BoardController(int gridSize,GomokuGame game ) {
        this.myBoard = new Board(gridSize, game);
        this.setSkin(new ControlSkin(this));
        this.myBoard = new Board(gridSize,game);
        this.getChildren().add(this.myBoard);

        clicks_count=this.myBoard.InitialMove();
        this.setOnMouseClicked((event) -> {
            clicks_count++;
            // Here appends the opening moves controll

            if(clicks_count== this.myBoard.N || clicks_count== this.myBoard.N +2) {
                this.myBoard.getOpgame(event.getX(), event.getY(),clicks_count);
                this.myBoard.getIngame(event.getX(), event.getY());
            }

            //Here the game goes on
            else this.myBoard.getIngame(event.getX(), event.getY());
        });

    }


    public static void gameOver(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        alert.setHeaderText(message);

        ButtonType buttonTypeOK = new ButtonType("OK");
        alert.getButtonTypes().setAll( buttonTypeOK);

        Stage stage = (Stage) myBoard.getScene().getWindow();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK){
            stage.close();
        }


    }


    /* Resize the width and the height of the window when dragging the mouse  */
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.myBoard.resize(width, height);
    }
}

