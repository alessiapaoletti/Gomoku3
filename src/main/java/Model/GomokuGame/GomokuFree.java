package Model.GomokuGame;

import Model.Rules.Closing.Overlines;

public class GomokuFree extends GomokuGame{

    GomokuFree(){
        this.gameType = GomokuType.Freestyle;
        this.gridSize = 14;
    }

    @Override
    public void setRules() {
        this.closing = new Overlines();
        this.closing.setPlayers(this.getBlackPlayer(),this.getWhitePlayer());
    }

    @Override
    public void checkInvalidMoves() { }
}
