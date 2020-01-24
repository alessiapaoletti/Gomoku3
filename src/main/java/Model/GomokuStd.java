package Model;

public class GomokuStd extends GomokuGame {

    GomokuStd(){}

    @Override
    public void initGame() {
        System.out.println("Mode standard");
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules =new Opening(getP1(),getP2(), getOpeningRulesName());

    }

    @Override
    public void setInvalidMoves(int dim){}

    @Override
    public String getGameName(){return "Standard";}
}
