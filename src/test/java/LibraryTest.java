import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class LibraryTest {

    @Test
    public void shouldDisplayAListOfBooks(){
        PrintStream printStream = mock(PrintStream.class);
        Book bookOne = mock(Book.class);

        ArrayList <Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);

        Library library = new Library(bookList);
        library.displayAllBooks();
        verify(bookOne).displayInformation();


    }


}