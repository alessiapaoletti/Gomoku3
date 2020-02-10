package View;

import Model.Player.WhitePlayer;
import Model.Player.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import com.sun.javafx.PlatformUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class GameStatusViewTest {

    private GameStatusView gameStatusView = new GameStatusView(new BlackPlayer("mario"),
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
    public void initLabelAndBackgroundTest(){
        this.gameStatusView.initBackGround();
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";
        String STAR = "*";
        String SPACE = " ";
        String res = "\n" + ANSI_PURPLE + STAR.repeat(40) + ANSI_RESET + specialCharacter + "\n"+ ANSI_PURPLE +"mario"+
                SPACE.repeat(6) +"BLACK" + ANSI_RESET + specialCharacter + "\n" + ANSI_PURPLE + "giulia" + SPACE.repeat(6) +
                "WHITE"+ ANSI_RESET + specialCharacter +  "\n" + ANSI_PURPLE + "Game:  Standard"+ ANSI_RESET + specialCharacter + "\n"+
                ANSI_PURPLE + "Opening rules:  Standard" + ANSI_RESET + specialCharacter + "\n";
        assertEquals(res, outContent.toString());
    }

    @Test
    public void swapColorsTest(){
        this.gameStatusView.swapColors();
        assertEquals(this.gameStatusView.color1, "WHITE");
        assertEquals(this.gameStatusView.color2, "BLACK");
    }
}