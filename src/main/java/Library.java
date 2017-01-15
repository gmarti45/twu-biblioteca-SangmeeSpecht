import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sspecht on 1/12/17.
 */
public class Library {
    private List<Book> booklist;

    public Library(List<Book> bookList) {
        this.booklist = bookList;
    }

    public void displayAllBooks() {

        for (Book book : booklist) {
            book.displayInformation();
        }
    }




}
