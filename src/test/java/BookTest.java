import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by sspecht on 1/12/17.
 */
public class BookTest {
    private Book book;
    private PrintStream printStream;
    private ColumnFormatter columnFormatter;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        columnFormatter = mock(ColumnFormatter.class);
        book = new Book("Harry Potter", "JK Rowling", "1995", printStream, columnFormatter);
    }

    @Test
    public void shouldPrintAFormattedBookRecord() {
        String formattedBookRecord = String.format("%-50s", "Harry Potter");
        formattedBookRecord += String.format("%-25s", "JK Rowling");
        formattedBookRecord += "1995";
        formattedBookRecord += "\n";

        when(columnFormatter.formatColumns("Harry Potter", "JK Rowling", "1995")).thenReturn(formattedBookRecord);

        book.displayInformation();

        verify(printStream).println(formattedBookRecord);
    }

}