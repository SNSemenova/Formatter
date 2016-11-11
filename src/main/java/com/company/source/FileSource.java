package com.company.source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implements ISource with char file.
 */
public class FileSource implements ISource {

    private FileReader reader;

    private int current = 0;

    /**
     * Creates a new object.
     *
     * @param fileName name of file
     */
    public FileSource(final String fileName) {
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final boolean hasNext() {
        try {
            if ((this.current = this.reader.read()) != -1) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public final char read() throws ReadException {
        try {
            return ((char) current);
        } catch (Exception e) {
            throw new ReadException(e);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
