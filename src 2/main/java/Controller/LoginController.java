package Controller;

import Model.Player.*;
import Model.GomokuGame.GomokuType;
import View.LoginView;
import Model.Rules.Opening.OpeningType;

public class LoginController {

    private LoginView loginView = new LoginView();

    public LoginController() {};

    public void startGame() {
        BlackPlayer blackPlayer = new BlackPlayer(loginView.setBlackPlayer());
        WhitePlayer whitePlayer = new WhitePlayer(loginView.setWhitePlayer());
        GomokuType gomokuType = loginView.setGame();
        OpeningType openingType = loginView.setOpening();
        BoardController boardController = new BoardController(blackPlayer, whitePlayer, gomokuType, openingType);
        boardController.callGame();
    }
}