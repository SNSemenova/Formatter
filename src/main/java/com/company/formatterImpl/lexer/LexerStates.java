package com.company.formatterImpl.lexer;

import com.company.formatterImpl.state.IState;
import com.company.formatterImpl.state.SimpleState;

import java.util.HashMap;
import java.util.Map;

/**
 * States of lexer.
 */
public class LexerStates {
    /**
     * Instance of IState.
     */
    private IState currentState;

    /**
     * Gives name of the current state.
     * @return string containing state
     */
    public final String getCurrentState() {
        return this.currentState.toString();
    }

    /**
     * Map of states.
     */
    private Map<String, SimpleState> map;

    /**
     * Method for creating object States.
     */
    public LexerStates() {
        this.map = new HashMap<String, SimpleState>();
        this.map.put("/default", new SimpleState("lexemeStart"));
        this.map.put("*default", new SimpleState("lexemeStart"));
        this.map.put("{default", new SimpleState("newLexeme"));
        this.map.put("{newLexeme", new SimpleState("newLexeme"));
        this.map.put(")default", new SimpleState("newLexeme"));
        this.map.put(")newLexeme", new SimpleState("newLexeme"));
        this.map.put("}default", new SimpleState("newLexeme"));
        this.map.put("}newLexeme", new SimpleState("newLexeme"));
        this.map.put(";default", new SimpleState("newLexeme"));
        this.map.put(";newLexeme", new SimpleState("newLexeme"));
        this.map.put("fdefault", new SimpleState("newLexeme"));

        this.currentState = new SimpleState("default");
    }

    /**
     * Function of setting new state.
     * @param c symbol from the source
     */
    public final void updateState(final Character c) {
        String neededKey = c + this.currentState.toString();
        if (this.map.containsKey(neededKey)) {
            this.currentState = this.map.get(neededKey);
        } else {
            this.currentState = new SimpleState("default");
        }
    }
}
