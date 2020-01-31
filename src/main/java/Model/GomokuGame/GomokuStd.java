package Model.GomokuGame;

import Model.Rules.Closing.NoOverlines;

class GomokuStd extends GomokuGame {

    GomokuStd(){
       this.gameType = GomokuType.Standard;
       this.gridSize = 14;
    }

    @Override
    public void setRules() {
        this.closing = new NoOverlines();
        this.closing.setPlayers(this.getBlackPlayer(),this.getWhitePlayer());
//        System.out.println("dento standard");
//        System.out.println(getBlackPlayer().getName() + " " + getBlackPlayer().getColorName());
//        System.out.println(getWhitePlayer().getName() + " " + getWhitePlayer().getColorName());
        //this.closing.setPlayers(this.getOpeningRules().getBlackPlayer(),this.getOpeningRules().getWhitePlayer());
    }

    @Override
    public void checkInvalidMoves() {
        //this.closing.setPlayers(this.getOpeningRules().getBlackPlayer(),this.getOpeningRules().getWhitePlayer());
    }
}
