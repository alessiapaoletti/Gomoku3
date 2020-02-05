package ControllerCL;

import ControllerCL.LoginController;
import ControllerCL.BoardController;
import static ViewCL.LoginView.*;

public class Main {

    public static void main(String[] args) {
        LoginController login=new LoginController();
        login.startGame();


    }

}
