package Controller;

import Model.*;
import View.BoardView;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class BoardController extends Control {

    public static BoardLogic boardLogic;
    public static BoardView boardView;
    public int clicksCount; //clicks count added in order to set the opening moves check.
    private StackPane stackPaneMainLayout;

    public BoardController(int gridSize, int clicksCount) {
        boardLogic = new BoardLogic(gridSize);
        boardView = new BoardView(gridSize);
        this.setSkin(new ControlSkin(this));
        this.getChildren().add(boardView);
        //this.clicksCount = boardLogic.InitialMove();
        this.clicksCount = clicksCount;
        this.stackPaneMainLayout = new StackPane();
        this.stackPaneMainLayout.getChildren().add(this);
    }

    public static void gameOver(String winner){
        Stage stage = (Stage) boardView.getScene().getWindow();
        String result = View.Alert.gameOverAlert(winner);
        if("OK".equals(result)) stage.close();
    }

    public static void gameOver(){
        Stage stage = (Stage) boardView.getScene().getWindow();
        String result = View.Alert.gameOverAlert();
        if("OK".equals(result)) stage.close();
    }


    /* Resize the width and the height of the window when dragging the mouse  */
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        boardView.resize(width, height);
        boardView.initialiseRender(boardLogic.getPiecesMatrix());
        boardView.pieceResizeRelocate(boardLogic.getPiecesMatrix());
    }

    public void placePiece(final double x, final double y) {
        int cellX = (int)((x - boardView.start_x + (boardView.cell_width / 2.0)) / boardView.cell_width);
        int cellY = (int)((y - boardView.start_y + (boardView.cell_height / 2.0)) / boardView.cell_height);
        boardLogic.placePieceBl(cellX, cellY);
    }

    public void UnplacePiece(final double x, final double y) {
        int cellX = (int)((x - boardView.start_x + (boardView.cell_width / 2.0)) / boardView.cell_width);
        int cellY = (int)((y - boardView.start_y + (boardView.cell_height / 2.0)) / boardView.cell_height);
        //System.out.println(cellX);
        //System.out.println(cellY);
        boardLogic.unplacePieceBl(cellX, cellY);
    }

    public void start() throws IOException {
        Stage primaryStage = new Stage(StageStyle.DECORATED);
        primaryStage.setTitle("GOMOKU board");
        primaryStage.setScene(new Scene(this.stackPaneMainLayout, BoardView.APPLICATION_WIDTH, BoardView.APPLICATION_HEIGHT));
        primaryStage.show();
    }
}

