package Model.Rules.Opening;

import Controller.AlertControllerInterface;
import Controller.GameStatusControllerInterface;
import Model.BlackPlayer;
import Model.WhitePlayer;

public abstract class Opening {

    BlackPlayer blackPlayer;
    WhitePlayer whitePlayer;
    OpeningType openingType;
    int numMoves;
    AlertControllerInterface alertControllerInterface;
    GameStatusControllerInterface gameStatusControllerInterface;

    public Opening(){ }

    public void setGameStatusControllerInterface(GameStatusControllerInterface gameStatusControllerInterface) {
        this.gameStatusControllerInterface = gameStatusControllerInterface;
    }

    protected void SwapLabel(){
        this.gameStatusControllerInterface.swapLabel();
    }

    public void setPlayers(BlackPlayer blackPlayer, WhitePlayer whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public int getNumMoves(){ return this.numMoves; }

    public void callOpening(AlertControllerInterface alertControllerInterface, GameStatusControllerInterface g){
        this.alertControllerInterface = alertControllerInterface;
        this.gameStatusControllerInterface = g;
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
