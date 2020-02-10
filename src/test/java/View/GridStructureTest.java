package View;

import Model.Piece.PieceColor;
import com.sun.javafx.PlatformUtil;
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
    private final String ANSI_PURPLE1 = "\u001B[95m";

    private GridStructure gridStructure =new GridStructure(2);
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
    public void constructorTest(){
        assertEquals(this.gridStructure.pieces[1][1], PieceColor.EMPTY);
    }

    @Test
    public void createHorizontalNumbersTest(){
        this.gridStructure.createHorizontalNumbers();
        //assertEquals(ANSI_PURPLE+"   0    1    2    3    4    5    6    7    8    9  " + ANSI_RESET +
                //specialCharacter + "\n", outContent.toString());
    }

    @Test
    public void createHorizontalLinesTest(){
        this.gridStructure.createHorizontalLines(1);
        //assertEquals(ANSI_PURPLE + "1" + "  " + ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "-----" + ANSI_RESET +
                //ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "-" + ANSI_RESET + specialCharacter + "\n", outContent.toString());
    }

    @Test
    public void createVerticalLinesTest(){
        this.gridStructure.createVerticalLines();
        //assertEquals("   "+ ANSI_PURPLE + ANSI_PURPLE_BACKGROUND + ANSI_PURPLE1 + "|    |" +
               // ANSI_RESET + specialCharacter + "\n", outContent.toString());
    }
}