package View;

import Controller.GameScanner;
import View.Alert.AlertLogin;
import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    public AlertLogin alertLogin = new AlertLogin();

    public LoginView(){
        alertLogin.welcomePrint();
    }

    public String setBlackPlayer(){
        alertLogin.setBlackPlayer();
        return GameScanner.scanner.next();
    }

    public String setWhitePlayer(){
        alertLogin.setWhitePlayer();
        return GameScanner.scanner.next();
    }

    public GomokuType setGame(){
        alertLogin.setGame();
        try {
            return GomokuType.valueOf(GameScanner.scanner.next());
        } catch (IllegalArgumentException e){
          alertLogin.loginAlert();
          return this.setGame();
        }
    }

    public OpeningType setOpening(){
        alertLogin.setOpening();
        try {
            return OpeningType.valueOf(GameScanner.scanner.next());
        } catch (IllegalArgumentException e) {
            alertLogin.loginAlert();
            return this.setOpening();
        }
    }
}
