package com.company.FormatterImpl;

import com.company.FormatterImpl.Commands.*;

/**
 * Store for commands.
 */
public class CommandStore {

    public ICommand getCommand(char symbol) {
        if (symbol == '{') {
            return new OpenBracketCommand();
        }
        if (symbol == '}') {
            return new CloseBracketCommand();
        }
        if (symbol == ';') {
            return new SemicolonCommand();
        }
        if (symbol == '/') {
            return new SlashCommand();
        }
        if (symbol == '*') {
            return new AsteriskCommand();
        }
        if (symbol == '\n') {
            return new LineBreakCommand();
        }
        return new DefaultCommand();
    }
}

