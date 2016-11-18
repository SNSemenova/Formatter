package FormatterImpl;

import com.company.Core.FormatException;
import com.company.Core.IDestination;
import com.company.Core.IFormatter;
import com.company.Core.ISource;
import com.company.FormatterImpl.Formatter;
import com.company.StringIO.StringDestination;
import com.company.StringIO.StringSource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by svetlana on 15.11.16.
 */
public class SemicolonFormatTest {

    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void testString() throws FormatException {
        ISource source = new StringSource(";;");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals(";\n;\n",
                destination.toString());
    }
}
