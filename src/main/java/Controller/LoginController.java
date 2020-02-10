package Controller;

import Model.GomokuGame.GomokuType;
import Model.Player.WhitePlayer;
import Model.Player.BlackPlayer;
import Model.Rules.Opening.OpeningType;
import View.LoginView;


class LoginController {

    private LoginView loginView = new LoginView();

    LoginController() {}

    void startGame() {
        BlackPlayer blackPlayer = new BlackPlayer(loginView.setBlackPlayer());
        WhitePlayer whitePlayer = new WhitePlayer(loginView.setWhitePlayer());
        GomokuType gomokuType = loginView.setGame();
        OpeningType openingType = loginView.setOpening();

        BoardController boardController = new BoardController(blackPlayer, whitePlayer, gomokuType, openingType);
        boardController.callGame();
    }
}