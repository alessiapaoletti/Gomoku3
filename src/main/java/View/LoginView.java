package View;

import View.Alert.AlertLogin;
import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    private AlertLogin alertLogin = new AlertLogin();

    public LoginView(){
        alertLogin.welcomePrint();
    }

    public String setBlackPlayer(){
        alertLogin.setBlackPlayer();
        return new Scanner(System.in).next();
    }

    public String setWhitePlayer(){
        alertLogin.setWhitePlayer();
        return new Scanner(System.in).next();
    }

    public GomokuType setGame(){
        alertLogin.setGame();
        try {
            return GomokuType.valueOf(new Scanner(System.in).next());
        } catch (IllegalArgumentException e){
          alertLogin.loginAlert();
          return this.setGame();
        }
    }

    public OpeningType setOpening(){
        alertLogin.setOpening();
        try {
            return OpeningType.valueOf(new Scanner(System.in).next());
        } catch (IllegalArgumentException e) {
            alertLogin.loginAlert();
            return this.setOpening();
        }
    }
}
