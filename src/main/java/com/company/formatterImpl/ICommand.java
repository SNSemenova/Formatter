package com.company.formatterImpl;

import com.company.core.WriteException;

/**
 *  Interface for commands.
 */
public interface ICommand {

    /**
     * Execution of handler.
     * @param lexeme current string for formatting
     * @throws WriteException when symbol can't be read
     * @return completed lexeme
     */
    String execute(String lexeme)
            throws WriteException;
}


