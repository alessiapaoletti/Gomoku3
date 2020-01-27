package Model;

import Model.Rules.Closing;
import Model.Rules.ClosingFactory;
import Model.Rules.InvalidMoves;
import Model.Rules.Opening;

import java.util.Optional;

public abstract class GomokuGame {
    private  Player p1;
    private  Player p2;
    Closing closing;
    private int gridSize;

    private String openingName;
    Opening openingRules;
    InvalidMoves invalidMoves;
    private String gameName;


    public GomokuGame(){
        this.gameName = getGameName();
        this.openingName = this.getOpeningRulesName();
    }

    public abstract void initGame();

    public void setInvalidMoves(int dim) {}

    public void setPlayers(Player p1, Player p2){
        System.out.println(p1.getColor());
        System.out.println(p2.getColor());
        this.p1 = p1;
        this.p2 = p2;
    }

    void callOpeningRules(int clicksCount){ openingRules.callOpening(clicksCount); }

    public void setOpeningRulesName(String name){ openingName = name; }

    public void setGridSize(int size){ gridSize = size; }

    public String getGameName(){return "";}

    public Player getP1() { return this.p1; }

    public Player getP2() { return this.p2; }

    public int getGridDim() { return gridSize;  }

    public String getOpeningRulesName(){ return openingName;}

    int getNumMovesOpening(){ return openingRules.getNumMoves();}

    Player getBlackPlayer(){
        if(p1.getColor() == Piece.PieceType.BLACK) return p1;
        else return p2;
    }

    Player getWhitePlayer(){
        if(p1.getColor() == Piece.PieceType.WHITE) return p1;
        else return p2;
    }
}
