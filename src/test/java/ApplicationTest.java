import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class ApplicationTest {
    @Test
    public void shouldCallWelcomeMessage() {
        Welcome welcome = mock(Welcome.class);
        Library library = mock(Library.class);

        Application application = new Application(welcome, library);

        application.start();
        verify(welcome).displayWelcomeMessage();

    }
}