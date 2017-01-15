import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sspecht on 1/11/17.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Book bookOne = new Book("Harry Potter", "Jk", "1999", printStream);
        Book bookTwo = new Book("The Hobbit", "JRR", "1965", printStream);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Welcome welcome = new Welcome(printStream);
        Library library = new Library(bookList);

        Application application = new Application(welcome, library);
        application.start();
    }
}
