import java.io.PrintStream;

/**
 * Created by sspecht on 1/12/17.
 */
public class Book {
    private String title;
    private String author;
    private String year;
    private PrintStream printStream;

    public Book(String title, String author, String year, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream = printStream;
    }

    public void displayInformation() {
        printStream.println(title + "\n" + author + "\n" + year + "\n");
    }
}
