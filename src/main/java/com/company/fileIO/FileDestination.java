package com.company.FileIO;

import com.company.Core.IDestination;
import com.company.Core.WriteException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for working with files in
 * which the result will be recorded.
 */
public class FileDestination implements IDestination {
    /**
     * Writer to the file.
     */
    private FileWriter writer;
    /**
     * The file.
     */
    private File file;

    /**
     * Method creates an instance of the class.
     *
     * @param fileName name of file
     * @throws WriteException when FileWriter can't be created
     */
    public FileDestination(final String fileName) throws WriteException {
        file = new File(fileName);
        try {
            writer = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new WriteException(e);
        }
    }

    /**
     * Writes string of result to the file.
     *
     * @param string string of result for recording
     * @throws WriteException when the string can't be written
     */
    public final void write(final String string) throws WriteException {
        try {
            writer.write(string);
        } catch (IOException e) {
            throw new WriteException("Error of writing of string", e);
        }
    }

    /**
     * Writes symbol of result to the file.
     *
     * @param symbol symbol for recording to the file
     * @throws WriteException when the symbol can't be written
     */
    public final void write(final char symbol) throws WriteException {
        try {
            writer.write(symbol);
        } catch (IOException e) {
            throw new WriteException("Error of writing of char", e);
        }
    }

    /**
     * Closes the file.
     * @throws WriteException when the file can't be closed
     */
    public final void close() throws WriteException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new WriteException("Error of closing", e);
        }
    }
}

