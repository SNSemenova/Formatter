package com.company.core;

import com.company.formatterImpl.lexer.IToken;

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
    void format(ISource<IToken> source, IDestination destination)
            throws FormatException;
}
