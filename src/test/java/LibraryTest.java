import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class LibraryTest {

    private List<Book> bookList;
    private Library library;
    private Book bookOne;
    private Book bookTwo;
    private ColumnFormatter columnFormatter;
    private PrintStream printStream;


    @Before
    public void setUp() throws Exception {
        columnFormatter = mock(ColumnFormatter.class);
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<Book>();
        library = new Library(bookList, columnFormatter, printStream);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
    }

    @Test
    public void shouldDisplayAListOfOneBook(){
        bookList.add(bookOne);

        library.displayAllBooks();

        verify(bookOne).displayInformation();
    }

    @Test
    public void shouldDisplayAListOfManyBooks(){
        bookList.add(bookOne);
        bookList.add(bookTwo);

        library.displayAllBooks();

        verify(bookTwo).displayInformation();
    }

    @Test
    public void shouldCallReturnFormattedHeader(){
        library.displayAllBooks();
        verify(columnFormatter).returnFormattedHeader();
    }

    @Test
    public void shouldRemoveBookOneFromLibrary(){
        bookList.add(bookOne);
        bookList.add(bookTwo);
        library.removeBook(bookOne);
        assertEquals(1, bookList.size());
    }

}