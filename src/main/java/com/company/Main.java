package com.company;


import com.company.Core.IFormatter;
import com.company.Core.IDestination;
import com.company.Core.FormatException;
import com.company.Core.ISource;
import com.company.Core.ReadException;
import com.company.Core.WriteException;
import com.company.FileIO.FileDestination;
import com.company.FileIO.FileSource;
import com.company.FormatterImpl.Formatter;

/**
 *Launches formatter.
 */
public final class Main {
    /**
     * Private constructor.
     */
    private Main() {
        //not called
    }
    /**
     * Takes code and formats it.
     * @param args  command line argument
     * @throws FormatException when there is formatter error
     * @throws ReadException when the source can't be read
     * @throws WriteException when it can't write to destination
     */
    public static void main(final String[] args)
            throws FormatException, ReadException, WriteException {
        ISource source = new FileSource(args[0]);
        IDestination destination = null;
        try {
            destination = new FileDestination(args[1]);
        } catch (WriteException e) {
            throw new WriteException(e);
        }
        IFormatter formatter = new Formatter();
        formatter.format(source, destination);
        source.close();
        destination.close();
    }
}
