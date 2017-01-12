package com.company.formatterImpl.commands;

import com.company.core.IDestination;
import com.company.core.WriteException;
import com.company.formatterImpl.ICommand;
import com.company.formatterImpl.Indent;

/**
 * Implementation for interface ICommand.
 */
public class OpenBracketCommand implements ICommand {

    @Override
    public final void execute(final IDestination destination,
                              final String lexeme, final Indent indent)
            throws WriteException {
            destination.write(lexeme);
            indent.incrementLevel();
            destination.write('\n');
    }
}
