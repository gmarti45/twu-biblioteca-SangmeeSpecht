/**
 * Created by gmartine on 1/16/17.
 */
public class CheckoutBookCommand implements Command {
    Library library;

    public CheckoutBookCommand(Library library) {
        this.library = library;
    }

    public void execute() {
        library.remove();

    }
}
