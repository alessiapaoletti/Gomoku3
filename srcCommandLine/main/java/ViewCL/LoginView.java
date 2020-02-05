package ViewCL;

import ControllerCL.AlertController;
import Model.Rules.Opening.OpeningType;
import java.util.Scanner;
import Model.GomokuGame.GomokuType;

public class LoginView {

    private AlertController login=new AlertController();

    public LoginView(){
        login.callLoginWelcome();
    }

    public String setBlackPlayer(){
        login.callLoginBlack();
        return new Scanner(System.in).next();
    }

    public String setWhitePlayer(){
        login.callLoginWhite();
        return new Scanner(System.in).next();
    }

    public GomokuType setGame(){
        login.callLoginGame();
        try {
            return GomokuType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
          login.callLoginAlert();
          return this.setGame();
        }
    }

    public OpeningType setOpening(){
        login.callLoginOpening();
        try {
            return OpeningType.valueOf(new Scanner(System.in).next());
        }catch (IllegalArgumentException e){
            login.callLoginAlert();
            return this.setOpening();
        }
    }

}
