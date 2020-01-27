package Model.GomokuGame;

import Model.Piece;
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
    public Opening openingRules;

    public GomokuGame(){ }

    public void setGameEnvironment(OpeningType openingType){
        this.openingRules = OpeningFactory.getOpening(openingType);
        openingRules.setPlayer1(getP1());
        openingRules.setPlayer2(getP2());
        this.setRules();
    }

    public abstract void setRules();
    public abstract void checkInvalidMoves();

    public void setPlayers(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public GomokuType getType(){return this.gameType;}

    public Player getP1() { return this.p1; }

    public Player getP2() { return this.p2; }

    public int getGridDim() { return gridSize; }

    public Player getBlackPlayer(){
        if(p1.getColor() == Piece.PieceType.BLACK) return p1;
        else return p2;
    }

    public Player getWhitePlayer(){
        if(p1.getColor() == Piece.PieceType.WHITE) return p1;
        else return p2;
    }
}
