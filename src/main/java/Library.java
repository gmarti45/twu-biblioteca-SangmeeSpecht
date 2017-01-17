import java.io.PrintStream;
import java.util.List;

/**
 * Created by sspecht on 1/12/17.
 */
public class Library {
    private PrintStream printStream;
    private List<Book> bookList;
    private ColumnFormatter columnFormatter;

    public Library(List<Book> bookList, ColumnFormatter columnFormatter, PrintStream printStream) {
        this.bookList = bookList;
        this.columnFormatter = columnFormatter;
        this.printStream = printStream;
    }


    public void displayAllBooks() {
        printStream.println(columnFormatter.returnFormattedHeader());
        for (Book book : bookList) {
            book.displayInformation();
        }
    }


    public void removeBook(Book bookOne) {
        //bookList.remove(0)
    }
}
