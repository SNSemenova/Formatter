package com.company.source;

/**
 * Implements ISource with char file
 */
public class FileSource implements ISource {

    public FileSource(String fileName) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public char read() {
        return ' ';
    }

    @Override
    public void close() {

    }
}
