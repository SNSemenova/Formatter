package com.company;


import com.company.core.IFormatter;
import com.company.core.IDestination;
import com.company.core.FormatException;
import com.company.core.ISource;
import com.company.core.ReadException;
import com.company.core.WriteException;
import com.company.fileIO.FileDestination;
import com.company.fileIO.FileSource;
import com.company.formatterImpl.Formatter;
import com.company.formatterImpl.lexer.Token;
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
        ISource<Token> lexer = new Lexer(source);
        IDestination destination = new FileDestination(args[1]);
        IFormatter formatter = new Formatter();
        formatter.format(lexer, destination);
        source.close();
        destination.close();
    }
}
