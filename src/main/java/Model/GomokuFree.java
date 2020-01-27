package Model;

import Model.Rules.InvalidMoves;

import static Model.Rules.OpeningFactory.getOpening;

public class GomokuFree extends GomokuGame{

    @Override
    public void initGame() {

        System.out.println("Mode Free");
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules = getOpening(getOpeningRulesName());
        openingRules.setPlayer1(this.getP1());
        openingRules.setPlayer2(this.getP2());
        invalidMoves =new InvalidMoves();
    }

    @Override
    public void setInvalidMoves(int dim) {}

    @Override
    public String getGameName(){return "Freestyle";}
}
