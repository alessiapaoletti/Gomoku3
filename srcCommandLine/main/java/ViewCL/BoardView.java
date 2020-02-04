package ViewCL;

import Model.PieceColor;
import Model.Piece;
import ViewCL.GridStructure;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BoardView{
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String STAR = "*****************";

    private GridStructure gridStructure;
    private int boardSize;
    //private PieceColor [][] pieces;
    /* private Rectangle background;
     private Color backgroundColor = Color.PINK;
 */
    public BoardView(int inputSize,String type){
        this.boardSize = inputSize + 1;
        System.out.println(ANSI_PURPLE+STAR.repeat(2)+"  "+type+"  "+STAR.repeat(2)+ANSI_RESET);
        this.gridStructure = new GridStructure(this.boardSize);
       /* this.pieces = new PieceView[this.boardSize][this.boardSize];
        this.initialiseLinesBackground();*/
    }

    public int Getx(String PlayerColor){
        System.out.println("\n"+ANSI_PURPLE+"Insert new "+PlayerColor+" piece (x coordinate): "+ANSI_RESET);
        try {
           return new Scanner(System.in).nextInt();
        }catch (InputMismatchException e){
            System.out.println(ANSI_RED+"Invalid coordinate"+ANSI_RESET);
           return this.Getx(PlayerColor);
        }
    };

    public int Gety(String PlayerColor){
        System.out.println("\n"+ANSI_PURPLE+"Insert new "+PlayerColor+" piece (y coordinate): "+ANSI_RESET);
        try {
            return new Scanner(System.in).nextInt();
        }catch (InputMismatchException e){
            System.out.println(ANSI_RED+"Invalid coordinate"+ANSI_RESET);
            return this.Gety(PlayerColor);
        }
    };

    public void setPiece(int x, int y,final PieceColor color){
        this.gridStructure.setPiece(x,y,color);
    };

    public void removePiece(int x ,int y){ this.gridStructure.removePiece(x,y);}

    public void createBoard(){
        System.out.println("\n");
        this.gridStructure.createHorizontalNumbers();
        for(int i=0;i<this.boardSize-1;i++) {
            this.gridStructure.createHorizontalLines(i);
            this.gridStructure.createVerticalLines();
        }
        this.gridStructure.createHorizontalLines(this.boardSize-1);
    };
/*

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
*/


/*   public GridStructure getGrid() {
        return this.gridStructure;
    }

    */
}
