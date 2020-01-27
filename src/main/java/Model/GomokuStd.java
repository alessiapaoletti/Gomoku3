package Model;

import Model.Rules.Opening;

import static Model.Rules.OpeningFactory.getOpening;

public class GomokuStd extends GomokuGame {

    GomokuStd(){}

    @Override
    public void initGame() {
        System.out.println("Mode standard");
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules = getOpening(getOpeningRulesName());
        openingRules.setPlayer1(getP1());
        openingRules.setPlayer2(getP2());
    }

    @Override
    public void setInvalidMoves(int dim){}

    @Override
    public String getGameName(){return "Standard";}
}
