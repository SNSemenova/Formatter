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
     * @param lexeme current string for formatting
     * @param state state of formatter
     * @param indent spaces for formatting
     * @throws WriteException when symbol can't be read
     */
    void execute(IDestination destination, String lexeme,
                 States state, Indent indent)
            throws WriteException;
}


