package View;

import Model.Piece;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class BoardView extends Pane{
    private Rectangle background;
    private Line[] horizontal;
    private Line[] vertical;
    private Translate[] horizontalTranslate;
    private Translate[] verticalTranslate;
    public double cellWidth;
    public double cellHeight;
    public double startX;
    public double startY;
    private int lineNumber;
    private int boardSize;
    private PieceView[][] pieces;
    private Color backgroundColor = Color.PINK;

    public BoardView(int inputSize){
        this.lineNumber = inputSize;
        this.boardSize = this.lineNumber + 1;
        this.horizontal = new Line[this.boardSize + 1];
        this.vertical = new Line[this.boardSize + 1];
        this.horizontalTranslate = new Translate[this.boardSize + 1];
        this.verticalTranslate = new Translate[this.boardSize + 1];
        this.pieces = new PieceView[inputSize+1][inputSize+1];
        this.initialiseLinesBackground();
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        int applicationBorder = 50;
        double newWidth = width - applicationBorder;
        double newHeight = height - applicationBorder;

        if (width > height) newWidth = newHeight;
        else newHeight = newWidth;

        this.cellWidth = newWidth / this.lineNumber;
        this.cellHeight = newHeight / this.lineNumber;

        this.startX = (width / 2) - (newWidth / 2);
        this.startY = (height / 2) - (newHeight / 2);

        this.getChildren().remove(this.background);
        this.background = new Rectangle(width, height);
        this.background.setFill(backgroundColor);
        this.getChildren().add(0, this.background);

        this.horizontalResizeRelocate(newWidth);
        this.verticalResizeRelocate(newHeight);

        this.initialiseRender();
        this.pieceResizeRelocate();
    }

    private void initialiseLinesBackground() {
        this.background = new Rectangle(600, 600);
        this.background.setFill(backgroundColor);
        this.getChildren().add(this.background);

        for (int i = 0; i < this.lineNumber + 1; ++i) {
            this.horizontal[i] = new Line();

            this.horizontal[i].setStartX(0);
            this.horizontal[i].setStartY(0);
            this.horizontal[i].setEndY(0);

            this.horizontalTranslate[i] = new Translate(0, 0);
            this.horizontal[i].getTransforms().add(this.horizontalTranslate[i]);

            this.getChildren().add(this.horizontal[i]);
        }

        for (int i = 0; i < this.lineNumber + 1; ++i) {
            this.vertical[i] = new Line();

            this.vertical[i].setStartX(0);
            this.vertical[i].setEndX(0);
            this.vertical[i].setStartY(0);

            this.verticalTranslate[i] = new Translate(0, 0);
            this.vertical[i].getTransforms().add(this.verticalTranslate[i]);

            this.getChildren().add(this.vertical[i]);
        }
    }

    private void horizontalResizeRelocate(final double width) {
        for (int i = 0; i < this.lineNumber + 1; ++i) {
            this.horizontal[i].setStartX(this.startX);
            this.horizontal[i].setEndX(this.startX + width);
            this.horizontalTranslate[i].setY(this.startY + this.cellHeight * i);
        }
    }

    private void verticalResizeRelocate(final double height) {
        for (int i = 0; i < this.lineNumber + 1; ++i) {
            this.vertical[i].setStartY(this.startY);
            this.vertical[i].setEndY(this.startY + height);
            this.verticalTranslate[i].setX(this.startX + this.cellWidth * i);
        }
    }

    private void pieceResizeRelocate() {
        double pieceSize = 0.70;
        double cellX = this.cellWidth * pieceSize;
        double cellY = this.cellHeight * pieceSize;
        double offsetX = this.cellWidth * ((1 - pieceSize) / 2);
        double offsetY = this.cellHeight * ((1 - pieceSize) / 2);
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                pieces[i][j].resize(cellX, cellY);
                pieces[i][j].relocate(this.startX + i * this.cellWidth + offsetX - this.cellWidth / 2.0, this.startY + j * this.cellHeight + offsetY - this.cellHeight / 2.0);
            }
        }
    }

    private void initialiseRender() {
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                pieces[i][j] = new PieceView();
                pieces[i][j].setX(i);
                pieces[i][j].setY(j);
            }
            this.getChildren().addAll(pieces[i]);
        }
    }

    public void setPiece(int x, int y,final Piece.PieceType color){
        this.pieces[x][y].setPiece(color);
    }

    public void removePiece(final int x , final int y){
        this.pieces[x][y].removePiece();
    }

}
