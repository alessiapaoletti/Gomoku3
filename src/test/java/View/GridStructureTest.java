package test.java.View;
import Model.PieceColor;
import View.GridStructure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
public class GridStructureTest {

    private final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\033[1;90m";

    private GridStructure mygrid=new GridStructure(2);
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
        assertEquals(this.mygrid.pieces[1][1], PieceColor.EMPTY);
    };

    @Test
    public void createHorizontalNumbersTest(){
        this.mygrid.createHorizontalNumbers();
        assertEquals(ANSI_PURPLE+"   0    1    2    3    4    5    6    7    8    9  "+ANSI_RESET+"\n",outContent.toString());
    };

    @Test
    public void createHorizontalLinesTest(){
        this.mygrid.createHorizontalLines(1);
        assertEquals(ANSI_PURPLE+"1"+"  " +ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"-----"+ANSI_RESET+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"-"+ANSI_RESET+"\n",outContent.toString());
    };

    @Test
    public void createVerticalLinesTest(){
        this.mygrid.createVerticalLines();
        assertEquals("   "+ANSI_PURPLE+ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"|    |"+ANSI_RESET+"\n",outContent.toString());
    };
}