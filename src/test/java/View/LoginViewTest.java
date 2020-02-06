package test.java.View;

import static org.junit.Assert.*;
import Model.GomokuGame.GomokuType;
import View.LoginView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class LoginViewTest {
    LoginView mylogin;

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_PURPLE1 = "\u001B[95m";
    final String ANSI_RED = "\u001B[31m";
    final String STAR = "*****************";
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
    public void LoginViewConstructorTest(){
        this.mylogin=new LoginView();
        assertEquals(ANSI_PURPLE + STAR +" WELCOME IN GOMOKU "+ STAR + ANSI_RESET+"\n"+ANSI_PURPLE+STAR +"   Game Setting  "+ STAR + ANSI_RESET+"\n",outContent.toString());
    };

    @Test
    public void setBlackPlayer(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Giulia".getBytes());
        System.setIn(in);
        this.LoginViewConstructorTest();
        assertEquals("Giulia",this.mylogin.setBlackPlayer());
        System.setIn(sysInBackup);
    };

    @Test
    public void setGameTest(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Omok".getBytes());
        System.setIn(in);
        this.LoginViewConstructorTest();
        assertEquals(GomokuType.Omok,this.mylogin.setGame());
        System.setIn(sysInBackup);
    };

    @Test(expected = NoSuchElementException.class)
        public void setGameErrorTest() {
            InputStream sysInBackup = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("g".getBytes());
            System.setIn(in);
            this.LoginViewConstructorTest();
            this.mylogin.setGame();
            System.setIn(sysInBackup);
        };
}