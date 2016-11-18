package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class AsteriskCommand implements ICommand {
    @Override
    public void execute(IDestination destination, char symbol,
                        State state) {
        if (state.getPrevious() == '/') {
            state.setMultiLineComment(true);
        }
        destination.write(symbol);
        state.setPrevious(symbol);
    }
}
