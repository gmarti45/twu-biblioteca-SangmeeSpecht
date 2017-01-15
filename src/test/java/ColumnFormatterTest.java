import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by sspecht on 1/13/17.
 */
public class ColumnFormatterTest {
    private ColumnFormatter columnFormatter;

    @Before
    public void name() {
        columnFormatter = new ColumnFormatter();
    }

    @Test
    public void shouldReturnTheBookRecordWithTheCorrectFormat() {
        String bookRecord = columnFormatter.formatColumns("Harry Potter", "JK Rowling", "1995");

        String formattedBookRecord = String.format("%-50s", "Harry Potter");
        formattedBookRecord += String.format("%-25s", "JK Rowling");
        formattedBookRecord += "1995";
        formattedBookRecord += "\n";

        assertThat(bookRecord, is(formattedBookRecord));
    }
}