import java.io.PrintStream;

/**
 * Created by sspecht on 1/12/17.
 */
public class Welcome {
    private PrintStream printStream;
    
    public Welcome(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void displayWelcomeMessage() {
        printStream.println( "Welcome to the Biblioteca!!!!!!");
    }
}
