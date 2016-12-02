package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.Core.WriteException;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class NewLineCommand implements ICommand {
    @Override
    public final void execute(final IDestination destination,
                              final char symbol, final State state)
            throws WriteException {
        for (int i = 0; i < state.getLevel(); i++) {
            destination.write("    ");
        }
        destination.write(symbol);
    }
}
