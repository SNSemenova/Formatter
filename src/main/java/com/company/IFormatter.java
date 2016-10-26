package com.company;

import com.company.destination.IDestination;
import com.company.source.ISource;

/**
* Interface for code formatting.
*/
public interface IFormatter {
    /**
     * Formatting a code.
     * @param source source of code
     * @param destination where the result will be recorded
     * @throws FormatException If a format exception occurred
     */
    void format(ISource source, IDestination destination)
            throws FormatException;
}
