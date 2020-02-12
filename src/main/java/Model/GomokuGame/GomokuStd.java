package Model.GomokuGame;

import Model.Rules.Closing.NoOverlines;

class GomokuStd extends GomokuGame {

    GomokuStd(){
       this.gridSize = 14;
    }

    @Override
    public void setRules() {
        this.closing = new NoOverlines();
        this.closing.setPlayers(this.getBlackPlayer(),this.getWhitePlayer());
    }

    @Override
    public void checkInvalidMoves() {
    }
}
