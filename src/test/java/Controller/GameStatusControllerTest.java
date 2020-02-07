package test.java.Controller;

import static org.junit.Assert.*;
import Controller.GameStatusControllerInterface;
import Controller.GameStatusController;
import Model.BlackPlayer;
import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import  Model.WhitePlayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.java.View.GameStatusViewTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameStatusControllerTest {

    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";

    private final String STAR = "***********************";
    private final String SPACE= "      ";

    private GameStatusControllerInterface mygamestatusint=new GameStatusController(new BlackPlayer("mario"),new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);
    private GameStatusController mygamestatusint1=new GameStatusController(new BlackPlayer("mario"),new WhitePlayer("giulia"), GomokuType.Standard, OpeningType.Standard);

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
    public void ConstructorTest(){
        assertEquals("class Controller.GameStatusController",this.mygamestatusint.getClass().toString());
    };

    @Test
    public void startTest(){
        this.mygamestatusint1.start();
        String res="\n"+ANSI_PURPLE+STAR+ANSI_RESET+"\n"+ANSI_PURPLE+"mario"+SPACE+"BLACK"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"giulia"+SPACE+"WHITE"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"Game:  Standard"+ANSI_RESET+"\n"+
                ANSI_PURPLE+"Opening rules:  Standard"+ANSI_RESET+"\n";
        assertEquals(res,outContent.toString());
    };


}