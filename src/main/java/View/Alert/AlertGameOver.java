package View.Alert;

public class AlertGameOver extends AlertGenerator {

    public  void gameOverAlert( String ... winner){
        System.out.println(new String(Character.toChars(0x1F389))+ANSI_RED + " Game Over  "+ ANSI_RESET+new String(Character.toChars(0x1F389)));
        if (winner.length > 0)
            System.out.println(ANSI_RED + "The winner is " + winner[0] + ANSI_RESET);
        else
            System.out.println(ANSI_RED+"The board is full: game ended with no winner" + ANSI_RESET);
    }
}
