package Model;

import Model.Rules.InvalidMoves;
import Model.Rules.Opening;

import static Model.Rules.OpeningFactory.getOpening;

public class GomokuOm extends GomokuGame {

    @Override
    public void initGame() {
        System.out.println("Mode Omok");
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules = getOpening(getOpeningRulesName());
        openingRules.setPlayer1(getP1());
        openingRules.setPlayer2(getP2());
        invalidMoves =new InvalidMoves();
    }

    @Override
    public void setInvalidMoves(int dim) {
        invalidMoves.setDimBoard(dim);
        invalidMoves.setPlayers(super.getBlackPlayer(),super.getWhitePlayer());
        invalidMoves.threeAndThree();
    }

    @Override
    public String getGameName(){return "Omok";}

}
