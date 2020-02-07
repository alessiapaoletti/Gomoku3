package View.Alert;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AlertGameOverTest {

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AlertGameOver alertGameOver = new AlertGameOver();

    @Test
    public void gameOverAlertTest() {
        System.setOut(new PrintStream(outContent));

        alertGameOver.gameOverAlert();

        String expected = ANSI_RED + "Game Over" + ANSI_RESET +
                "\n"+ANSI_RED+ "The board is full: game ended with no winner" +  ANSI_RESET + "\n";
        assertThat(outContent.toString(), is(expected));

    }

    @Test
    public void gameOverAlertWinnerTest() {
        System.setOut(new PrintStream(outContent));
        String winner  =  "Player1";
        alertGameOver.gameOverAlert(winner);

        String expected = ANSI_RED + "Game Over" + ANSI_RESET +
                "\n"+ANSI_RED+ "The winner is "+ winner +  ANSI_RESET + "\n";

        assertThat(outContent.toString(), is(expected));
    }
}
