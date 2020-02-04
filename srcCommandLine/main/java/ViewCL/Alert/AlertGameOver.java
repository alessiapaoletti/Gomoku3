package ViewCL.Alert;

import ViewCL.Alert.AlertGenerator;

public class AlertGameOver extends AlertGenerator {

    public  String gameOverAlert( String ... winner){
        System.out.println(ANSI_RED+"Game Over"+ANSI_RESET);
        if (winner.length > 0)
            return  ANSI_RED+"The winner is " + winner[0]+ANSI_RESET;
        else
            return ANSI_RED+"The board is full: game ended with no winner"+ANSI_RESET;

    }
}
