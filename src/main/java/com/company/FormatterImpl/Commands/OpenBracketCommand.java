package com.company.FormatterImpl.Commands;

import com.company.Core.IDestination;
import com.company.FormatterImpl.ICommand;
import com.company.FormatterImpl.State;

/**
 * Implementation for interface ICommand.
 */
public class OpenBracketCommand implements ICommand {

    @Override
    public void execute(IDestination destination, char symbol,
                        State state) {
        if (!state.isLineComment() &&
                !state.isMultiLineComment()) {
            destination.write(symbol);
            state.incrementLevel();
            destination.write('\n');
            for (int i = 0; i < state.getLevel(); i++) {
                destination.write("    ");
            }
            state.setPrevious(symbol);
        } else {
            destination.write(symbol);
        }
    }
}
