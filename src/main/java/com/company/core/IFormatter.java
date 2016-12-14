package com.company.core;

import com.company.formatterImpl.lexer.Token;

/**
* Interface for code formatting.
*/
public interface IFormatter {
    /**
     * Formatting a code.
     * @param source source of code
     * @param destination where the result will be recorded
     * @throws FormatException when there is formatting error
     */
    void format(ISource<Token> source, IDestination destination)
            throws FormatException;
}
