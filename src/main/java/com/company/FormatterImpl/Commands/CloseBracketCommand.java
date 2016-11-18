package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class CloseBracketCommand implements ICommand {
    @Override
    public void execute(IDestination destination, char symbol,
                        State state) {
        if (!state.isLineComment() &&
                !state.isMultiLineComment()) {
            if (state.getPrevious() != ';' && state.getPrevious() != '}') {
                destination.write('\n');
            }
            state.decrementLevel();
            for (int i = 0; i < state.getLevel(); i++) {
                destination.write("    ");
            }
            destination.write(symbol);
            destination.write('\n');
            state.setPrevious(symbol);
        } else {
            destination.write(symbol);
        }
    }
}
