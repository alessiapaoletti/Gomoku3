package View.Alert;

import Model.Rules.Opening.OpeningType;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.sun.javafx.PlatformUtil;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AlertOpeningTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private AlertOpening alertOpening = new AlertOpening();
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_PURPLE1 = "\u001B[95m";

    /*needed to run the test according to the OS*/
    private boolean isWindows = PlatformUtil.isWindows();
    private String specialCharacter = this.isWindows ? "\r" : "";

    @Test
    public void alertOpeningConstructorTest() {
        AlertOpening alertOpeningTest = new AlertOpening();
        String expected = alertOpeningTest.stdOpeningRulesAlert();
        assertThat(alertOpeningTest.getAlertOpeningMap().get(OpeningType.Standard) , is(expected));
    }

    @Test
    public void stdOpeningRulesAlertTest() {

        String expected = ANSI_PURPLE + "* STANDARD opening - Rules * \n" +
                ANSI_PURPLE1 + "Black player starts and insert 1 stones followed by white player. \n" +
                "Stones can be placed anywhere." +
                ANSI_RESET;

        assertThat(alertOpening.stdOpeningRulesAlert(), is(expected));

    }

    @Test
    public void swapOpeningRulesAlertTest() {
        String expected = ANSI_PURPLE + "* SWAP opening - Rules *\n" +
                ANSI_PURPLE1 + "BLACK player places 3 stones: 2 black and 1 white.\n" +
                "Then WHITE player can decide to swap color or stay white.\n" +
                "The player will then proceed placing 1 stone each."+
                ANSI_RESET;

        assertThat(alertOpening.swapOpeningRulesAlert(), is(expected));
    }

    @Test
    public void swap2OpeningRulesAlertTest() {
        String expected = ANSI_PURPLE+"* SWAP2 opening - Rules *"+"\n"+ ANSI_PURPLE1+"BLACK player places 3 stones: 2 black and 1 white\n" +
                "then WHITE player can decide to: " +
                "- stay white,\n" +
                "- swap color,\n" +
                "- place 2 more stones (1 black and 1 white) and let the black player decide the wanted color";

        assertThat(alertOpening.swap2OpeningRulesAlert(), is(expected));
    }

    @Test
    public void getAlertOpeningTest() {
        System.setOut(new PrintStream(outContent));

        alertOpening.getAlertOpening(OpeningType.Standard);

        String expected = alertOpening.stdOpeningRulesAlert() + specialCharacter +"\n";
        assertThat(outContent.toString(), is(expected));

    }


}
