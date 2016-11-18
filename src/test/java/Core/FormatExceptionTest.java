package Core;

import com.company.Core.FormatException;
import com.company.Core.ISource;
import com.company.StringIO.StringSource;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for FormatException.
 */
public class FormatExceptionTest {
    private ISource source;

    @Before
    public void setUp() {
        source = new StringSource("");
    }

    @Test(expected = FormatException.class)
    public void testString() throws FormatException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch (Exception e) {
            throw new FormatException(e);
        }
    }
}