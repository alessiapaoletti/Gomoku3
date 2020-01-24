package View;


import Model.Piece;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class BoardView extends Pane{

    private Rectangle background; //rectangle for the background of the board
    private Line[] horizontal; //array for horizontal lines
    private Line[] vertical; //array for vertical lines
    private Translate[] horizontal_t; //array holding translate obj for the horizontal grid lines
    private Translate[] vertical_t; //array holding translate obj for the vertical grid lines

    /* needed when resizing the board */
    public double cell_width;
    public double cell_height;

    /* offset to center the board in the window */
    public double start_x;
    public double start_y;

    /* size of the grid */
    private int line_number;
    private int board_size;

    private PieceView[][] pieces;

    private static Color BACKGROUND_COLOR = Color.PINK;


  //  private final int EMPTY_SPACE = 0;


//    public static int APPLICATION_WIDTH = 600;
//    public static int APPLICATION_HEIGHT = 600;


    public BoardView(int inputSize){
        this.line_number = inputSize;
        this.board_size = this.line_number + 1;
        this.horizontal = new Line[this.board_size + 1];
        this.vertical = new Line[this.board_size + 1];
        this.horizontal_t = new Translate[this.board_size + 1];
        this.vertical_t = new Translate[this.board_size + 1];

        this.pieces = new PieceView[inputSize+1][inputSize+1];
        this.initialiseLinesBackground();

    }



    // overridden version of the resize method to give the board the correct size
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        //border between the grid and the window
        int APPLICATION_BORDER = 50;
        double newWidth = width - APPLICATION_BORDER;
        double newHeight = height - APPLICATION_BORDER;

        if (width > height) newWidth = newHeight;
        else newHeight = newWidth;

        this.cell_width = newWidth / this.line_number;
        this.cell_height = newHeight / this.line_number;

        this.start_x = (width / 2) - (newWidth / 2);
        this.start_y = (height / 2) - (newHeight / 2);

        this.getChildren().remove(this.background);
        this.background = new Rectangle(width, height);
        this.background.setFill(BACKGROUND_COLOR);
        this.getChildren().add(0, this.background);

        this.horizontalResizeRelocate(newWidth);
        this.verticalResizeRelocate(newHeight);

        this.initialiseRender();
        this.pieceResizeRelocate();

    }


    // private method that will initialise the background and the lines
    private void initialiseLinesBackground() {
        this.background = new Rectangle(600, 600);
        this.background.setFill(BACKGROUND_COLOR);
        this.getChildren().add(this.background);

        for (int i = 0; i < this.line_number + 1; ++i) {
            this.horizontal[i] = new Line();

            this.horizontal[i].setStartX(0);
            this.horizontal[i].setStartY(0);
            this.horizontal[i].setEndY(0);

            this.horizontal_t[i] = new Translate(0, 0);
            this.horizontal[i].getTransforms().add(this.horizontal_t[i]);

            this.getChildren().add(this.horizontal[i]);
        }

        for (int i = 0; i < this.line_number + 1; ++i) {
            this.vertical[i] = new Line();

            this.vertical[i].setStartX(0);
            this.vertical[i].setEndX(0);
            this.vertical[i].setStartY(0);

            this.vertical_t[i] = new Translate(0, 0);
            this.vertical[i].getTransforms().add(this.vertical_t[i]);

            this.getChildren().add(this.vertical[i]);
        }
    }

    // private method for resizing and relocating the horizontal lines
    private void horizontalResizeRelocate(final double width) {
        for (int i = 0; i < this.line_number + 1; ++i) {
            this.horizontal[i].setStartX(this.start_x);
            this.horizontal[i].setEndX(this.start_x + width);
            this.horizontal_t[i].setY(this.start_y + this.cell_height * i);
        }
    }

    // private method for resizing and relocating the vertical lines
    private void verticalResizeRelocate(final double height) {
        for (int i = 0; i < this.line_number + 1; ++i) {
            this.vertical[i].setStartY(this.start_y);
            this.vertical[i].setEndY(this.start_y + height);
            this.vertical_t[i].setX(this.start_x + this.cell_width * i);
        }
    }

    // private method for resizing and relocating all the pieces
    private void pieceResizeRelocate() {
        //piece dimension
        double PIECE_SIZE = 0.70;
        double cellX = this.cell_width * PIECE_SIZE;
        double cellY = this.cell_height * PIECE_SIZE;
        double offsetX = this.cell_width * ((1 - PIECE_SIZE) / 2);
        double offsetY = this.cell_height * ((1 - PIECE_SIZE) / 2);
        for (int i = 0; i < this.board_size; ++i) {
            for (int j = 0; j < this.board_size; ++j) {
                pieces[i][j].resize(cellX, cellY);
                pieces[i][j].relocate(this.start_x + i * this.cell_width + offsetX - this.cell_width / 2.0, this.start_y + j * this.cell_height + offsetY - this.cell_height / 2.0);
            }
        }
    }

    // private method that will initialise everything in the render array
    private void initialiseRender() {

        for (int i = 0; i < this.board_size; ++i) {
            for (int j = 0; j < this.board_size; ++j) {
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
