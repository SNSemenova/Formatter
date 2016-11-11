import com.company.formatter.FormatException;
import com.company.source.ISource;
import com.company.source.StringSource;
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
        } catch(Exception e) {
            throw new FormatException(e);
        }
    }

    @Test(expected = FormatException.class)
    public void testString2() throws FormatException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new FormatException("Empty string", e);
        }
    }

    @Test(expected = FormatException.class)
    public void testString3() throws FormatException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new FormatException("Empty string");
        }
    }

    @Test(expected = FormatException.class)
    public void testString4() throws FormatException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new FormatException();
        }
    }
}
