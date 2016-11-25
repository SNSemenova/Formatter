package com.company.FormatterImpl;


import com.company.FormatterImpl.Commands.CloseBracketCommand;
import com.company.FormatterImpl.Commands.DefaultCommand;
import com.company.FormatterImpl.Commands.LineBreakCommand;
import com.company.FormatterImpl.Commands.OpenBracketCommand;
import com.company.FormatterImpl.Commands.SemicolonCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Store for commands.
 */
public class CommandStore {
    /**
     * Method for getting current handler.
     * @param currentState current state of formatter
     * @param symbol symbol for formatting
     * @return handler for formatter
     */
    public final ICommand getCommand(final String currentState,
                                     final char symbol) {

        Map<String, ICommand> map = new HashMap<String, ICommand>();
        map.put("{default", new OpenBracketCommand());
        map.put("{afterAsterisk", new OpenBracketCommand());
        map.put("{afterSlash", new OpenBracketCommand());
        map.put("{lineComment", new DefaultCommand());
        map.put("{multiLineComment", new DefaultCommand());
        map.put("}afterAsterisk", new CloseBracketCommand());
        map.put("}afterSlash", new CloseBracketCommand());
        map.put("}default", new CloseBracketCommand());
        map.put("}lineComment", new DefaultCommand());
        map.put("}multiLineComment", new DefaultCommand());
        map.put(";afterAsterisk", new SemicolonCommand());
        map.put(";afterSlash", new SemicolonCommand());
        map.put(";default", new SemicolonCommand());
        map.put(";lineComment", new DefaultCommand());
        map.put(";multiLineComment", new DefaultCommand());
        map.put("\nlineComment", new LineBreakCommand());
        map.put("\nmultiLineComment", new LineBreakCommand());
        map.put("\nafterAsterisk", new LineBreakCommand());
        map.put("\nafterSlash", new LineBreakCommand());
        map.put("\ndefault", new LineBreakCommand());

        String neededKey = symbol + currentState;
        if (map.containsKey(neededKey)) {
            return map.get(neededKey);
        } else {
            return new DefaultCommand();
        }
    }
}

