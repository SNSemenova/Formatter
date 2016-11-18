package com.company.Core;

/**
* Interface for code formatting.
*/
public interface IFormatter {
    /**
     * Formatting a code.
     * @param source source of code
     * @param destination where the result will be recorded
     */
    void format(ISource source, IDestination destination) throws FormatException;
}
