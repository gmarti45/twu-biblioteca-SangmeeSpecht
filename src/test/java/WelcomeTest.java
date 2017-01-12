import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class WelcomeTest {
    private PrintStream printStream;
    private Book book;

    @Test
    public void displaysAWelcomeMessageWhenProgramStarts() {
        printStream = mock(PrintStream.class);
        Welcome welcomeMessage = new Welcome(printStream);
        welcomeMessage.displayWelcomeMessage();
        verify(printStream).println("Welcome to the Biblioteca!!!!!!");
    }
}