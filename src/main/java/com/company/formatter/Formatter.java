package com.company.formatter;

import com.company.destination.IDestination;
import com.company.source.ISource;
import com.company.source.ReadException;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource source,
                             final IDestination destination) throws FormatException {
        int level = 0;
        char previous = 0;
        boolean lineComment = false;
        boolean multiLineComment = false;
        while (source.hasNext()) {
            char symbol = 0;
            try {
                symbol = source.read();
            } catch (ReadException e) {
                e.printStackTrace();
            }
            switch (symbol) {
                case '{':
                    if (!lineComment && !multiLineComment) {
                        destination.write(symbol);
                        level++;
                        destination.write('\n');
                        for (int i = 0; i < level; i++) {
                            destination.write("    ");
                        }
                        previous = symbol;
                    } else {
                        destination.write(symbol);
                    }
                    break;
                case '}':
                    if (!lineComment && !multiLineComment) {
                        if (previous != ';' && previous != '}') {
                            destination.write('\n');
                        }
                        level--;
                        for (int i = 0; i < level; i++) {
                            destination.write("    ");
                        }
                        destination.write(symbol);
                        destination.write('\n');
                        previous = symbol;
                    } else {
                        destination.write(symbol);
                    }
                    break;
                case ';':
                    destination.write(symbol);
                    if (!lineComment && !multiLineComment) {
                        destination.write('\n');
                        previous = symbol;
                    }
                    break;
                case '/':
                        if (previous == ';' || previous == '}') {
                            for (int i = 0; i < level; i++) {
                                destination.write("    ");
                            }
                        }
                        if (previous == '/') {
                            lineComment = true;
                        }
                        if (previous == '*') {
                            multiLineComment = false;
                        }
                        destination.write(symbol);
                        previous = symbol;
                        break;
                    case '*':
                        if (previous == '/') {
                            multiLineComment = true;
                        }
                        destination.write(symbol);
                        previous = symbol;
                        break;
                case '\n':
                        if (previous != ';' && previous != '}' && previous != '{') {
                            destination.write(symbol);
                        }
                        lineComment = false;
                       break;
                default:
                    if (previous == ';' || previous == '}' ) {
                        for (int i = 0; i < level; i++) {
                            destination.write("    ");
                        }
                    }
                    destination.write(symbol);
                    previous = symbol;
            }
        }
    }
}