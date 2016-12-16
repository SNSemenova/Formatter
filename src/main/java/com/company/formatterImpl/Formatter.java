package com.company.formatterImpl;


import com.company.core.*;
import com.company.formatterImpl.lexer.IToken;
import com.company.formatterImpl.state.States;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    @Override
    public final void format(final ISource<IToken> source,
                             final IDestination destination)
            throws FormatException {
        States state = new States();
        CommandStore options = new CommandStore();
        Indent indent = new Indent();
        try {
            while (source.hasNext()) {
                IToken token = source.read();
                String lexeme = token.getLexeme();
                ICommand command =
                        options.getCommand(state.getCurrentState(), lexeme);
                command.execute(destination, lexeme, state, indent);
                state.updateState(lexeme);
            }
        } catch (ReadException e) {
            throw new FormatException(e);
        } catch (WriteException e) {
            throw new FormatException(e);
        }
    }
}
