package ControllerCL;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;
import ViewCL.GameStatusView;

public class GameStatusController implements GameStatusControllerInterface {

    private GameStatusView gameStatusView;

    public GameStatusController(BlackPlayer p1, WhitePlayer p2, GomokuType gomokuType, OpeningType openingType){
        this.gameStatusView = new GameStatusView(p1, p2, gomokuType, openingType);
    }

    public void start(){
        this.gameStatusView.initBackGround();
    }

    public void swapLabel(){
        this.gameStatusView.swapColors();
    }

}
