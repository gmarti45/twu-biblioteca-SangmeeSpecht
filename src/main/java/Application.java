/**
 * Created by sspecht on 1/12/17.
 */
public class Application {
    private Welcome welcome;
    private Library library;

    public Application(Welcome welcome, Library library) {
        this.welcome = welcome;
        this.library = library;
    }

    public void start(){
        welcome.displayWelcomeMessage();
        library.displayAllBooks();
    }
}
