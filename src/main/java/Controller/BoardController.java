package Controller;

import Model.Board;
import Model.ControlSkin;
import Model.GomokuGame;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;

public class BoardController extends Control {

    private Board myBoard;
    private int clicks_count; //clicks count added in order to set the opening moves check.
    public BoardController(int gridSize,GomokuGame game ) {
        this.setSkin(new ControlSkin(this));
        this.myBoard = new Board(gridSize,game);
        this.getChildren().add(this.myBoard);

        clicks_count=this.myBoard.InitialMove();
        this.setOnMouseClicked((event) -> {
            clicks_count++;
            // Here appends the opening moves controll

            if(clicks_count== Board.N || clicks_count== Board.N +2) {
                clicks_count=this.myBoard.getOpgame(event.getX(), event.getY(),clicks_count);
            }

            //Here the game goes on
            else this.myBoard.placePiece(event.getX(), event.getY());
        });

        this.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) this.myBoard.reset();
        });
    }


    /* Resize the width and the height of the window when dragging the mouse  */
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        this.myBoard.resize(width, height);
    }
}

