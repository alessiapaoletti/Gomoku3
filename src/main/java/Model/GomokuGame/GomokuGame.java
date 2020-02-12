package Model.GomokuGame;

import Model.Rules.Closing.Closing;
import Model.Rules.Opening.Opening;
import Model.Rules.Opening.OpeningFactory;
import Model.Rules.Opening.OpeningType;
import Model.Player.WhitePlayer;
import Model.Player.BlackPlayer;

public abstract class GomokuGame {

    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;
    int gridSize;
    Closing closing;
    private Opening openingRules;

    public GomokuGame(){ }

    public abstract void setRules();
    public abstract void checkInvalidMoves();

    public void setGameEnvironment(OpeningType openingType){
        this.openingRules = new OpeningFactory().getOpening(openingType);
        this.openingRules.setPlayers(getBlackPlayer(), getWhitePlayer());
        this.setRules();
    }

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public BlackPlayer getBlackPlayer() { return this.blackPlayer; }

    public WhitePlayer getWhitePlayer() { return this.whitePlayer; }

    public int getGridSize() { return gridSize; }

    public Closing getClosing(){return this.closing; }

    public Opening getOpeningRules() {return this.openingRules; }

}
