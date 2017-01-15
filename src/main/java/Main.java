import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sspecht on 1/11/17.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Menu menu = new Menu(printStream);
        ColumnFormatter columnFormatter = new ColumnFormatter();
        Book bookOne = new Book("Harry Potter", "Jk", "1999", printStream, columnFormatter);
        Book bookTwo = new Book("The Hobbit", "JRR", "1965", printStream, columnFormatter);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Welcome welcome = new Welcome(printStream);
        Library library = new Library(bookList , columnFormatter , printStream);

        Application application = new Application(welcome, library, menu);
        application.start();
    }
}
