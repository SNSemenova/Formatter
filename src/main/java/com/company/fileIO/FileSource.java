package com.company.FileIO;

import com.company.Core.ISource;
import com.company.Core.ReadException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implements ISource with char file.
 */
public class FileSource implements ISource {

    /**
     * Reader for file.
     */
    private FileReader reader;

    /**
     * Current symbol of file.
     */
    private int current = 0;

    /**
     * Creates a new object.
     * @param fileName name of file
     * @throws ReadException when reader can't be initialized
     */
    public FileSource(final String fileName) throws ReadException {
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new ReadException(e);
        }
    }

    @Override
    public final boolean hasNext() throws ReadException {
        try {
            this.current = this.reader.read();
            return (this.current) != -1;
        } catch (IOException e) {
            throw new ReadException(e);
        }
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
    public final void close() throws ReadException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new ReadException(e);
        }
    }
}
