import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
    private Book book;
    private DisplayAllBooksCommand displayAllBooksCommand;
    private QuitCommand quitCommand;
    private CheckoutBookCommand checkoutBookCommand;
    private Map<String, Command> commandMap;


    @Before
    public void setUp()
    {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        book = mock(Book.class);
        displayAllBooksCommand = mock(DisplayAllBooksCommand.class);
        quitCommand = mock(QuitCommand.class);
        checkoutBookCommand = mock(CheckoutBookCommand.class);
        commandMap = new HashMap<String, Command>();
        commandMap.put("1", displayAllBooksCommand);
        commandMap.put("0", quitCommand);
        commandMap.put("2", checkoutBookCommand);


        menu = new Menu(printStream, bufferedReader, library, commandMap);

    }


    @Test
    public void shouldListOptions()
    {
        menu.listOptions();
        verify(printStream).println(
                "Options\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "0. Quit");
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
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("0");
        menu.selectOption();
        verify(displayAllBooksCommand).execute();

    }

    @Test
    public void shouldQuitWhenUserEntersOption0() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0");
        menu.selectOption();
        verify(quitCommand).execute();
    }

    @Test
    public void shouldAskForBookTitleWhenUserEntersOption2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2").thenReturn("0");
        menu.selectOption();
        verify(printStream).println("Type the title of the book you would like to check out:");
    }


}