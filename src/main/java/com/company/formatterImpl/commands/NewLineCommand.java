package com.company.formatterImpl.commands;

import com.company.core.WriteException;
import com.company.formatterImpl.ICommand;
import com.company.formatterImpl.Indent;

/**
 * Implementation for interface ICommand.
 */
public class NewLineCommand implements ICommand {
    /**
     * Instance of Indent.
     */
    private Indent indent;

    /**
     * Creates instance of ICommand implementation.
     * @param indent instance of Indent
     */
    public NewLineCommand(final Indent indent) {
        this.indent = indent;
    }

    @Override
    public final String execute(final String lexeme)
            throws WriteException {
        String string = indent.doIndent();
        string += lexeme;
        return string;
    }
}
