package View.Alert;

import com.sun.javafx.PlatformUtil;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AlertInvalidMoveTest {


    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AlertInvalidMove alertInvalidMove = new AlertInvalidMove();

    /*needed to run the test according to the OS*/
    private boolean isWindows = PlatformUtil.isWindows();
    private String specialCharacter = this.isWindows ? "\r" : "";

    @Test
    public void invalidMoveAlertTest() {

        System.setOut(new PrintStream(outContent));

        alertInvalidMove.invalidMoveAlert();

        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String expected = ANSI_RED + "ERROR -Invalid Move " + ANSI_RESET + new String(Character.toChars(0x1F6AB)) + specialCharacter + "\n";

        assertThat(outContent.toString(), is(expected));

    }
}
