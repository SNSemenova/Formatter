package com.company.formatterImpl.lexer;

import com.company.core.ISource;
import com.company.core.ReadException;

/**
 * Implementation of ISource.
 */
public class Lexer implements ISource<Token> {
    /**
     * Reading source.
     */
    private ISource<Character> source;
    /**
     * String builder for lexeme.
     */
    private StringBuilder lexeme = new StringBuilder();
    /**
     * Read character.
     */
    private Character c;

    /**
     * Initialization of Lexer.
     * @param in source of reading
     */
    public Lexer(final ISource<Character> in) {
        this.source = in;
    }

    @Override
    public final boolean hasNext() throws ReadException {
        return source.hasNext();
    }

    @Override
    public final Token read() throws ReadException {
        String string = "";
        if (c != null) {
            lexeme.append(c);
            string = lexeme.toString();
            lexeme.setLength(0);
            c = source.read();
            return new Token(string);
        }
        c = source.read();
        while (source.hasNext()) {
            if (c != null) {
                lexeme.append(c);
                string = lexeme.toString();
                lexeme.setLength(0);
                c = source.read();
                return new Token(string);
            }
            c = source.read();
            lexeme.append(c);
            c = null;
            string = lexeme.toString();
            lexeme.setLength(0);
            return new Token(string);
        }
        return new Token(string);
    }

    @Override
    public void close() throws ReadException {

    }
}
