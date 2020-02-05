package ViewCL;

import Model.PieceColor;

public class GridStructure {


  /*  Line[] horizontal;
    Line[] vertical;
    private Translate[] horizontalTranslate;
    private Translate[] verticalTranslate;
    private double cellWidth;
    private double cellHeight;
    private double startX;
    private double startY;*/
    private PieceColor[][] pieces;
    private final String ANSI_BLACK = "\033[1;90m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_WHITE = "\033[0;30m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private int size;

    public void setPiece(int x, int y,final PieceColor color){
        this.pieces[x][y]=color;  //se la posizione è nera stampo X nera altrimenti bianca.
    };

    public void removePiece(int x ,int y){ this.pieces[x][y]=PieceColor.EMPTY;}

    GridStructure(int size){
        this.size = size;
        this.pieces=new PieceColor[this.size+1][this.size+1];
        for(int j=0;j<this.size+1;j++){
            for(int i=0;i<this.size+1;i++){ this.pieces[i][j]=PieceColor.EMPTY;}
        }
       /* this.horizontal = new Line[this.size + 1];
        this.vertical = new Line[this.size + 1];
        this.horizontalTranslate = new Translate[this.size + 1];
        this.verticalTranslate = new Translate[this.size + 1];*/
    }
    public String placePiece(int x,int y){
        if(this.pieces[x][y].equals(PieceColor.BLACK)) return ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"X";
        else if(this.pieces[x][y].equals(PieceColor.WHITE)) return ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"X"+ANSI_BLACK;
        else return "-";
    };

    public void createHorizontalNumbers(){
        String enumeration = " ";
        for(int i=0;i<10;i++){enumeration+= "  "+Integer.toString(i)+"  ";}
        for(int i=10;i<this.size;i++){enumeration+= "  "+Integer.toString(i)+" ";}
        System.out.println(ANSI_PURPLE+enumeration+ANSI_RESET);
    }

    public void createHorizontalLines(Integer i){
        String num;
        if(i<10) num=i.toString()+"  ";
        else num=i.toString()+" ";
        System.out.print(ANSI_PURPLE+num);
        //System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"-----".repeat(this.size-1)+"------"+ANSI_RESET);
        for(int j=0;j<this.size-1;j++){
            System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+this.placePiece(j,i)+"----"+ANSI_RESET);
        }
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+this.placePiece(this.size-1,i)+ANSI_RESET);
    }

    //i-> Y, j->X

    public void createVerticalLines(){
        //String num="   ";
        //if(i<10) num=i.toString()+"  ";
        //else num=i.toString()+" ";
        //System.out.print(ANSI_PURPLE+num);
        //for(int j=0;j<this.size;j++){
        System.out.println("   "+ANSI_PURPLE+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"|    ".repeat(this.size-1)+"|"+ANSI_RESET);
        //    System.out.print(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"| "+this.placePiece(j,i)+ANSI_RESET);
        //}
        //System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"|"+ANSI_RESET);
    }

    /*
    *  PRINT BLACK
    * System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"X"+ANSI_RESET);
    *  PRINT WHITE
    * System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"X"+ANSI_RESET);
    *
    * */

 /*   void initializeLines(){
        this.createHorizontalLines();
        this.createVerticalLines();
    }

    void horizontalResizeRelocate(final double width) {
        for (int i = 0; i < this.size; ++i) {
            this.horizontal[i].setStartX(this.startX);
            this.horizontal[i].setEndX(this.startX + width);
            this.horizontalTranslate[i].setY(this.startY + this.cellHeight * i);
        }
    }

    void verticalResizeRelocate(final double height) {
        for (int i = 0; i < this.size; ++i) {
            this.vertical[i].setStartY(this.startY);
            this.vertical[i].setEndY(this.startY + height);
            this.verticalTranslate[i].setX(this.startX + this.cellWidth * i);
        }
    }

    void setCellWidth(double cellWidth) {
        this.cellWidth = cellWidth;
    }
    void setCellHeight(double cellHeight) {
        this.cellHeight = cellHeight;
    }
    void setStartX(double startX) {
        this.startX = startX;
    }
    void setStartY(double startY) {
        this.startY = startY;
    }

    public double getCellWidth() {
        return cellWidth;
    }
    public double getCellHeight() {
        return cellHeight;
    }
    public double getStartX() {
        return startX;
    }
    public double getStartY() {
        return startY;
    }

*/


}
