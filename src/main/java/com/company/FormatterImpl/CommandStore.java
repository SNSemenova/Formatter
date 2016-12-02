package com.company.FormatterImpl;


import com.company.FormatterImpl.Commands.CloseBracketCommand;
import com.company.FormatterImpl.Commands.DefaultCommand;
import com.company.FormatterImpl.Commands.OpenBracketCommand;
import com.company.FormatterImpl.Commands.SemicolonCommand;
import com.company.FormatterImpl.Commands.NewLineCloseBracketCommand;
import com.company.FormatterImpl.Commands.DoNothingCommand;
import com.company.FormatterImpl.Commands.NewLineCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Store for commands.
 */
public class CommandStore {
    /**
     * Map for handlers.
     */
    private Map<String, ICommand> map;

    /**
     * Creates the map.
     */
    public CommandStore() {
        this.map = new HashMap<String, ICommand>();
        this.map.put("{default", new OpenBracketCommand());
        this.map.put("{afterAsterisk", new OpenBracketCommand());
        this.map.put("{afterSlash", new OpenBracketCommand());
        this.map.put("{lineComment", new DefaultCommand());
        this.map.put("{multiLineComment", new DefaultCommand());
        this.map.put("{string", new DefaultCommand());
        this.map.put("}afterAsterisk", new CloseBracketCommand());
        this.map.put("}afterSlash", new CloseBracketCommand());
        this.map.put("}default", new CloseBracketCommand());
        this.map.put("}lineComment", new DefaultCommand());
        this.map.put("}multiLineComment", new DefaultCommand());
        this.map.put("}string", new DefaultCommand());
        this.map.put(";afterAsterisk", new SemicolonCommand());
        this.map.put(";afterSlash", new SemicolonCommand());
        this.map.put(";default", new SemicolonCommand());
        this.map.put(";lineComment", new DefaultCommand());
        this.map.put(";multiLineComment", new DefaultCommand());
        this.map.put(";string", new DefaultCommand());
        this.map.put("}newLineDone", new NewLineCloseBracketCommand());
        this.map.put(";newLineDone", new SemicolonCommand());
        this.map.put("\nnewLineDone", new DoNothingCommand());
    }

    /**
     * Method for getting current handler.
     * @param currentState current state of formatter
     * @param symbol symbol for formatting
     * @return handler for formatter
     */
    public final ICommand getCommand(final String currentState,
                                     final char symbol) {
        String neededKey = symbol + currentState;
        if (this.map.containsKey(neededKey)) {
            return this.map.get(neededKey);
        } else {
            if (currentState == "newLineDone") {
                return new NewLineCommand();
            }
            return new DefaultCommand();
        }
    }
}

