import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class BookTest {
    @Test
    public void displaysBookInfo() {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Harry Potter", "JK Rowling", "1995", printStream);
        book.displayInformation();
        verify(printStream).println("Harry Potter\nJK Rowling\n1995\n");
    }

}