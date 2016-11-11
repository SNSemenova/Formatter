import com.company.Main;
import com.company.destination.IDestination;
import com.company.destination.StringDestination;
import com.company.formatter.FormatException;
import com.company.source.ReadException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/**
 * Test for class Main
 */
public class MainTest {

    @Before
    public void setUp() {
        IDestination destination = new StringDestination();
    }
    @Test
    public void testMain() throws FileNotFoundException, FormatException, ReadException {
        Main.main(new String[]{"source.txt", "destination.txt"});
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}