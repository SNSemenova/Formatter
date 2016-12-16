package com.company.fileIO;

import com.company.core.*;
import com.company.formatterImpl.Formatter;
import com.company.formatterImpl.lexer.IToken;
import com.company.formatterImpl.lexer.Lexer;
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
        ISource<Character> source = new FileSource("source.txt");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new FileDestination("destination.txt");
        formatter.format(lexeme, destination);
        source.close();
        destination.close();
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}
