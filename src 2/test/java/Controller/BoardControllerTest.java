package test.java.Controller;


import Controller.BoardController;
import Model.Player.*;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BoardControllerTest {
    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RED = "\u001B[31m";

    private final String ANSI_RESET = "\u001B[0m";
    private BoardController myboardcontroller=new BoardController(new BlackPlayer("mario"),new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);

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
    public void TestConstructor(){
        assertEquals("class Controller.GameStatusController",this.myboardcontroller.gameStatusController.getClass().toString());
    };

    @Test
    public void gameOverTest(){
        this.myboardcontroller.gameOver("giorgio");
       assertEquals(new String(Character.toChars(0x1F389))+ANSI_RED + " Game Over  "+ ANSI_RESET+new String(Character.toChars(0x1F389)) + "\n" + ANSI_RED + "The winner is giorgio" + ANSI_RESET + "\n",outContent.toString());
    };

    @Test
    public void startOpeningTest(){
        this.myboardcontroller.startOpening();
        assertEquals("",outContent.toString());
    };

    @Test
    public void numMovesDone(){
        assertEquals(0,this.myboardcontroller.numMovesDone());
    };

}