package View;

import Model.PieceColor;

public class GridStructure {

    public PieceColor[][] pieces;
    private final String ANSI_BLACK = "\033[1;90m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_WHITE =  "\033[0;30m";
    // FOR THE CORRECT DISPLAY ON WHITE BACKGROUND TERMINAL
    //private final String ANSI_WHITE = "\u001b[37;1m";
    private final char blackPiece = '\u25CB';
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
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
        if(this.pieces[x][y].equals(PieceColor.BLACK)) return ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"X";
        else if(this.pieces[x][y].equals(PieceColor.WHITE)) return ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"X"+ANSI_BLACK;
        else return "-";
    }

    public void createHorizontalNumbers(){
        String enumeration = " ";
        for(int i=0;i<10;i++){enumeration+= "  "+ i +"  ";}

        for(int i=10;i<this.size;i++){enumeration+= "  "+ i +" ";}

//        StringBuilder numbers = new StringBuilder();
//        for(int i=0;i<this.size;i++){
//            numbers.append("  ").append(i).append("  ");
//        }
        System.out.println(ANSI_PURPLE+enumeration+ANSI_RESET);
    }

    public void createHorizontalLines(Integer i){
        String num;
        if(i<10) num=i.toString()+"  ";
        else num=i.toString()+" ";
        System.out.print(ANSI_PURPLE+num);
        for(int j=0;j<this.size-1;j++){
            System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+this.placePiece(j,i)+"----"+ANSI_RESET);
        }
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+this.placePiece(this.size-1,i)+ANSI_RESET);
    }

    public void createVerticalLines(){
        System.out.println("   "+ANSI_PURPLE+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"|    ".repeat(this.size-1)+"|"+ANSI_RESET);
    }

}
