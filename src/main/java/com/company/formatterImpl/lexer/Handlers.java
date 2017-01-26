package com.company.formatterImpl.lexer;

import com.company.formatterImpl.lexer.handlers.DefaultHandler;
import com.company.formatterImpl.lexer.handlers.NewLexemeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Class of handlers.
 */
public class Handlers {
    /**
     * Map for handlers.
     */
    private Map<String, IHandler> map;

    /**
     * Creates the map.
     */
    public Handlers() {
        this.map = new HashMap<String, IHandler>();
        this.map.put("default", new DefaultHandler());
        this.map.put("newLexeme", new NewLexemeHandler());
    }

    /**
     * Method for getting current handler.
     * @param currentState current state of formatter
     * @return handler for formatter
     */
    public final IHandler getHandler(final String currentState) {
        if (this.map.containsKey(currentState)) {
            return this.map.get(currentState);
        }
        return new DefaultHandler();
    }
}
