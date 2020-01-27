package Model.GomokuGame;
import Model.Rules.Closing.NoOverlines;
import Model.Rules.InvalidMoves;

public class GomokuOm extends GomokuGame {

    private InvalidMoves invalidMoves;

    GomokuOm(){
        this.gameType = GomokuType.Omok;
        this.gridSize = 18;
        this.invalidMoves = new InvalidMoves();
        invalidMoves.setDimBoard(this.gridSize);
    }

    @Override
    public void setRules() {
        this.closing = new NoOverlines();
        this.closing.setPlayers(this.getBlackPlayer(),this.getWhitePlayer());
    }

    @Override
    public void checkInvalidMoves() throws Error {
        this.invalidMoves.setPlayers(super.getBlackPlayer(),super.getWhitePlayer());
        this.invalidMoves.threeAndThree();
    }


}
