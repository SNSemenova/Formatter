package com.company.formatterImpl;


import com.company.core.FormatException;
import com.company.core.IDestination;
import com.company.core.IFormatter;
import com.company.core.ISource;
import com.company.core.WriteException;
import com.company.core.ReadException;
import com.company.formatterImpl.state.States;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource source,
                             final IDestination destination)
            throws FormatException {
        States state = new States();
        CommandStore options = new CommandStore();
        Indent indent = new Indent();
        try {
            while (source.hasNext()) {
                char symbol = 0;
                symbol = source.read();
                ICommand command =
                        options.getCommand(state.getCurrentState(), symbol);
                command.execute(destination, symbol, state, indent);
                state.updateState(symbol);
            }
        } catch (ReadException e) {
            throw new FormatException(e);
        } catch (WriteException e) {
            throw new FormatException(e);
        }
    }
}
