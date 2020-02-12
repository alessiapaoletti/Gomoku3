package View;

import static org.junit.Assert.*;

import Controller.GameScanner;
import Model.GomokuGame.GomokuType;
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

public class LoginViewTest {

    private LoginView loginView;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut = System.out;
    private InputStream originalIn = System.in;

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
    public void loginViewConstructorTest(){
        this.loginView =new LoginView();
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        String STAR = "*****************";
        assertEquals(ANSI_PURPLE + STAR + " WELCOME IN GOMOKU " + STAR + ANSI_RESET +
                specialCharacter + "\n" + ANSI_PURPLE + STAR + "   Game Setting  " + STAR + ANSI_RESET +
                specialCharacter + "\n",outContent.toString());
    }

    @Test
    public void setBlackPlayer(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Giulia".getBytes()));
        this.loginViewConstructorTest();
        assertEquals("Giulia", this.loginView.setBlackPlayer());
    }

    @Test
    public void setGameTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Omok".getBytes()));
        this.loginViewConstructorTest();
        assertEquals(GomokuType.Omok,this.loginView.setGame());
    }

    @Test(expected = NoSuchElementException.class)
        public void setGameErrorTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Pippo".getBytes()));
        this.loginViewConstructorTest();
        this.loginView.setGame();
    }
}