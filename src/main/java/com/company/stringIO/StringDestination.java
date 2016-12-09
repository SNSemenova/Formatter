package com.company.StringIO;

import com.company.Core.IDestination;

/**
 * Class for working with string in
 * which the result will be recorded.
 */
public class StringDestination implements IDestination {
    /**
     * Creates a new object.
     */
    private StringBuilder destination = new StringBuilder();

    /**
     * Writes string of result to the string.
     * @param string string of result for recording
     */
    public final void write(final String string) {
        this.destination.append(string);
    }
    /**
     * Writes symbol of result to the string.
     * @param symbol symbol for recording to the string
     */
    public final void write(final char symbol) {
        this.destination.append(symbol);
    }
    /**
     * Closes destination.
     */
    public void close() {

    }

    @Override
    public final String toString() {
        return this.destination.toString();
    }
}
