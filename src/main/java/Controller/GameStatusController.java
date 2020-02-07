package Controller;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Player;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;
import View.GameStatusView;

public class GameStatusController implements GameStatusControllerInterface {

    private GameStatusView gameStatusView;
    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;
    private String currentPlayerName;

    public GameStatusController(BlackPlayer blackPlayer, WhitePlayer whitePlayer, GomokuType gomokuType, OpeningType openingType){
        this.gameStatusView = new GameStatusView(blackPlayer, whitePlayer, gomokuType, openingType);
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.currentPlayerName = blackPlayer.getName();
    }

    public void start(){
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

        System.out.println("black " + blackPlayer.getName());
        System.out.println("white " + whitePlayer.getName());
        System.out.println("curr " + currentPlayerName);

        this.maintainTurn();
    }

    public void maintainTurn(){
        this.gameStatusView.printTurn(this.currentPlayerName);
    }

}
