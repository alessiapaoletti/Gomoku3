package Controller;

import static org.junit.Assert.*;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import Model.Player.BlackPlayer;
import Model.Player.WhitePlayer;
import com.sun.javafx.PlatformUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameStatusControllerTest {

    private GameStatusControllerInterface gameStatusController = new GameStatusController(new BlackPlayer("mario"),
            new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);

    private GameStatusController gameStatusController1 = new GameStatusController(new BlackPlayer("mario"),
            new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);

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
    public void constructorTest(){
        assertEquals("class Controller.GameStatusController",this.gameStatusController.getClass().toString());
    }

    @Test
    public void startTest(){
        this.gameStatusController1.start();
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        String STAR = "*".repeat(40);
        String SPACE = " ";
        String res = "\n"+ ANSI_PURPLE + STAR + ANSI_RESET + specialCharacter + "\n"+ ANSI_PURPLE +"mario"+ SPACE.repeat(6) +"BLACK"+ ANSI_RESET +
                specialCharacter +"\n"+ ANSI_PURPLE +"giulia"+ SPACE.repeat(6) +"WHITE"+ ANSI_RESET + specialCharacter +"\n"+
                ANSI_PURPLE +"Game:  Standard"+ ANSI_RESET + specialCharacter +"\n"+
                ANSI_PURPLE +"Opening rules:  Standard"+ ANSI_RESET + specialCharacter +"\n";
        assertEquals(res,outContent.toString());
    }
}