package View;

import Model.Piece.PieceColor;
import java.util.stream.IntStream;

class GridStructure {

    PieceColor[][] pieces;
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_PURPLE1 = "\u001B[95m";
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private final String SINGLE_SPACE = " ";
    private final String SINGLE_DASH = "-";
    private int size;

    GridStructure(int size){
        this.size = size;
        this.pieces=new PieceColor[this.size+1][this.size+1];
        for(int j=0;j<this.size+1;j++){
            for(int i=0;i<this.size+1;i++){ this.pieces[i][j]=PieceColor.EMPTY;}
        }
    }

    void setPiece(int x, int y,final PieceColor color){ this.pieces[x][y] = color;  }

    void removePiece(int x ,int y){ this.pieces[x][y] = PieceColor.EMPTY;}

    private String placePiece(int x,int y){

        String ANSI_BLACK = "\033[1;90m";
        String ANSI_WHITE = "\033[0;30m";

        // FOR THE CORRECT DISPLAY ON WHITE BACKGROUND TERMINAL
        //String ANSI_WHITE = "\u001b[37m";
        //String ANSI_BLACK= "\u001b[30m";

        if(this.pieces[x][y].equals(PieceColor.BLACK)) return ANSI_PURPLE_BACKGROUND + ANSI_BLACK + "X" + ANSI_PURPLE1;
        else if(this.pieces[x][y].equals(PieceColor.WHITE)) return ANSI_WHITE + ANSI_PURPLE_BACKGROUND + "X" + ANSI_PURPLE1;
        else return SINGLE_DASH;
    }

    void createHorizontalNumbers(){
        StringBuilder numbers = new StringBuilder(SINGLE_SPACE.repeat(2));
        IntStream.range(0, this.size)
                .forEach(i -> numbers.append(String.format("%5s", i)));

        System.out.println(ANSI_PURPLE+numbers+ANSI_RESET);
    }

    void createHorizontalLines(Integer i){
        String num = String.format("%3s", i.toString());
        System.out.print(ANSI_PURPLE + num + SINGLE_SPACE );

        IntStream.range(0, this.size-1)
                .forEach(index -> System.out.print(ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 +
                        SINGLE_DASH.repeat(2) + this.placePiece(index,i) + SINGLE_DASH.repeat(2) + ANSI_RESET));

        System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + SINGLE_DASH +  this.placePiece(this.size-1,i) +
                SINGLE_DASH.repeat(2) + ANSI_RESET);
    }

    void createVerticalLines(){
        String SINGLE_VERT_BAR = "|";
        System.out.println(SINGLE_SPACE.repeat(4) + ANSI_PURPLE + ANSI_PURPLE_BACKGROUND + SINGLE_SPACE + ANSI_PURPLE1 +
                (SINGLE_SPACE + SINGLE_VERT_BAR + SINGLE_SPACE.repeat(3)).repeat(this.size-1)
                + SINGLE_VERT_BAR + SINGLE_SPACE.repeat(2) + ANSI_RESET); }
}
