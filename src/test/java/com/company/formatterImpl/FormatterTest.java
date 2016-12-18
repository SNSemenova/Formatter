package com.company.formatterImpl;

import com.company.core.*;
import com.company.formatterImpl.lexer.IToken;
import com.company.formatterImpl.lexer.Lexer;
import com.company.stringIO.StringDestination;
import com.company.stringIO.StringSource;
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
        ISource<Character> source = new StringSource("a{qwer{ty;}}abc");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals("a{\n    qwer{\n        ty;\n    }\n}\nabc",
                destination.toString());
    }

    @Test
    public void bracketsFormat() throws FormatException, WriteException {
        ISource<Character> source = new StringSource("{f{a}}abc");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals("{\n    f{\n        a\n    }\n}\nabc",
                destination.toString());
    }

    @Test
    public void commentFormat() throws FormatException, WriteException {
        ISource<Character> source = new StringSource("//{;}\n/*{\n;}*/;abc");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals("//{;}\n/*{\n;}*/;\nabc",
                destination.toString());
    }

    @Test
    public void semicolonFormat() throws FormatException, WriteException {
        ISource<Character> source = new StringSource(";;abc");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals(";\n;\nabc",
                destination.toString());
    }

    @Test
    public void lineBreakFormat() throws FormatException {
        ISource<Character> source = new StringSource("\n}\n");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals("\n}\n",
                destination.toString());
    }

    @Test
    public void forFormat() throws FormatException {
        ISource<Character> source = new StringSource("for(i=0; i<N; i++) j=i");
        ISource<IToken> lexeme = new Lexer(source);
        IDestination destination = new StringDestination();
        formatter.format(lexeme, destination);
        assertEquals("for(i=0; i<N; i++) j=i",
                destination.toString());
    }
}

