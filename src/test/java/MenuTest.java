import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/15/17.
 */
public class MenuTest {
    private Menu menu;
    private PrintStream printStream;


    @Before
    public void setUp()
    {
        printStream = mock(PrintStream.class);
        menu = new Menu(printStream);

    }


    @Test
    public void shouldListOptions()
    {
        menu.listOptions();
        verify(printStream).println("Options\n1. List Books");
    }



}