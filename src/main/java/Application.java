import java.io.IOException;

/**
 * Created by sspecht on 1/12/17.
 */
public class Application {
    private Menu menu;
    private Welcome welcome;

    public Application(Welcome welcome, Library library, Menu menu) {
        this.welcome = welcome;
        this.menu = menu;
    }

    public void start() throws IOException {
        welcome.displayWelcomeMessage();
        menu.listOptions();
        menu.selectOption();

    }
}
