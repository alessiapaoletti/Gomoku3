package test.java.View;

import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.PieceColor;
import Model.Rules.Opening.OpeningType;
import Model.WhitePlayer;
import View.GameStatusView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameStatusViewTest {

    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String STAR = "***********************";
    private final String SPACE= "      ";

    private GameStatusView mygamestatus=new GameStatusView(new BlackPlayer("mario"),new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void initLabel_and_Background_Test(){
        this.mygamestatus.initBackGround();
        String res="\n"+ANSI_PURPLE+STAR+ANSI_RESET+"\n"+ANSI_PURPLE+"mario"+SPACE+"BLACK"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"giulia"+SPACE+"WHITE"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"Game:  Standard"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"Opening rules:  Standard"+ANSI_RESET+"\n";
        assertEquals(res,outContent.toString());
    };

    @Test
    public void swapColorsTest(){
        this.mygamestatus.swapColors();
        assertEquals(this.mygamestatus.color1, "WHITE");
        assertEquals(this.mygamestatus.color2, "BLACK");

    };
}