import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by sspecht on 1/15/17.
 */
public class Menu {
    private final BufferedReader bufferedReader;
    private PrintStream printStream;

    public Menu(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void listOptions() {
        String listOfOptions;
        listOfOptions = "Options\n";
        listOfOptions += "1. List Books";


        printStream.println(listOfOptions);
    }

    public String askForOption() throws IOException {
        printStream.println("Enter an option number:");
        String optionChoice = bufferedReader.readLine();
        return optionChoice;
    }
}

