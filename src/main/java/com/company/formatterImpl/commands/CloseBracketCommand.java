package com.company.formatterImpl.commands;

import com.company.core.IDestination;
import com.company.core.WriteException;
import com.company.formatterImpl.ICommand;
import com.company.formatterImpl.Indent;

/**
 * Implementation for interface ICommand.
 */
public class CloseBracketCommand implements ICommand {
    @Override
    public final void execute(
            final IDestination destination, final String lexeme,
            final Indent indent) throws WriteException {
        destination.write('\n');
        indent.decrementLevel();
        destination.write(indent.doIndent());
        destination.write(lexeme);
        destination.write('\n');
    }
}
