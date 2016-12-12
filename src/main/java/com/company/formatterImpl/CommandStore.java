package com.company.formatterImpl;


import com.company.formatterImpl.commands.CloseBracketCommand;
import com.company.formatterImpl.commands.DefaultCommand;
import com.company.formatterImpl.commands.OpenBracketCommand;
import com.company.formatterImpl.commands.SemicolonCommand;
import com.company.formatterImpl.commands.NewLineCloseBracketCommand;
import com.company.formatterImpl.commands.DoNothingCommand;
import com.company.formatterImpl.commands.NewLineCommand;

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

        this.map.put("newLineDone", new NewLineCommand());
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
        }
        if (this.map.containsKey(currentState)) {
            return this.map.get(currentState);
        }
        return new DefaultCommand();
    }
}

