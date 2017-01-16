import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sspecht on 1/11/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        ColumnFormatter columnFormatter = new ColumnFormatter();


        Book bookOne = new Book("Harry Potter", "Jk", "1999", printStream, columnFormatter);
        Book bookTwo = new Book("The Hobbit", "JRR", "1965", printStream, columnFormatter);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Library library = new Library(bookList , columnFormatter , printStream);
        Menu menu = new Menu(printStream, bufferedReader, library);
        Welcome welcome = new Welcome(printStream);

        Application application = new Application(welcome, library, menu);
        application.start();
    }
}
