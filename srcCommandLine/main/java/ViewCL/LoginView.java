package ViewCL;

import ControllerCL.AlertController;
import ViewCL.Alert.AlertLogin;

import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    private AlertController login=new AlertController();

    public LoginView(){
        login.callLoginWelcome();
    };

    public String SetBlackPlayer(){
        login.callLoginBlack();
        return new Scanner(System.in).next();
    };

    public String SetWhitePlayer(){
        login.callLoginWhite();
        return new Scanner(System.in).next();
    };

    public GomokuType SetGame(){
        login.callLoginGame();
        try {
            return GomokuType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
          login.callLoginAlert();
          return this.SetGame();
        }
    };

    public OpeningType SetOpening(){
        login.callLoginOpening();
        try {
            return OpeningType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
            login.callLoginAlert();
            return this.SetOpening();
        }
    };

}
