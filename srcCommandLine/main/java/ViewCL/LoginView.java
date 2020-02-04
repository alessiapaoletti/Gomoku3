package ViewCL;

import ViewCL.Alert.AlertLogin;

import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    private AlertLogin login=new AlertLogin();

    public LoginView(){
        login.Welcome();
    };

    public String SetBlackPlayer(){
        login.SetBlackPlayer();
        return new Scanner(System.in).next();
    };

    public String SetWhitePlayer(){
        login.SetWhitePlayer();
        return new Scanner(System.in).next();
    };

    public GomokuType SetGame(){
        login.SetGame();
        try {
            return GomokuType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
          login.loginAlert();
          return this.SetGame();
        }
    };

    public OpeningType SetOpening(){
        login.SetOpening();
        try {
            return OpeningType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
            login.loginAlert();
            return this.SetOpening();
        }
    };

}
