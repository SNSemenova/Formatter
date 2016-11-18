package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class DefaultCommand implements ICommand {
    @Override
    public void execute(IDestination destination, char symbol,
                        State state) {
        if (state.getPrevious() == ';' || state.getPrevious() == '}' ) {
            for (int i = 0; i < state.getLevel(); i++) {
                destination.write("    ");
            }
        }
        destination.write(symbol);
        state.setPrevious(symbol);
    }
}
