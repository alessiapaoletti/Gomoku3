package View.Alert;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import Controller.GameScanner;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class AlertSwapTest {

    private AlertSwap alertSwap = new AlertSwap();

    @After
    public void restoreStreams() {
        System.setIn(System.in);
    }

    @Test
    public void checkYesNoAnswerTest() {
        String answer = "hello";
        assertFalse(alertSwap.checkYesNoAnswer(answer));
    }

    @Test
    public void checkSwap2AnswerTest() {
        String answer  = "2";
        assertTrue(alertSwap.checkSwap2Answer(answer));
    }

    @Test
    public void generateYesNoAlertTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("YES".getBytes()));
        assertThat(alertSwap.generateYesNoAlert("Answer YES/NO"),is("YES"));
    }

    @Test
    public void generateSwapAlertTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));
        assertThat(alertSwap.generateSwapAlert("choose the option 1, 2 or 3"), is("2"));
    }

    @Test
    public void swapAlertTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("YES".getBytes()));
        assertThat(alertSwap.swapAlert("white player"),is("YES"));
    }

    @Test
    public void swapBlackTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("YES".getBytes()));
        assertThat(alertSwap.swapAlert("black player"),is("YES"));
    }

    @Test
    public void swap2AlertTest() {
        GameScanner.scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));
        assertThat(alertSwap.swap2Alert("white player"), is("2"));
    }
}
