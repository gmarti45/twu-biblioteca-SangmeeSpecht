import java.io.PrintStream;

/**
 * Created by sspecht on 1/15/17.
 */
public class Menu {
    private PrintStream printStream;

    public Menu(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void listOptions() {
        String listOfOptions;
        listOfOptions = "Options\n";
        listOfOptions += "1. List Books";


        printStream.println(listOfOptions);
    }
}

