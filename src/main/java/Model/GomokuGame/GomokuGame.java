package Model.GomokuGame;

import Model.BlackPlayer;
import Model.Rules.Closing.Closing;
import Model.Rules.Opening.Opening;
import Model.Rules.Opening.OpeningFactory;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;

public abstract class GomokuGame {
//    private Player blackPlayer;
//    private Player whitePlayer;
    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;
    int gridSize;
    GomokuType gameType;

    public Closing closing;
    private Opening openingRules;

    public GomokuGame(){ }

    public abstract void setRules();
    public abstract void checkInvalidMoves();

    public void setGameEnvironment(OpeningType openingType){
        this.openingRules = OpeningFactory.getOpening(openingType);
        this.openingRules.setPlayers(getBlackPlayer(), getWhitePlayer());
        this.setRules();
    }

    public void setPlayers(BlackPlayer p1, WhitePlayer p2){
        this.blackPlayer = p1;
        this.whitePlayer = p2;
    }

    //void setGameType(GomokuType gomokuType) {this.gameType = gomokuType; }
    //void setGridSize (int gridSize){ this.gridSize = gridSize; }
    //public GomokuType getType(){return this.gameType;}

    public BlackPlayer getBlackPlayer() { return this.blackPlayer; }

    public WhitePlayer getWhitePlayer() { return this.whitePlayer; }

    public int getGridSize() { return gridSize; }

    //public Closing getClosing(){return this.closing; }
    public Opening getOpeningRules() {return this.openingRules; }

//    public Player getBlackPlayer(){
//        if(blackPlayer.getColor() == PieceColor.BLACK) return blackPlayer;
//        else return whitePlayer;
//    }
//
//    public Player getWhitePlayer(){
//        if(blackPlayer.getColor() == PieceColor.WHITE) return blackPlayer;
//        else return whitePlayer;
//    }
}
