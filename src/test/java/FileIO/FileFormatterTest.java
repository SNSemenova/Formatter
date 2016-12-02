package FileIO;

import com.company.Core.*;
import com.company.FileIO.FileDestination;
import com.company.FileIO.FileSource;
import com.company.FormatterImpl.Formatter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
    public void testFile() throws ReadException, WriteException, FormatException {
        ISource source = null;
        source = new FileSource("source.txt");
        IDestination destination = null;
        destination = new FileDestination("destination.txt");
        formatter.format(source, destination);
        source.close();
        destination.close();
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}
