package com.company;

import com.company.destination.FileDestination;
import com.company.destination.IDestination;
import com.company.formatter.Formatter;
import com.company.formatter.IFormatter;
import com.company.source.FileSource;
import com.company.source.ISource;

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
    public static void main(final String[] args) {
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