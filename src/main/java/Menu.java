import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sspecht on 1/15/17.
 */
public class Menu {
    private  BufferedReader bufferedReader;
    private  Library library;
    private PrintStream printStream;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Library library) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.library = library;
    }


    public void listOptions() {
        String listOfOptions;
        listOfOptions = "Options\n";
        listOfOptions += "1. List Books\n";
        listOfOptions += "2. Quit";



        printStream.println(listOfOptions);
    }

    public String askForOption() throws IOException {
        printStream.println("Enter an option number:");
        String optionChoice = bufferedReader.readLine();

        while(isValidInput(optionChoice) == false)
        {
            displayInvalidInput();
            printStream.println("Enter an option number:");
            optionChoice = bufferedReader.readLine();
        }

        return optionChoice;
    }

    public void displayInvalidInput() throws IOException {
        printStream.println("Select a valid option!");
    }

    public Boolean isValidInput(String userInput) throws IOException {
        if(userInput.equals("1") || userInput.equals("2")) {
            return true;
        }
        return false;
    }

    public void selectOption() throws IOException {
        String optionSelected = askForOption();
        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("1", new DisplayAllBooksCommand(library));
        commandMap.put("2", new QuitCommand(printStream));
        if(commandMap.containsKey(optionSelected))
        {
            Command command = commandMap.get(optionSelected);
            command.execute();

        }

    }
}

