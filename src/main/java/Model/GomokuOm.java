package Model;

public class GomokuOm extends GomokuGame {

    @Override
    public void initGame() {


        System.out.println("Mode Omok");
        //System.out.println("Players:" + getP1().getName() + " and " + getP2().getName() + " initial bets = " + getnBet() + " grDim= " + getGridDim());
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules =new Opening(getP1(),getP2(), getOpeningRulesName());
        invalidMoves =new InvalidMoves(getP1(),getP2());
    }

    @Override
    public void setInvalidMoves() {
        invalidMoves.threeAndThree();
        //inv.three_and_three(2);
    }

    @Override
    public String getGameName(){return "Omok";}
}
