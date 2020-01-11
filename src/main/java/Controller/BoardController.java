package Controller;
//
//import Model.GomokuGame;
//import Model.Player;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Tab;
//import javafx.scene.layout.AnchorPane;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//
//public class BoardController implements Initializable {
//
//    private final AnchorPane rootPane ;
//
//    @FXML
//    Player p1;
//    Player p2;
//
//    @FXML private Tab p1Board;
//
//    @FXML private Tab p2Board;
//
//    @FXML private javafx.scene.control.Label c1Board;
//
//    @FXML private javafx.scene.control.Label c2Board;
//
//    @FXML private javafx.scene.control.Label s1Board;
//
//    @FXML private javafx.scene.control.Label s2Board;
//
//
//    public BoardController() {
//        rootPane = new AnchorPane();
//    }
//
//    public AnchorPane getRootPane() {
//        return rootPane ;
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        p1Board.setText(GomokuGame.getP1().getName());
//        p2Board.setText(GomokuGame.getP2().getName());
//
//        c1Board.setText(GomokuGame.getP1().getColor());
//        c2Board.setText(GomokuGame.getP2().getColor());
//
//        s1Board.setText(String.valueOf(GomokuGame.getP1().getScore()));
//        s2Board.setText(String.valueOf(GomokuGame.getP2().getScore()));
//
//    }
//}

import Model.Board;
import Model.ControlSkin;
import Model.GomokuGame;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;


public class BoardController extends Control {

    Board myBoard;
    private int clicks_count = 0; //clicks count added in order to set the opening moves check.
    public BoardController(int gridSize,GomokuGame game ) {
        this.setSkin(new ControlSkin(this));
        this.myBoard = new Board(gridSize,game);
        this.getChildren().add(this.myBoard);

        clicks_count=this.myBoard.InitialMove();
        this.setOnMouseClicked((event) -> {
            clicks_count++;
            // Here appends the opening moves controll

            if(clicks_count==this.myBoard.N || clicks_count==this.myBoard.N+2) {
                clicks_count=this.myBoard.getOpgame(event.getX(), event.getY(),clicks_count);
                this.myBoard.getIngame(event.getX(), event.getY());
            }

            //Here the game goes on
            else this.myBoard.getIngame(event.getX(), event.getY());
        });

        this.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) this.myBoard.reset();
        });
    }


    /* Function to resize the width and the height of the window when dragging the mouse
    */
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.myBoard.resize(width, height);
    }
}

