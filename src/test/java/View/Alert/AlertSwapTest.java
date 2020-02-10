package View.Alert;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AlertSwapTest {

    private AlertSwap alertSwap = new AlertSwap();

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
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("YES".getBytes());
        System.setIn(in);
        assertThat(alertSwap.generateYesNoAlert("Answer YES/NO"),is("YES"));
        System.setIn(sysInBackup);
    }

    @Test
    public void generateSwapAlertTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertThat(alertSwap.generateSwapAlert("choose the option 1, 2 or 3"), is("2"));
        System.setIn(sysInBackup);
    }

    @Test
    public void swapAlertTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("YES".getBytes());
        System.setIn(in);
        assertThat(alertSwap.swapAlert("white player"),is("YES"));
        System.setIn(sysInBackup);
    }

    @Test
    public void swapBlackTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("YES".getBytes());
        System.setIn(in);
        assertThat(alertSwap.swapBlack("black player"),is("YES"));
        System.setIn(sysInBackup);
    }

    @Test
    public void swap2AlertTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertThat(alertSwap.swap2Alert("white player"), is("2"));
        System.setIn(sysInBackup);
    }
}
