import java.io.IOException;

/**
 * Created by sspecht on 1/12/17.
 */
public class Application {
    private final Menu menu;
    private Welcome welcome;
    private Library library;

    public Application(Welcome welcome, Library library, Menu menu) {
        this.welcome = welcome;
        this.library = library;
        this.menu = menu;
    }

    public void start() throws IOException {
        welcome.displayWelcomeMessage();
        //library.displayAllBooks();
        menu.listOptions();
        menu.askForOption();

    }
}
