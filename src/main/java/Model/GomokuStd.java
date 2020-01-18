package Model;

public class GomokuStd extends GomokuGame {

    GomokuStd(){}

    @Override
    public void initGame() {
        currentPlayer = BoardLogic.BLACK_PLAYER;

        System.out.println("Mode standard");
        //System.out.println("Players:" + getP1().getName() + " and " + getP2().getName() + " initial bets = " + getnBet() + " grDim= " + getGridDim());
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules =new Opening(getP1(),getP2(), getOpeningRulesName());

    }

    @Override
    public void setInvalidMoves(){}

    @Override
    public String getGameName(){return "Standard";}
}
