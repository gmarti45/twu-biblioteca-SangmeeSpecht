/**
 * Created by gmartine on 1/16/17.
 */
public class DisplayAllBooksCommand implements Command {
    private Library library;

    public DisplayAllBooksCommand(Library library){
        this.library = library;
    }
    public void execute() {
        library.displayAllBooks();
    }
}
