package com.company.Core;

/**
 * Interface of source for formatter.
 */
public interface ISource {
    /**
     * Returns <code>true</code> if the next symbol exists
     * and <code>false</code> otherwise.
     * @return <code>true</code> if the next symbol exists
     * and <code>false</code> otherwise
     */
    boolean hasNext();

    /**
     * Returns next symbol if exists.
     * @return next symbol
     * @throws ReadException when next symbol can't be read
     */
    char read() throws ReadException;

    /**
     * Closes a com.company.source.
     */
    void close();
}
