package Controller;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.Player.WhitePlayer;
import Model.Player.BlackPlayer;

import View.GameStatusView;

public class GameStatusController implements GameStatusControllerInterface {

    private GameStatusView gameStatusView;
    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;
    private String currentPlayerName;

    GameStatusController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType){
        this.gameStatusView = new GameStatusView(blackPlayer, whitePlayer, gomokuType, openingType);
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.currentPlayerName = blackPlayer.getName();
    }

    void start(){
        this.gameStatusView.initBackGround();
    }

    public void swapLabel(){
        this.gameStatusView.swapColors();
    }

    public void swapColorTurn(){

        if(this.currentPlayerName.equals(this.blackPlayer.getName())) {
            this.currentPlayerName = this.whitePlayer.getName();
        } else {
            this.currentPlayerName = this.blackPlayer.getName();
        }
        this.maintainTurn();
    }

    void maintainTurn(){
        this.gameStatusView.printTurn(this.currentPlayerName);
    }

}
