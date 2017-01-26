package com.company.formatterImpl;

import com.company.core.*;
import com.company.formatterImpl.state.States;

/**
 * Formats code.
 */
public class Formatter implements IFormatter {
    /**
     * Instance of States.
     */
    private States state;

    /**
     * Instance of CommandStore.
     */
    private CommandStore options;

    /**
     * Creates Formatter.
     */
    public Formatter() {
        state = new States();
        options = new CommandStore();
    }

    @Override
    public final void format(final ISource<String> source,
                             final IDestination destination)
            throws FormatException {
        ICommand command = null;
        String out;
        try {
            while (source.hasNext()) {
                String lexeme = source.read();
                command =
                        options.getCommand(state.getCurrentState(), lexeme);
                out = command.execute(lexeme);
                destination.write(out);
                state.updateState(lexeme);
            }
        } catch (ReadException e) {
            throw new FormatException(e);
        } catch (WriteException e) {
            throw new FormatException(e);
        }
    }
}
