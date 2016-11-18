package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class SemicolonCommand implements ICommand {
    @Override
    public void execute(IDestination destination, char symbol,
                        State state) {
        destination.write(symbol);
        if (!state.isMultiLineComment() &&
                !state.isLineComment()) {
            destination.write('\n');
            state.setPrevious(symbol);
        }
    }
}
