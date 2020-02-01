package View;

import Model.PieceColor;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.stream.IntStream;

public class BoardView extends Pane{

    private GridStructure gridStructure;
    private int boardSize;
    private PieceView[][] pieces;
    private Rectangle background;
    private Color backgroundColor = Color.PINK;

    public BoardView(int inputSize){
        this.boardSize = inputSize + 1;
        this.gridStructure = new GridStructure(this.boardSize);
        this.pieces = new PieceView[this.boardSize][this.boardSize];
        this.initialiseLinesBackground();
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);

        int applicationBorder = 50;
        double newWidth = width - applicationBorder;
        double newHeight = height - applicationBorder;

        this.gridStructure.setCellWidth(newWidth / (this.boardSize - 1));
        this.gridStructure.setCellHeight(newHeight / (this.boardSize - 1));

        this.gridStructure.setStartX((width / 2) - (newWidth / 2));
        this.gridStructure.setStartY((height / 2) - (newHeight / 2));

        this.getChildren().remove(this.background);
        this.background = new Rectangle(width, height);
        this.background.setFill(backgroundColor);
        this.getChildren().add(0, this.background);

        this.gridStructure.horizontalResizeRelocate(newWidth);
        this.gridStructure.verticalResizeRelocate(newHeight);

        this.initialisePieceMatrix();
        this.pieceResizeRelocate();
    }

    private void initialiseLinesBackground() {
        this.background = new Rectangle(600, 600);
        this.background.setFill(backgroundColor);
        this.getChildren().add(this.background);

        this.gridStructure.initializeLines();

        for (int i = 0; i < this.boardSize; ++i) {
            this.getChildren().add(this.gridStructure.horizontal[i]);
            this.getChildren().add(this.gridStructure.vertical[i]);
        }
    }

    private void pieceResizeRelocate() {
        double pieceSize = 0.70;
        double cellX = this.gridStructure.getCellWidth() * pieceSize;
        double cellY = this.gridStructure.getCellHeight() * pieceSize;
        double offsetX = this.gridStructure.getCellWidth() * ((1 - pieceSize) / 2);
        double offsetY = this.gridStructure.getCellHeight() * ((1 - pieceSize) / 2);

        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                pieces[i][j].resize(cellX, cellY);
                pieces[i][j].relocate(this.gridStructure.getStartX() + i * this.gridStructure.getCellWidth() + offsetX - this.gridStructure.getCellWidth() / 2.0,
                        this.gridStructure.getStartY() + j * this.gridStructure.getCellHeight() + offsetY - this.gridStructure.getCellHeight() / 2.0);
            }
        }
    }

    private void initialisePieceMatrix() {
        this.pieces = IntStream
                .range(0, this.boardSize)
                .mapToObj(i -> IntStream.range(0, this.boardSize)
                        .mapToObj(j -> new PieceView(i,j))
                        .toArray(PieceView[]::new))
                .toArray(PieceView[][]::new);

        for (int i = 0; i < this.boardSize; ++i)
            this.getChildren().addAll(pieces[i]);
    }

    public void setPiece(int x, int y,final PieceColor color){
        this.pieces[x][y].setPiece(color);
    }

    public void removePiece(final int x , final int y){
        this.pieces[x][y].removePiece();
    }

    public GridStructure getGrid() {
        return this.gridStructure;
    }

}
