package com.company.FormatterImpl;


import com.company.Core.FormatException;
import com.company.Core.IDestination;
import com.company.Core.IFormatter;
import com.company.Core.ISource;
import com.company.Core.WriteException;
import com.company.Core.ReadException;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource source,
                             final IDestination destination)
            throws FormatException {
        State state = new State();
        CommandStore options = new CommandStore();
        try {
            while (source.hasNext()) {
                char symbol = 0;
                symbol = source.read();
                ICommand command =
                        options.getCommand(state.getCurrentState(), symbol);
                command.execute(destination, symbol, state);
                state.updateState(symbol);
            }
        } catch (ReadException e) {
            throw new FormatException(e);
        } catch (WriteException e) {
            throw new FormatException(e);
        }
    }
}
