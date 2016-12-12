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
        this.map.put("*multiLineComment", new SimpleState("afterAsterisk"));
        this.map.put("*afterSlash", new SimpleState("multiLineComment"));
        this.map.put("/default", new SimpleState("afterSlash"));
        this.map.put("/newLineDone", new SimpleState("afterSlash"));
        this.map.put("/afterSlash", new SimpleState("lineComment"));
        this.map.put("/afterAsterisk", new SimpleState("default"));
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

        this.map.put("afterSlash", new SimpleState("default"));
        this.map.put("afterAsterisk", new SimpleState("default"));
        this.map.put("newLineDone", new SimpleState("default"));
        this.map.put("escapeSequence", new SimpleState("string"));

        this.currentState = new SimpleState("default");
    }

    /**
     * Function of setting new state.
     * @param symbol symbol from the source
     */
    public final void updateState(final char symbol) {
        String neededKey = symbol + this.currentState.toString();
        if (this.map.containsKey(neededKey)) {
                this.currentState = this.map.get(neededKey);
            } else {
                if (this.map.containsKey(this.currentState.toString())) {
                    this.currentState
                            = this.map.get(this.currentState.toString());
                }
            }
    }
}
