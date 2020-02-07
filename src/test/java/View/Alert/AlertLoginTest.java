package View.Alert;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AlertLoginTest {

    private AlertLogin alertLogin = new AlertLogin();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String STAR = "*****************";


    @Test
    public void alertLoginTest() {
        AlertLogin alertLoginTest = new AlertLogin();
        assertThat(alertLoginTest.getGomokuTypes().get(0), is(GomokuType.Standard));
        assertThat(alertLoginTest.getGomokuTypes().get(1), is(GomokuType.Omok));
        assertThat(alertLoginTest.getGomokuTypes().get(2), is(GomokuType.Freestyle));

        assertThat(alertLoginTest.getOpeningTypes().get(0), is(OpeningType.Standard));
        assertThat(alertLoginTest.getOpeningTypes().get(1), is(OpeningType.Swap));
        assertThat(alertLoginTest.getOpeningTypes().get(2), is(OpeningType.Swap2));
    }

    @Test
    public void loginAlertTest() {
        System.setOut(new PrintStream(outContent));

        this.alertLogin.loginAlert();

        String expected = ANSI_RED + "invalid selected type!" + ANSI_RESET +"\n";

        assertThat(outContent.toString(), is(expected));
    }

    @Test
    public void welcomePrintTest() {
        System.setOut(new PrintStream(outContent));

        this.alertLogin.welcomePrint();

        String expected = ANSI_PURPLE + STAR +" WELCOME IN GOMOKU "+ STAR + ANSI_RESET +
                "\n" + ANSI_PURPLE+STAR +"   Game Setting  "+ STAR + ANSI_RESET +"\n";

        assertThat(outContent.toString(), is(expected));
    }

    @Test
    public void setBlackPlayerTest() {
        System.setOut(new PrintStream(outContent));

        this.alertLogin.setBlackPlayer();

        String expected = "Black Player Name: \n";

        assertThat(outContent.toString(), is(expected));
    }

    @Test
    public void setWhitePlayerTest() {
        System.setOut(new PrintStream(outContent));

        this.alertLogin.setWhitePlayer();

        String expected = "White Player Name: \n" ;

        assertThat(outContent.toString(), is(expected));
    }

    @Test
    public void setOpeningTest() {
        System.setOut(new PrintStream(outContent));

        this.alertLogin.setOpening();
        String expected = "Choose your favorite Opening Rule between: \nStandard\nSwap\nSwap2\n";

        assertThat(outContent.toString(), is(expected));
    }

    @Test
    public void setGame() {
        System.setOut(new PrintStream(outContent));
        this.alertLogin.setGame();

        String expected = "Choose your favorite version of Gomoku between: \nStandard\nOmok\nFreestyle\n";

        assertThat(outContent.toString() , is(expected));
    }


}
