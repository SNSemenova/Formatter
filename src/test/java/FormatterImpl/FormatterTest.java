package FormatterImpl;

import com.company.Core.*;
import com.company.FormatterImpl.Formatter;
import com.company.StringIO.StringDestination;
import com.company.StringIO.StringSource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for class Formatter
 */
public class FormatterTest {

    private IFormatter formatter;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void testString() throws FormatException, WriteException {
        ISource source = new StringSource("a{qwer{ty;}}");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals("a{\n    qwer{\n        ty;\n    }\n}\n",
                destination.toString());
    }

    @Test
    public void bracketsFormat() throws FormatException, WriteException {
        ISource source = new StringSource("{f{a}}");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals("{\n    f{\n        a\n    }\n}\n",
                destination.toString());
    }

    @Test
    public void commentFormat() throws FormatException, WriteException {
        ISource source = new StringSource("//{;}\n/*{\n;}*/");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals("//{;}\n/*{\n;}*/",
                destination.toString());
    }

    @Test
    public void semicolonFormat() throws FormatException, WriteException {
        ISource source = new StringSource(";;");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals(";\n;\n",
                destination.toString());
    }

    @Test
    public void lineBreakFormat() throws FormatException {
        ISource source = new StringSource("\n}\n");
        IDestination destination = new StringDestination();
        formatter.format(source, destination);
        assertEquals("\n}\n",
                destination.toString());
    }
}

