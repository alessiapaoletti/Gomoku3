package View;

import Controller.GameScanner;
import Model.Piece.PieceColor;
import com.sun.javafx.PlatformUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BoardViewTest {

    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private BoardView boardView;
    private  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private  PrintStream originalOut = System.out;

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
        this.boardView = new BoardView(1,"STANDARD");
        String expected = ANSI_PURPLE + "*".repeat(36) + "  STANDARD  " + "*".repeat(36) + ANSI_RESET +
                specialCharacter + "\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void setXTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));
        this.constructorTest();
        assertEquals(2,this.boardView.getX("BLACK"));
    }

    @Test
    public void setYTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));
        this.constructorTest();
        assertEquals(3,this.boardView.getY("WHITE"));
    }

    @Test(expected = NoSuchElementException.class)
    public void setXErrorTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Pippo".getBytes()));
        this.constructorTest();
        this.boardView.getX("BLACK");
    }

    @Test(expected = NoSuchElementException.class)
    public void askIntegerTest(){
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("Pippo".getBytes()));
        this.constructorTest();
        this.boardView.askInteger("BLACK","x");
    }

    @Test
    public void setPieceTest(){
        this.constructorTest();
        this.boardView.setPiece(1,2, PieceColor.BLACK);
        assertEquals(this.boardView.gridStructure.pieces[1][2], PieceColor.BLACK);
    }

    @Test
    public void removePieceTest(){
        this.constructorTest();
        this.boardView.setPiece(1,2, PieceColor.BLACK);
        this.boardView.removePiece(1,2);
        assertEquals(this.boardView.gridStructure.pieces[1][2], PieceColor.EMPTY);
    }

    @Test
    public void createboardTest(){
      this.constructorTest();
      this.boardView.setPiece(0,0,PieceColor.WHITE);
      this.boardView.createBoard();
        String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        String ANSI_WHITE = "\033[0;30m";
        String ANSI_PURPLE1 = "\u001B[95m";
        String res = ANSI_PURPLE + "*".repeat(36) +"  STANDARD  " + "*".repeat(36) + ANSI_RESET +
                specialCharacter + "\n" + "\n"  +specialCharacter+ "\n" +
                ANSI_PURPLE + "      0    1" + ANSI_RESET  + specialCharacter + "\n" +
              ANSI_PURPLE +  "  0 "+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "--" + ANSI_WHITE + ANSI_PURPLE_BACKGROUND + "X" + ANSI_PURPLE1 + "--" +
                ANSI_RESET + ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "----" + ANSI_RESET   + specialCharacter + "\n" +
                "    " + ANSI_PURPLE +  ANSI_PURPLE_BACKGROUND + " " + ANSI_PURPLE1 + " |    | "+ ANSI_RESET + specialCharacter +  "\n" +
                ANSI_PURPLE + "  1 " +  ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "-----" + ANSI_RESET + ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "----" + ANSI_RESET +
                specialCharacter + "\n";
      assertEquals(res,outContent.toString());
    }
}