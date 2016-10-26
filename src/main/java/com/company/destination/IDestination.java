package com.company.destination;

/**
 * Interface of destinations for formatting result.
 */
public interface IDestination {
    /**
     *Writes string of result.
     * @param string string of result
     */
    void write(String string);

    /**
     *Writes symbol of result to the file.
     * @param symbol symbol of result
     */
    void write(char symbol);

    /**
     * Closes destination.
     */
    void close();
}
