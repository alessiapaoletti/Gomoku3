package ControllerCL;

import ControllerCL.LoginController;
import ControllerCL.BoardController;
import static ViewCL.LoginView.*;

public class Main {

    public static void main(String[] args) {
        LoginController login=new LoginController();
        login.startGame();


        /*
         *  //PRINT BLACK
         * String ANSI_WHITE = "\033[0;30m";
         * String ANSI_BLACK = "\033[1;90m";
         * System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"X"+ANSI_RESET);
         *  //PRINT WHITE
         * System.out.println(ANSI_WHITE+ANSI_PURPLE_BACKGROUND+"X"+ANSI_RESET);
         *
         * */

    }

}
