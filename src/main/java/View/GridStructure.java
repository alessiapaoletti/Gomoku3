package View;

import Model.Piece.*;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GridStructure {

    public PieceColor[][] pieces;
    private final String ANSI_BLACK = "\033[1;90m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_WHITE =  "\033[0;30m";
    private final String ANSI_PURPLE1 = "\u001B[95m";
    // FOR THE CORRECT DISPLAY ON WHITE BACKGROUND TERMINAL
    //private final String ANSI_WHITE = "\u001b[37m";
    //private final String ANSI_BLACK= "\u001b[30m";
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private int size;

    public GridStructure(int size){
        this.size = size;
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
        if(this.pieces[x][y].equals(PieceColor.BLACK)) return ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"X"+ANSI_PURPLE1;
        else if(this.pieces[x][y].equals(PieceColor.WHITE)) return ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"X"+ANSI_PURPLE1;
        else return "-";
    }

    public void createHorizontalNumbers(){
        String  enumeration = " ";
        for(int i=0;i<10;i++){enumeration+= "  "+ i +"  ";}
        for(int i=10;i<this.size;i++){enumeration+= "  "+ i +" ";}

//        StringBuilder numbers = new StringBuilder();
//        for(int i=0;i<this.size;i++){
//            numbers.append("  ").append(i).append("  ");
//        }
        System.out.println(ANSI_PURPLE+enumeration+ANSI_RESET+"\r");
    }


    public void createHorizontalLines(Integer i){
        String num;
        if(i<10) num=i.toString()+"  ";
        else num=i.toString()+" ";
        System.out.print(ANSI_PURPLE+num);
        IntStream.range(0, this.size-1)
                .forEach(index -> { System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+this.placePiece(index,i)+"----"+ANSI_RESET); });
        /*for(int j=0;j<this.size-1;j++){
            System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+this.placePiece(j,i)+"----"+ANSI_RESET);
        }*/
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+this.placePiece(this.size-1,i)+ANSI_RESET+"\r");
    }

    public void createVerticalLines(){
        System.out.println("   "+ANSI_PURPLE+ANSI_PURPLE_BACKGROUND+ANSI_PURPLE1+"|    ".repeat(this.size-1)+"|"+ANSI_RESET+"\r");
    }

}
