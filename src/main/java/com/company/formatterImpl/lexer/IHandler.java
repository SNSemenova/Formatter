package com.company.formatterImpl.lexer;

import com.company.core.ReadException;

/**
 * Interface for handlers.
 */
public interface IHandler {
    /**
     * Execution of handler.
     * @param lexeme current string for formatting
     * @param c character from source
     * @return lexeme
     * @throws ReadException exception of reading
     */
   String execute(StringBuilder lexeme, Character c) throws ReadException;
}
