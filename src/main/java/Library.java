import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by sspecht on 1/12/17.
 */
public class Library {
    private ArrayList <Book> booklist;

    public Library(ArrayList<Book> bookList) {
        this.booklist = bookList;
    }

    public void displayAllBooks() {

        for (Book book : booklist) {
            book.displayInformation();
        }
    }




}
