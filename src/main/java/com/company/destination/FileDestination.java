package com.company.destination;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for working with files in
 * which the result will be recorded.
 */
public class FileDestination implements IDestination {
    private FileWriter writer;
    private File file;

    /**
     * Method creates an instance of the class.
     *
     * @param fileName name of file
     */
    public FileDestination(final String fileName) throws FileNotFoundException {
        file = new File(fileName);

        try {
            writer = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes string of result to the file.
     *
     * @param string string of result for recording
     */
    public void write(final String string) {
        try {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes symbol of result to the file.
     *
     * @param symbol symbol for recording to the file
     */
    public void write(final char symbol) {
        try {
            writer.write(symbol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the file.
     */
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

