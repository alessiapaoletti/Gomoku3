package Model.Rules.Opening;

import Model.BlackPlayer;
import Model.WhitePlayer;

public abstract class Opening {

    BlackPlayer blackPlayer;
    WhitePlayer whitePlayer;
    OpeningType openingType;
    int numMoves;

    public Opening(){ }

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(){
        this.openingBehaviour();
    }

    public abstract void openingBehaviour();

    public OpeningType getOpeningType(){ return this.openingType;}

    public BlackPlayer getBlackPlayer() {
        return this.blackPlayer;
    }

    public WhitePlayer getWhitePlayer() {
        return this.whitePlayer;
    }
}
