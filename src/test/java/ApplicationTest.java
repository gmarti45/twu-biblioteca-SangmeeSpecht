import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class ApplicationTest {
    @Test
    public void shouldCallWelcomeMessage() {
        Welcome welcome = mock(Welcome.class);
        Library library = mock(Library.class);

        Application application = new Application(welcome, library);

        application.start();
        verify(welcome).displayWelcomeMessage();

    }

    @Test
    public void shouldCreateLibrary() {
        Book book = mock(Book.class);
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(book);
        Library library = mock(Library.class);
        Welcome welcome = mock(Welcome.class);

        Application application = new Application(welcome, library);

        application.start();
        verify(library).displayAllBooks();
    }
}