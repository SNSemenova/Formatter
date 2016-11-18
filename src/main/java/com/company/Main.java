package com.company;

import com.company.FileIO.FileDestination;
import com.company.Core.IDestination;
import com.company.Core.FormatException;
import com.company.FormatterImpl.Formatter;
import com.company.Core.IFormatter;
import com.company.FileIO.FileSource;
import com.company.Core.ISource;
import com.company.Core.ReadException;

import java.io.FileNotFoundException;

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
     */
    public static void main(final String[] args) throws FormatException, ReadException {
        ISource source = new FileSource(args[0]);
        IDestination destination = null;
        try {
            destination = new FileDestination(args[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        IFormatter formatter = new Formatter();
        formatter.format(source, destination);
        source.close();
        destination.close();
    }
}