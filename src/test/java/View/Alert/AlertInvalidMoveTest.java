package View.Alert;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlertInvalidMoveTest {


    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AlertInvalidMove alertInvalidMove = new AlertInvalidMove();

    @Test
    public void invalidMoveAlertTest() {

        System.setOut(new PrintStream(outContent));

        alertInvalidMove.invalidMoveAlert();

        String expected = ANSI_RED+"ERROR -Invalid Move "+ANSI_RESET + new String(Character.toChars(0x1F6AB))+"\n";

        assertThat(outContent.toString(), is(expected));

    }
}
