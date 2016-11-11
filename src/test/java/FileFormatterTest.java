import com.company.destination.*;
import com.company.formatter.*;
import com.company.source.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/**
 * Test for file.
 */

public class FileFormatterTest {
    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void testFile() throws FormatException {
        ISource source = new FileSource("source.txt");
        IDestination destination = null;
        try {
            destination = new FileDestination("destination.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        formatter.format(source, destination);
        source.close();
        destination.close();
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}
