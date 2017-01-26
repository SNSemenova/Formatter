package com.company.formatterImpl.lexer;

import com.company.core.ISource;
import com.company.core.ReadException;

/**
 * Implementation of ISource.
 */
public class Lexer implements ISource<String> {
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
     * States for lexer.
     */
    private LexerStates states = new LexerStates();

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
    public final String read() throws ReadException {
        String string = "";
        String newLexeme = null;
        Handlers handlers = new Handlers();
        while (source.hasNext()) {
            c = source.read();
            states.updateState(c);
            IHandler handler = handlers.getHandler(states.getCurrentState());
            newLexeme = handler.execute(lexeme, c);
            if (newLexeme != null) {
                return newLexeme;
            }
        }
        return null;
    }

    @Override
    public void close() throws ReadException {

    }
}
