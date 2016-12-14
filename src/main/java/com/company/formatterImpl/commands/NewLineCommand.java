package com.company.formatterImpl.commands;

import com.company.core.IDestination;
import com.company.core.WriteException;
import com.company.formatterImpl.ICommand;
import com.company.formatterImpl.Indent;
import com.company.formatterImpl.state.States;

/**
 * Implementation for interface ICommand.
 */
public class NewLineCommand implements ICommand {
    @Override
    public final void execute(
            final IDestination destination, final String lexeme,
            final States state, final Indent indent)
            throws WriteException {
        destination.write(indent.doIndent());
        destination.write(lexeme);
    }
}
