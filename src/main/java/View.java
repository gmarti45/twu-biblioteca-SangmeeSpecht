import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by sspecht on 1/11/17.
 */
public class View {
    private PrintStream printStream;

    public View(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void renderWelcomeMessage() {
        printStream.println( "Welcome to the Biblioteca!!!!!!");

    }

    public void displayAllBooks(ArrayList<String> books) {
        String bookList = "";
        for (String book : books) {
            bookList += book + "\n";
        }
        printStream.println(bookList);
    }
}
