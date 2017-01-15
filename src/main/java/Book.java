import java.io.PrintStream;

/**
 * Created by sspecht on 1/12/17.
 */
public class Book {
    private String title;
    private String author;
    private String year;
    private PrintStream printStream;
    private ColumnFormatter columnFormatter;

    public Book(String title, String author, String year, PrintStream printStream, ColumnFormatter columnFormatter) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream = printStream;
        this.columnFormatter = columnFormatter;
    }

    public void displayInformation() {
        printStream.println(columnFormatter.formatColumns(title, author, year));
    }
}
