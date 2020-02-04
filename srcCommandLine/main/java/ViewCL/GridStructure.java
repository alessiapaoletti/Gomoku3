package ViewCL;


public class GridStructure {


  /*  Line[] horizontal;
    Line[] vertical;
    private Translate[] horizontalTranslate;
    private Translate[] verticalTranslate;
    private double cellWidth;
    private double cellHeight;
    private double startX;
    private double startY;*/
    private final String ANSI_BLACK = "\033[1;90m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_WHITE = "\033[0;30m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private int size;

    GridStructure(int size){
        this.size = size;
       /* this.horizontal = new Line[this.size + 1];
        this.vertical = new Line[this.size + 1];
        this.horizontalTranslate = new Translate[this.size + 1];
        this.verticalTranslate = new Translate[this.size + 1];*/
    }


    public void createHorizontalNumbers(){
        String enumeration = "   ";
        for(int i=0;i<10;i++){enumeration+= "  "+Integer.toString(i)+"  ";}
        for(int i=10;i<this.size;i++){enumeration+= "  "+Integer.toString(i)+" ";}
        System.out.println(ANSI_PURPLE+enumeration+ANSI_RESET);
    }

    public void createHorizontalLines(){
        System.out.println("   "+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"+----".repeat(this.size-1)+"+----+"+ANSI_RESET);
    }

    public void createVerticalLines(Integer i){
        String num;
        if(i<10) num=i.toString()+"  ";
        else num=i.toString()+" ";
        System.out.println(ANSI_PURPLE+num+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"|    ".repeat(this.size)+"|"+ANSI_RESET);

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
