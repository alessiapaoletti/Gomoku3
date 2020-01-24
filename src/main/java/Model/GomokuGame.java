package Model;


public abstract class GomokuGame {
    private static   Player p1;
    private static Player p2;
    private static int gridSize;

    static String openingName;
    static Opening openingRules;
    InvalidMoves invalidMoves;
    public String gameName;
    String OpeningName;


    public GomokuGame(){
        this.gameName = getGameName();
        this.OpeningName = GomokuGame.getOpeningRulesName();
    }

    public abstract void initGame();

    public void setInvalidMoves(int dim) {}

    public void setPlayers(Player p1, Player p2){
        System.out.println(p1.getColor());
        System.out.println(p2.getColor());
        GomokuGame.p1 = p1;
        GomokuGame.p2 = p2;
    }

    public void callOpeningRules(int clicksCount){ openingRules.callOpening(clicksCount); }

    public void setOpeningRulesName(String name){ openingName = name; }

    public void setGridSize(int size){ gridSize = size; }

    public String getGameName(){return "";}

    public static Player getP1() { return p1; }

    public static Player getP2() { return p2; }

    public static int getGridDim() { return gridSize;  }

    public static String getOpeningRulesName(){ return openingName;}

    int getNumMovesOpening(){ return openingRules.getNumMoves();}

    public static Player getBlackPlayer(){
        if(p1.getColor() == Piece.PieceType.BLACK) return p1;
        else return p2;
    }

    public static Player getWhitePlayer(){
        if(p1.getColor() == Piece.PieceType.WHITE) return p1;
        else return p2;
    }

}
