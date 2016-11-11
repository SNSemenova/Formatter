import com.company.source.ISource;
import com.company.source.ReadException;
import com.company.source.StringSource;
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
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new ReadException(e);
        }
    }



    @Test(expected = ReadException.class)
    public void testString2() throws ReadException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new ReadException("Empty string", e);
        }
    }

    @Test(expected = ReadException.class)
    public void testString3() throws ReadException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new ReadException("Empty string");
        }
    }

    @Test(expected = ReadException.class)
    public void testString4() throws ReadException {
        char symbol = 0;
        try {
            symbol = source.read();
        } catch(Exception e) {
            throw new ReadException();
        }
    }
}
