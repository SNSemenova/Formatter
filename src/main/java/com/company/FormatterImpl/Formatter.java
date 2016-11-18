package com.company.FormatterImpl;

import com.company.Core.*;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource source,
                             final IDestination destination) throws FormatException {
        State state = new State();
        while (source.hasNext()) {
            char symbol = 0;
            try {
                symbol = source.read();
            } catch (ReadException e) {
                e.printStackTrace();
            }
            CommandStore commandStore = new CommandStore();
            ICommand command = commandStore.getCommand(symbol);
            command.execute(destination, symbol, state);
        }
    }
}