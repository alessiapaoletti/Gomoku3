package Controller;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.Player.WhitePlayer;
import Model.Player.BlackPlayer;
import com.sun.javafx.PlatformUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class BoardControllerTest {

    private BoardController myboardcontroller = new BoardController(new BlackPlayer("mario"), new WhitePlayer("giulia"),
            GomokuType.Standard, OpeningType.Standard);
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    /*needed to run the test according to the OS*/
    private boolean isWindows = PlatformUtil.isWindows();
    private String specialCharacter = this.isWindows ? "\r" : "";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testConstructor(){
        assertEquals("class Controller.GameStatusController", this.myboardcontroller.gameStatusController.getClass().toString());
    }

    @Test
    public void gameOverTest(){
        this.myboardcontroller.gameOver("giorgio");
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        assertEquals(new String(Character.toChars(0x1F389)) + ANSI_RED + " Game Over  " + ANSI_RESET +
                new String(Character.toChars(0x1F389)) + specialCharacter + "\n" + ANSI_RED +
                "The winner is giorgio" + ANSI_RESET + specialCharacter + "\n",outContent.toString());
    }

    @Test
    public void startOpeningTest(){
        this.myboardcontroller.startOpening();
        assertEquals("",outContent.toString());
    }

    @Test
    public void numMovesDone(){
        assertEquals(0,this.myboardcontroller.numMovesDone());
    }

}