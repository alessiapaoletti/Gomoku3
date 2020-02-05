package ControllerCL;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.WhitePlayer;
import View.Alert.*;
import ViewCL.LoginView;
import Model.Rules.Opening.OpeningType;
import ControllerCL.BoardController;
import main.java.ControllerCL.GameStatusController;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private LoginView myview = new LoginView();

    public LoginController() {
    }

    public void startGame() {
        BlackPlayer blackPlayer = new BlackPlayer(myview.SetBlackPlayer());
        WhitePlayer whitePlayer = new WhitePlayer(myview.SetWhitePlayer());
        GomokuType gomokuType = myview.SetGame();
        OpeningType openingType = myview.SetOpening();
        BoardController boardController = new BoardController(blackPlayer, whitePlayer, gomokuType, openingType);
        boardController.StartGame();
    };
}