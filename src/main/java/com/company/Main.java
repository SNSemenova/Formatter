package com.company;

import com.company.core.*;
import com.company.fileIO.FileDestination;
import com.company.fileIO.FileSource;
import com.company.formatterImpl.Formatter;
import com.company.formatterImpl.lexer.Lexer;

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
        ISource<Character> source = new FileSource(args[0]);
        ISource<String> lexer = new Lexer(source);
        IDestination destination = new FileDestination(args[1]);
        IFormatter formatter = new Formatter();
        formatter.format(lexer, destination);
        source.close();
        destination.close();
    }
}
