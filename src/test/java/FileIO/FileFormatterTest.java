package FileIO;

import com.company.Core.FormatException;
import com.company.Core.IDestination;
import com.company.Core.IFormatter;
import com.company.Core.ISource;
import com.company.FileIO.FileDestination;
import com.company.FileIO.FileSource;
import com.company.FormatterImpl.Formatter;
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
