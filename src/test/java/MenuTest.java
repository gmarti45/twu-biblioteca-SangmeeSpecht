import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by sspecht on 1/15/17.
 */
public class MenuTest {
    private Menu menu;
    private PrintStream printStream;
    private BufferedReader bufferedReader;


    @Before
    public void setUp()
    {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menu = new Menu(printStream, bufferedReader);

    }


    @Test
    public void shouldListOptions()
    {
        menu.listOptions();
        verify(printStream).println("Options\n1. List Books");
    }

    @Test
    public void shouldDisplayMessageAskingForOptionNumber() throws IOException {
        menu.askForOption();
        verify(printStream).println("Enter an option number:");
    }

    @Test
    public void shouldGetUsersMenuChoiceWhenUserEntersOptionNumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.askForOption();
        assertThat(menu.askForOption(), is("1"));

    }


}