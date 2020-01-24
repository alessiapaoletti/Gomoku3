package Model;


import java.util.List;

public abstract class GomokuGame {
    private  Player p1;
    private  Player p2;
    private int gridSize;

    String openingName;
    Opening openingRules;
    InvalidMoves invalidMoves;
    public String gameName;
    String OpeningName;


    public GomokuGame(){
        this.gameName = getGameName();
        this.OpeningName = this.getOpeningRulesName();
    }

    public abstract void initGame();

    public void setInvalidMoves(int dim) {}

    public void setPlayers(Player p1, Player p2){
        System.out.println(p1.getColor());
        System.out.println(p2.getColor());
        this.p1 = p1;
        this.p2 = p2;
    }

    public void callOpeningRules(int clicksCount){ openingRules.callOpening(clicksCount); }

    public void setOpeningRulesName(String name){ openingName = name; }

    public void setGridSize(int size){ gridSize = size; }

    public String getGameName(){return "";}

    public Player getP1() { return this.p1; }

    public Player getP2() { return this.p2; }

    public int getGridDim() { return gridSize;  }

    public String getOpeningRulesName(){ return openingName;}

    int getNumMovesOpening(){ return openingRules.getNumMoves();}

    public Player getBlackPlayer(){
        if(p1.getColor() == Piece.PieceType.BLACK) return p1;
        else return p2;
    }

    public Player getWhitePlayer(){
        if(p1.getColor() == Piece.PieceType.WHITE) return p1;
        else return p2;
    }

}
