package com.company.source;

/**
 * Implements ISource with char file.
 */
public class FileSource implements ISource {
    /**
     * Creates a new object.
     * @param fileName name of file
     */
    public FileSource(final String fileName) {
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final char read() {
        return ' ';
    }

    @Override
    public void close() {

    }
}
