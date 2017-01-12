import org.junit.Assert;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/11/17.
 */
public class ViewTest {
    private PrintStream printStream;

    @Test
    public void displaysAWelcomeMessageWhenProgramStarts() {
        printStream = mock(PrintStream.class);
        View view = new View(printStream);
        view.renderWelcomeMessage();
        verify(printStream).println("Welcome to the Biblioteca!!!!!!");

    }

    @Test
    public void displaysAllTheBooksInLibrary(){
        printStream = mock(PrintStream.class);
        View view = new View(printStream);

        ArrayList<String> books = new ArrayList<String>();
        books.add("Harry Potter and the Order of the Phoenix");
        books.add("The Magicians");
        books.add("Godel, Escher, and Bach");

        view.displayAllBooks(books);

        verify(printStream).println("Harry Potter and the Order of the Phoenix\nThe Magicians\nGodel, Escher, and Bach\n");
    }


}