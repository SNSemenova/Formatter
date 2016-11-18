package com.company.FormatterImpl;

import com.company.Core.IDestination;

/**
 *  Interface for commands.
 */
public interface ICommand {
    void execute(IDestination destination, char symbol, State state);
}


