package Model.GomokuGame;

import static Model.Rules.Opening.OpeningFactory.getOpening;

public class GomokuStd extends GomokuGame {

    GomokuStd(){}

    @Override
    public void initGame() {

        openingRules = getOpening(getOpeningRulesName());
        openingRules.setPlayer1(getP1());
        openingRules.setPlayer2(getP2());
    }

    @Override
    public void setInvalidMoves(int dim){}

    @Override
    public String getGameName(){return "Standard";}
}
