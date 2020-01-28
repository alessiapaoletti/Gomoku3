package Model.GomokuGame;

import Model.PieceColor;
import Model.Player;
import Model.Rules.Closing.Closing;
import Model.Rules.Opening.Opening;
import Model.Rules.Opening.OpeningFactory;
import Model.Rules.Opening.OpeningType;

public abstract class GomokuGame {
    private Player p1;
    private Player p2;
    int gridSize;
    GomokuType gameType;

    public Closing closing;
    private Opening openingRules;

    public GomokuGame(){ }

    public abstract void setRules();
    public abstract void checkInvalidMoves();

    public void setGameEnvironment(OpeningType openingType){
        this.openingRules = OpeningFactory.getOpening(openingType);
        this.openingRules.setPlayers(getP1(), getP2());
//        this.openingRules.setPlayer1(getP1());
//        this.openingRules.setPlayer2(getP2());
        this.setRules();
    }

    public void setPlayers(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    //void setGameType(GomokuType gomokuType) {this.gameType = gomokuType; }
    //void setGridSize (int gridSize){ this.gridSize = gridSize; }
    //public GomokuType getType(){return this.gameType;}

    public Player getP1() { return this.p1; }

    public Player getP2() { return this.p2; }

    public int getGridSize() { return gridSize; }

    //public Closing getClosing(){return this.closing; }
    public Opening getOpeningRules() {return this.openingRules; }

    public Player getBlackPlayer(){
        if(p1.getColor() == PieceColor.BLACK) return p1;
        else return p2;
    }

    public Player getWhitePlayer(){
        if(p1.getColor() == PieceColor.WHITE) return p1;
        else return p2;
    }
}
