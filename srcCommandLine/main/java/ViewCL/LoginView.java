package ViewCL;

import ViewCL.Alert.AlertLogin;
import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    private AlertLogin login=new AlertLogin();

    public LoginView(){
        login.welcomePrint();
    }

    public String setBlackPlayer(){
        login.setBlackPlayer();
        return new Scanner(System.in).next();
    }

    public String setWhitePlayer(){
        login.setWhitePlayer();
        return new Scanner(System.in).next();
    }

    public GomokuType setGame(){
        login.setGame();
        try {
            return GomokuType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
          login.loginAlert();
          return this.setGame();
        }
    }

    public OpeningType setOpening(){
        login.setOpening();
        try {
            return OpeningType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
            login.loginAlert();
            return this.setOpening();
        }
    }

}
