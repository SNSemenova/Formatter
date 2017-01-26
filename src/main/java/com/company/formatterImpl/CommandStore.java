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
     * Instance of indent.
     */
    private Indent indent;

    /**
     * Creates the map.
     */
    public CommandStore() {
        indent = new Indent();

        this.map = new HashMap<String, ICommand>();
        this.map.put("{default", new OpenBracketCommand(indent));
        this.map.put("{afterAsterisk", new OpenBracketCommand(indent));
        this.map.put("{afterSlash", new OpenBracketCommand(indent));
        this.map.put("}afterAsterisk", new CloseBracketCommand(indent));
        this.map.put("}afterSlash", new CloseBracketCommand(indent));
        this.map.put("}default", new CloseBracketCommand(indent));
        this.map.put(";afterAsterisk", new SemicolonCommand(indent));
        this.map.put(";afterSlash", new SemicolonCommand(indent));
        this.map.put(";default", new SemicolonCommand(indent));
        this.map.put("}newLineDone", new NewLineCloseBracketCommand(indent));
        this.map.put(";newLineDone", new SemicolonCommand(indent));
        this.map.put("\nnewLineDone", new DoNothingCommand(indent));

        this.map.put("newLineDone", new NewLineCommand(indent));

    }

    /**
     * Method for getting current handler.
     * @param currentState current state of formatter
     * @param lexeme string for formatting
     * @return handler for formatter
     */
    public final ICommand getCommand(final String currentState,
                                     final String lexeme) {
        String neededKey = lexeme + currentState;
        if (this.map.containsKey(neededKey)) {
            return this.map.get(neededKey);
        }
        if (this.map.containsKey(currentState)) {
            return this.map.get(currentState);
        }
        return new DefaultCommand(indent);
    }
}

