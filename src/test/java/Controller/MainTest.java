package Controller;

import org.junit.After;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;

public class MainTest {

    @After
    public void restoreStreams() {
        System.setIn(System.in);
    }

    @Test
    public void fullGame1Test() throws IOException {
        /*Standard Game - Standard Opening */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game1.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame2Test() throws IOException {
        /*Freestyle Game - Standard Opening */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game2.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame3Test() throws IOException {
        /*Standard Game - Swap Opening (YES answer) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game3.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame4Test() throws IOException {
        /*Omok Game (Invalid Move)  - Swap Opening (NO answer) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game4.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame5Test() throws IOException {
        /*Standard  - Swap2 (option1) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game5.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame6Test() throws IOException {
        /*Standard  - Swap2 (option2) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game6.txt")));
        Main.main(null);
    }


    @Test
    public void fullGame7Test() throws IOException {
        /*Standard  - Swap2 (option3) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game7.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame8Test() throws IOException {
        /*Standard  - Swap2 (option3) */
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/game8.txt")));
        Main.main(null);
    }

    @Test
    public void fullGame9Test() throws IOException {
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/gameFullBoard.txt")));
        Main.main(null);
    }
    @Test
    public void fullGame10Test() throws IOException {
        GameScanner.scanner = new Scanner(new FileInputStream(new File("src/test/GameConfigurations/gameFullBoardWin.txt")));
        Main.main(null);
    }
}