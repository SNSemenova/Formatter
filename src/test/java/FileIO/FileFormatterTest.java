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
    public void testFile() throws FormatException, WriteException {
        ISource source = null;
        try {
            source = new FileSource("source.txt");
        } catch (ReadException e) {
            throw new FormatException(e);
        }
        IDestination destination = null;
        try {
            destination = new FileDestination("destination.txt");
        } catch (WriteException e) {
            throw new WriteException(e);
        }
        formatter.format(source, destination);
        try {
            source.close();
        } catch (ReadException e) {
            throw new FormatException(e);
        }
        destination.close();
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}
