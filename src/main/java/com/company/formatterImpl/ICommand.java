package com.company.formatterImpl;

import com.company.core.IDestination;
import com.company.core.WriteException;
import com.company.formatterImpl.state.States;

/**
 *  Interface for commands.
 */
public interface ICommand {
    /**
     * Execution of handler.
     * @param destination for writing result of formatting
     * @param symbol current symbol for formatting
     * @param state state of formatter
     * @param indent spaces for formatting
     * @throws WriteException when symbol can't be read
     */
    void execute(IDestination destination, char symbol,
                 States state, Indent indent)
            throws WriteException;
}


