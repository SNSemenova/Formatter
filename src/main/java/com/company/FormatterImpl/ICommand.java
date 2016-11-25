package com.company.FormatterImpl;

import com.company.Core.IDestination;
import com.company.Core.WriteException;

/**
 *  Interface for commands.
 */
public interface ICommand {
    /**
     * Execution of handler.
     * @param destination for writing result of formatting
     * @param symbol current symbol for formatting
     * @param state state of formatter
     * @throws WriteException when symbol can't be read
     */
    void execute(IDestination destination, char symbol, State state)
            throws WriteException;
}


