package Model.GomokuGame;

import Model.Piece;
import Model.Player;
import Model.Rules.Closing.Closing;
import Model.Rules.InvalidMoves;
import Model.Rules.Opening.Opening;


public abstract class GomokuGame {
    private Player p1;
    private  Player p2;
    public Closing closing;
    private int gridSize;

    private String openingName;
    Opening openingRules;
    InvalidMoves invalidMoves;


    public GomokuGame(){
        String gameName = getGameName();
        this.openingName = this.getOpeningRulesName();
    }

    public abstract void initGame();

    public void setInvalidMoves(int dim) {}

    public void setPlayers(Player p1, Player p2){
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

    public int getNumMovesOpening(){ return openingRules.getNumMoves();}

    public Player getBlackPlayer(){
        if(p1.getColor() == Piece.PieceType.BLACK) return p1;
        else return p2;
    }

    public Player getWhitePlayer(){
        if(p1.getColor() == Piece.PieceType.WHITE) return p1;
        else return p2;
    }
}
