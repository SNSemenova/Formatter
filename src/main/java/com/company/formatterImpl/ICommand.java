package com.company.formatterImpl;

import com.company.core.IDestination;
import com.company.core.WriteException;

/**
 *  Interface for commands.
 */
public interface ICommand {
    /**
     * Execution of handler.
     * @param destination for writing result of formatting
     * @param lexeme current string for formatting
     * @param indent spaces for formatting
     * @throws WriteException when symbol can't be read
     */
    void execute(IDestination destination, String lexeme, Indent indent)
            throws WriteException;
}


