package Model;

public class GomokuOm extends GomokuGame {

    @Override
    public void initGame() {
        System.out.println("Mode Omok");
        System.out.println("Opening Rules:" + getOpeningRulesName());
        openingRules =new Opening(getP1(),getP2(), getOpeningRulesName());
        invalidMoves =new InvalidMoves();
    }

    @Override
    public void setInvalidMoves(int dim) {
        invalidMoves.SetDimBoard(dim);
        invalidMoves.setPlayers(super.getBlackPlayer(),super.getWhitePlayer());
        invalidMoves.threeAndThree();
    }

    @Override
    public String getGameName(){return "Omok";}

}
