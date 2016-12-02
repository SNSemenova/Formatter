package Core;

import com.company.Core.ISource;
import com.company.Core.ReadException;
import com.company.StringIO.StringSource;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for ReadException.
 */
public class ReadExceptionTest {
    private ISource source;

    @Before
    public void setUp() {
        source = new StringSource("");
    }

    @Test(expected = ReadException.class)
    public void testString() throws ReadException {
        char symbol = 0;
        symbol = source.read();
    }
}