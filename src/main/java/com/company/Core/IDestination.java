package com.company.Core;

/**
 * Interface of destinations for formatting result.
 */
public interface IDestination {
    /**
     *Writes string of result.
     * @param string string of result
     * @throws WriteException when the string can't be written
     */
    void write(String string) throws WriteException;

    /**
     *Writes symbol of result to the file.
     * @param symbol symbol of result
     * @throws WriteException when the symbol can't be written
     */
    void write(char symbol) throws WriteException;

    /**
     * Closes destination.
     * @throws WriteException when destination can't be closed
     */
    void close() throws WriteException;
}
