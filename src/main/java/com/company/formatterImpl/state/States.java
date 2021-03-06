package com.company.formatterImpl.state;

import java.util.HashMap;
import java.util.Map;

/**
 * States of formatter.
 */

public class States {
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
    public States() {
        this.map = new HashMap<String, SimpleState>();
        this.map.put("/*default", new SimpleState("multiLineComment"));
        this.map.put("/*newLineDone", new SimpleState("multiLineComment"));
        this.map.put("//default", new SimpleState("lineComment"));
        this.map.put("//newLineDone", new SimpleState("lineComment"));
        this.map.put("*/multiLineComment", new SimpleState("default"));
        this.map.put("\nlineComment", new SimpleState("newLineDone"));
        this.map.put(";default", new SimpleState("newLineDone"));
        this.map.put("}default", new SimpleState("newLineDone"));
        this.map.put("\ndefault", new SimpleState("newLineDone"));
        this.map.put("{default", new SimpleState("newLineDone"));
        this.map.put(";newLineDone", new SimpleState("newLineDone"));
        this.map.put("}newLineDone", new SimpleState("newLineDone"));
        this.map.put("\nnewLineDone", new SimpleState("newLineDone"));
        this.map.put("{newLineDone", new SimpleState("newLineDone"));
        this.map.put("\"default", new SimpleState("string"));
        this.map.put("\"string", new SimpleState("default"));
        this.map.put("\\string", new SimpleState("escapeSequence"));
        this.map.put("fordefault", new SimpleState("forCondition"));
        this.map.put("fornewLineDone", new SimpleState("forCondition"));
        this.map.put(")forCondition", new SimpleState("default"));

        this.map.put("afterSlash", new SimpleState("default"));
        this.map.put("afterAsterisk", new SimpleState("default"));
        this.map.put("newLineDone", new SimpleState("default"));
        this.map.put("escapeSequence", new SimpleState("string"));

        this.currentState = new SimpleState("default");
    }

    /**
     * Function of setting new state.
     * @param lexeme symbol from the source
     */
    public final void updateState(final String lexeme) {
        String neededKey = lexeme + this.currentState.toString();
        IState newState = null;
        newState = this.map.get(neededKey);
        if (newState == null) {
            newState = this.map.get(this.currentState.toString());
        }
        if (newState != null) {
            this.currentState = newState;
        }
    }
}
