package View;

import Model.Piece.Piece;
import Model.Piece.PieceColor;

import java.util.stream.IntStream;

class GridStructure {

    PieceColor[][] pieces;
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_PURPLE1 = "\u001B[95m";
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private int size;

    GridStructure(int size){
        this.size = size;
        /* first we have to create the matrix and the assing the empty color */
        /*this.pieces = IntStream
                .range(0, this.size+1)
                .mapToObj(i -> IntStream.range(0, this.size+1)
                        .mapToObj(PieceColor[][]::new)
                        .toArray(PieceColor[]::new))
                .toArray(PieceColor[][]::new);*/

        this.pieces=new PieceColor[this.size+1][this.size+1];
        for(int j=0;j<this.size+1;j++){
            for(int i=0;i<this.size+1;i++){ this.pieces[i][j]=PieceColor.EMPTY;}
        }
    }

    void setPiece(int x, int y,final PieceColor color){
        this.pieces[x][y]=color;
    }

    void removePiece(int x ,int y){ this.pieces[x][y]=PieceColor.EMPTY;}

    private String placePiece(int x,int y){

        String ANSI_BLACK = "\033[1;90m";
        String ANSI_WHITE = "\033[0;30m";

        // FOR THE CORRECT DISPLAY ON WHITE BACKGROUND TERMINAL
        //String ANSI_WHITE = "\u001b[37m";
        //String ANSI_BLACK= "\u001b[30m";

        if(this.pieces[x][y].equals(PieceColor.BLACK)) return ANSI_PURPLE_BACKGROUND + ANSI_BLACK + "X" + ANSI_PURPLE1;
        else if(this.pieces[x][y].equals(PieceColor.WHITE)) return ANSI_WHITE + ANSI_PURPLE_BACKGROUND + "X" + ANSI_PURPLE1;
        else return "-";
    }

    void createHorizontalNumbers(){
        String singleSpace = " ";
        String doubleSpace = "  ";

        StringBuilder enumeration = new StringBuilder(singleSpace);

        for(int i=0;i<10;i++){
            enumeration.append(doubleSpace).append(i).append(doubleSpace);}

        for(int i=10;i<this.size;i++){
            enumeration.append(doubleSpace).append(i).append(singleSpace);}

        System.out.println(ANSI_PURPLE+enumeration+ANSI_RESET);
    }

    void createHorizontalLines(Integer i){
        String num;
        if(i<10) num=i.toString()+"  ";
        else num=i.toString()+" ";
        System.out.print(ANSI_PURPLE+num);
        for(int j=0;j<this.size-1;j++){
            System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+this.placePiece(j,i)+"----"+ANSI_RESET);
        }
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+this.placePiece(this.size-1,i)+ANSI_RESET);
    }

    void createVerticalLines(){
        System.out.println("   "+ANSI_PURPLE+ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+"|    ".repeat(this.size-1)+"|"+ANSI_RESET);
    }

}
