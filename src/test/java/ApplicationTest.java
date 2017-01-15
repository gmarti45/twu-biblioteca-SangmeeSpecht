import org.junit.Before;
import org.junit.Ignore;
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
    private Menu menu;
    private Application application;
    private Library library;
    private Welcome welcome;

    @Before

    public void setUp()
    {
        menu = mock(Menu.class);
        library = mock(Library.class);
        welcome = mock(Welcome.class);
        application = new Application(welcome, library, menu);
    }

    @Test
    public void shouldCallWelcomeMessage() {

        application.start();
        verify(welcome).displayWelcomeMessage();

    }

    @Test
    @Ignore
    public void shouldDisplayAllBooksWhenStartIsCalled() {
        Book book = mock(Book.class);
        ArrayList<Book> bookList = new ArrayList();
        bookList.add(book);
        application.start();
        verify(library).displayAllBooks();
    }

    @Test
    public void shouldDisplayListOfOptionsWhenStartIsCalled() {
        application.start();
        verify(menu).listOptions();
    }
}