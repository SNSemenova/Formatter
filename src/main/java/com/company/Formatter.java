package com.company;

import com.company.destination.IDestination;
import com.company.source.ISource;
import com.company.source.ReadException;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource source,
                             final IDestination destination)
            throws FormatException {
        int level = 0;
        char previous = 0;
        while (source.hasNext()) {
            try {
                char symbol = source.read();
                switch (symbol) {
                    case '{':
                        destination.write(symbol);
                        level++;
                        destination.write('\n');
                        for (int i = 0; i < level; i++) {
                            destination.write("    ");
                        }
                        previous = symbol;
                        break;
                    case '}':
                        if (previous != ';') {
                            destination.write('\n');
                        }
                        level--;
                        for (int i = 0; i < level; i++) {
                            destination.write("    ");
                        }
                        destination.write(symbol);
                        destination.write('\n');
                        previous = symbol;
                        break;
                    case ';':
                        destination.write(symbol);
                        destination.write('\n');
                        previous = symbol;
                        break;
                    default:
                        if (previous == ';' || previous == '}') {
                            for (int i = 0; i < level; i++) {
                                destination.write("    ");
                            }
                        }
                        destination.write(symbol);
                        previous = symbol;
                }
            } catch (ReadException e) {
                throw new FormatException(e);
            }
        }
    }
}
