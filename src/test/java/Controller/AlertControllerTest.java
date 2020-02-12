package Controller;

import Model.Rules.Opening.OpeningType;
import com.sun.javafx.PlatformUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AlertControllerTest {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private AlertControllerInterface alertinterface= new AlertController();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    private  InputStream originalIn = System.in;

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
        System.setIn(originalIn);

    }

    @Test
    public void constructorTest(){
        assertEquals("class Controller.AlertController", this.alertinterface.getClass().toString());
    }

    @Test
    public void swapAlertTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("YES".getBytes()));
        assertEquals("YES",this.alertinterface.swapAlert("white player"));
    }

    @Test
    public void swapBlackTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("NO".getBytes()));
        assertEquals("NO", this.alertinterface.swapAlert("black player"));
    }

    @Test
    public void swap2AlertTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));
        assertEquals("2", this.alertinterface.swap2Alert("white Player"));
    }

    @Test(expected = NoSuchElementException.class)
    public void swapAlertErrorTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Pippo".getBytes()));
        this.alertinterface.swap2Alert("white player");
    }

    @Test
    public void callInvalidMoveErrorTest(){
        new AlertController().callInvalidMoveError();
        assertEquals(ANSI_RED +"ERROR -Invalid Move "+ ANSI_RESET + new String(Character.toChars(0x1F6AB)) + specialCharacter + "\n",
                outContent.toString());
    }

    @Test
    public void callGameOverAlertTest(){
        new AlertController().callGameOverAlert();
        assertEquals(new String(Character.toChars(0x1F389))+ANSI_RED + " Game Over  "+ ANSI_RESET +
                new String(Character.toChars(0x1F389)) + specialCharacter + "\n" + ANSI_RED +
                "The board is full: game ending with no winner." + ANSI_RESET + specialCharacter + "\n", outContent.toString());
    }

    @Test
    public void callGameOverAlertTest1() {
        new AlertController().callGameOverAlert("giorgio");
        assertEquals(new String(Character.toChars(0x1F389)) + ANSI_RED + " Game Over  " + ANSI_RESET +
                new String(Character.toChars(0x1F389)) + specialCharacter + "\n" + ANSI_RED +
                "The winner is giorgio" + ANSI_RESET + specialCharacter + "\n", outContent.toString());
    }

    @Test
    public void callGetAlertOpeningTest(){
        new AlertController().callGetAlertOpening(OpeningType.Swap);

        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_PURPLE1 = "\u001B[95m";
        assertEquals(ANSI_PURPLE + "* SWAP opening - Rules *\n" +
                ANSI_PURPLE1 + "BLACK player places 3 stones: 2 black and 1 white.\n" +
                "Then WHITE player can decide to swap color or stay white.\n" +"The player will then proceed placing 1 stone each."+
                ANSI_RESET + specialCharacter + "\n", outContent.toString());
    }

    @Test
    public void callInvalidCoordinateErrorTest(){
        new AlertController().callInvalidCoordinateError("14");
        assertEquals(ANSI_RED + "ERROR -Invalid Coordinate " + "\n" +
                "(Insert a couple of numbers in range [0,14],not already on the board)" +  ANSI_RESET +
                new String(Character.toChars(0x1F6AB)) + specialCharacter + "\n", outContent.toString());
    }

}