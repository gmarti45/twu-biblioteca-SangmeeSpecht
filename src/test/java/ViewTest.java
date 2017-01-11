import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by sspecht on 1/11/17.
 */
public class ViewTest {
    private PrintStream printStream;

    @Test
    public void displaysAWelcomeMessageWhenProgramStarts() {
        View view = new View();
        String welcomeMessage = view.renderWelcomeMessage();

        assertThat(welcomeMessage, is("Welcome to the Biblioteca!!!!!!"));

    }

    @Test
    public void displaysAllTheBooksInLibrary(){
        View view = new View();
        printStream = mock(PrintStream.class);

        ArrayList<String> books = new ArrayList<String>();
        books.add("Harry Potter and the Order of the Phoenix");
        books.add("The Magicians");
        books.add("Godel, Escher, and Bach");

        assertThat(view.displayAllBooks(books), is("Harry Potter and the Order of the Phoenix" +
                "\nThe Magicians" +
                "\nGodel, Escher, and Bach"));

    }


}