package com.company.formatterImpl.lexer.handlers;

import com.company.core.ReadException;
import com.company.formatterImpl.lexer.IHandler;

/**
 * Implementation for IHandler.
 */
public class DefaultHandler implements IHandler {
    @Override
    public final String execute(final StringBuilder lexeme, final Character c)
            throws ReadException {
        lexeme.append(c);
        String string = lexeme.toString();
        lexeme.setLength(0);
        return string;
        }
}
