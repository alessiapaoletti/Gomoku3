package View;

import Model.Piece.PieceColor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class BoardViewTest {

    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private BoardView myBoardView;
    private  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private  PrintStream originalOut = System.out;

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
        this.myBoardView = new BoardView(1,"STANDARD");
        String expeted = ANSI_PURPLE+"**********************************  STANDARD  **********************************"+ANSI_RESET+"\r\n";
        assertEquals(expeted, outContent.toString());
    }

    @Test
    public void setXTest(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        this.constructorTest();
        assertEquals(2,this.myBoardView.getX("BLACK"));
        System.setIn(sysInBackup);
    }

    @Test
    public void setYTest(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        this.constructorTest();
        assertEquals(3,this.myBoardView.getY("WHITE"));
        System.setIn(sysInBackup);
    }

    @Test(expected = NoSuchElementException.class)
    public void setXErrorTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("g".getBytes());
        System.setIn(in);
        this.constructorTest();
        this.myBoardView.getX("BLACK");
        System.setIn(sysInBackup);
    }


    @Test
    public void setPieceTest(){
        this.constructorTest();
        this.myBoardView.setPiece(1,2, PieceColor.BLACK);
        assertEquals(this.myBoardView.gridStructure.pieces[1][2], PieceColor.BLACK);
    }

    @Test
    public void removePieceTest(){
        this.constructorTest();
        this.myBoardView.setPiece(1,2, PieceColor.BLACK);
        this.myBoardView.removePiece(1,2);
        assertEquals(this.myBoardView.gridStructure.pieces[1][2], PieceColor.EMPTY);
    }

    @Test
    public void createboardTest(){
      this.constructorTest();
      this.myBoardView.setPiece(0,0,PieceColor.WHITE);
      this.myBoardView.createBoard();
        String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        String ANSI_WHITE = "\033[0;30m";
        String ANSI_PURPLE1 = "\u001B[95m";
        String res=ANSI_PURPLE+"**********************************  STANDARD  **********************************"+ANSI_RESET+"\n"+"\n"+"\r\n"+
              ANSI_PURPLE+"   0    1    2    3    4    5    6    7    8    9  "+ANSI_RESET+"\r\n"+
              ANSI_PURPLE+"0  "+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + ANSI_WHITE + ANSI_PURPLE_BACKGROUND +"X"+ ANSI_PURPLE1 +"----"+ANSI_RESET+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 +"-"+ANSI_RESET+"\r\n"+
              "   "+ANSI_PURPLE+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 +"|    |"+ANSI_RESET+"\r\n"+
              ANSI_PURPLE+"1  "+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 +"-----"+ANSI_RESET+ ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 +"-"+ANSI_RESET+"\r\n";
      //assertEquals(res,outContent.toString());
    }


}