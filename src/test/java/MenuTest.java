import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by sspecht on 1/15/17.
 */
public class MenuTest {
    private Menu menu;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Library library;


    @Before
    public void setUp()
    {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        menu = new Menu(printStream, bufferedReader, library);

    }


    @Test
    public void shouldListOptions()
    {
        menu.listOptions();
        verify(printStream).println("Options\n1. List Books\n2. Quit");
    }

    @Test
    public void shouldDisplayMessageAskingForOptionNumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.askForOption();
        verify(printStream).println("Enter an option number:");
    }

    @Test
    public void shouldGetUsersMenuChoiceWhenUserEntersOptionNumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.askForOption();
        assertThat(menu.askForOption(), is("1"));

    }

    @Test
    public void shouldDisplayInvalidInputWhenUserSelectsAnOptionNotOnTheMenu() throws IOException {
        menu.displayInvalidInput();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReturnFalseWhenUserEntersInvalidInput() throws IOException {
        Boolean userInput = menu.isValidInput("INVALID");

        assertThat(userInput, is(false));
    }

    @Test
    public void shouldReturnTrueWhenUserEntersValidInput() throws IOException {
        Boolean userInput = menu.isValidInput("1");

        assertThat(userInput, is(true));
    }

    @Test
    public void shouldAskUserForInputAgainIfInvalidInputEntered() throws IOException {
        when(bufferedReader.readLine()).thenReturn("9").thenReturn("1");
        menu.askForOption();
        verify(bufferedReader,times(2)).readLine();
    }

    @Test
    public void shouldListBooksWhenUserEntersOption1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.selectOption();
        verify(library).displayAllBooks();
    }

    @Test
    public void shouldQuitWhenUserEntersOption2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        menu.selectOption();
        verify(printStream).println("Bye!");
    }

    @Test
    public void shouldContinueDisplayingOptionsUntilOption2Sleceted() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        menu.selectOption();
        verify(bufferedReader,times(2)).readLine();
    }

}