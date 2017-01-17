import javax.activation.CommandMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by sspecht on 1/15/17.
 */
public class Menu {
    private  BufferedReader bufferedReader;
    private  Library library;
    private Map<String, Command> commandMap;
    private PrintStream printStream;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Library library, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.library = library;
        this.commandMap = commandMap;
    }


    public void listOptions() {
        String listOfOptions;
        listOfOptions = "Options\n";
        listOfOptions += "1. List Books\n";
        listOfOptions += "2. Checkout Book\n";
        listOfOptions += "0. Quit";



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
        List<String> userInputs = new ArrayList<String>();
        userInputs.addAll( Arrays.asList("1", "2","0") );
        if(userInputs.contains(userInput)) {
            return true;
        }
        return false;
    }

    public void selectOption() throws IOException {
        String optionSelected = "";
        do {
            optionSelected = askForOption();
            if(commandMap.containsKey(optionSelected)) {
                commandMap.get(optionSelected).execute();
            }
        }
        while(!optionSelected.equals("0"));

    }
}

