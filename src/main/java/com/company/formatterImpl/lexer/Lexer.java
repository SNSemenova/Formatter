package com.company.formatterImpl.lexer;

import com.company.core.ISource;
import com.company.core.ReadException;

/**
 * Implementation of ISource.
 */
public class Lexer implements ISource<IToken> {
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
     * Tokens for lexer.
     */
    private Tokens tokens = new Tokens();

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
    public final IToken read() throws ReadException {
        String string = "";
        if (lexeme.length() != 0) {
            if (tokens.hasLexeme(lexeme.toString())) {
                string = lexeme.toString();
                lexeme.setLength(0);
                if (c != null) {
                    lexeme.append(c);
                }
                c = source.read();
                states.updateState(c);
                return tokens.getToken(string);
            }
        }
        if (c != null) {
            if (states.getCurrentState().equals("newLexeme")) {
                if (lexeme.length() != 0) {
                    string = lexeme.toString();
                    lexeme.setLength(0);
                    lexeme.append(c);
                    c = source.read();
                    states.updateState(c);
                    return new Token(string);
                }
            }
            lexeme.append(c);
            if (tokens.hasLexeme(lexeme.toString())) {
                string = lexeme.toString();
                lexeme.setLength(0);
                c = source.read();
                states.updateState(c);
                return tokens.getToken(string);
            } else {
                c = source.read();
            }
        } else {
            c = source.read();
        }
        states.updateState(c);
        while (source.hasNext()) {
            if (c != null) {
                if (states.getCurrentState().equals("newLexeme")) {
                    if (lexeme.length() != 0) {
                        string = lexeme.toString();
                        lexeme.setLength(0);
                        lexeme.append(c);
                        c = source.read();
                        states.updateState(c);
                        return new Token(string);
                    }
                }
                lexeme.append(c);
                if (tokens.hasLexeme(lexeme.toString())) {
                    string = lexeme.toString();
                    lexeme.setLength(0);
                    c = source.read();
                    states.updateState(c);
                    return tokens.getToken(string);
                }
            }
            c = source.read();
            states.updateState(c);
            if (states.getCurrentState().equals("newLexeme")) {
                if (lexeme.length() != 0) {
                    string = lexeme.toString();
                    lexeme.setLength(0);
                    lexeme.append(c);
                    c = null;
                    return new Token(string);
                }
            }
            lexeme.append(c);
            if (tokens.hasLexeme(lexeme.toString())) {
                string = lexeme.toString();
                lexeme.setLength(0);
                c = null;
                return tokens.getToken(string);
            }
            c = null;
        }
        if (c != null) {
            lexeme.append(c);
        }
        if (lexeme.length() != 0) {
            string = lexeme.toString();
        }
        return new Token(string);
    }

    @Override
    public void close() throws ReadException {

    }
}
