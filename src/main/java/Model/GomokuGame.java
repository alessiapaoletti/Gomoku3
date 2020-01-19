package Model;

public abstract class GomokuGame {
    private static   Player p1;
    private static Player p2;
    private static int gridSize;

    static String openingName;
    protected static Opening openingRules;
    protected InvalidMoves invalidMoves;
    public static Closing closingRules;
    public String gameName;
    String OpeningName;

    public static int currentPlayer;

    public GomokuGame(){
        this.gameName = getGameName();
        this.OpeningName = GomokuGame.getOpeningRulesName();
        currentPlayer = BoardLogic.BLACK_PLAYER;
    }

    public abstract void initGame();

    public void setInvalidMoves() {}

    public void setPlayers(Player p1, Player p2){
        System.out.println(p1.getColor());
        System.out.println(p2.getColor());
        GomokuGame.p1 = p1;
        GomokuGame.p2 = p2;
    }

    public static void callOpeningRules(int clicksCount){ openingRules.callOpening(clicksCount); }

    public void setOpeningRulesName(String name){ openingName = name; }

    public void setGridSize(int size){ gridSize = size; }

    public String getGameName(){return " ";}

    public static Player getP1() { return p1; }

    public static Player getP2() { return p2; }

    public static int getGridDim() { return gridSize;  }

    public static String getOpeningRulesName(){ return openingName;}

    public static int getNumMovesOpening(){ return openingRules.getNummoves();}

    //utility function to call specific game's opening rule.
    //public static void callOpeningRules(int c){ OpeningRules(c); }

    //public void Rules(){ setInvalidMoves(); }


    public static Player GetBlack(){
        if(p1.getColor().get() ==1) return p1;
        else return p2;
    }

    public static Player GetWhite(){
        if(p1.getColor().get() ==2) return p1;
        else return p2;
    }
}
