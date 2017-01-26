package com.company.formatterImpl.lexer.handlers;

import com.company.core.ReadException;
import com.company.formatterImpl.lexer.IHandler;

/**
 * Implementation for IHandler.
 */
public class NewLexemeHandler implements IHandler {
    @Override
    public final String execute(final StringBuilder lexeme, final Character c)
            throws ReadException {
        lexeme.append(c);
        return null;
    }
}
