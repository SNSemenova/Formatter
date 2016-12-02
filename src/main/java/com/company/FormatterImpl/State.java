package com.company.FormatterImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * State of formatter.
 */

public class State {
    /**
     * Level of nesting.
     */
    private int level = 0;

    /**
     * To get level of nesting.
     * @return level of nesting
     */
    public final int getLevel() {
        return level;
    }

    /**
     * Plus one to level.
     */
    public final void incrementLevel() {
        level++;
    }

    /**
     * Minus one to level.
     */
    public final void decrementLevel() {
        level--;
    }

    /**
     * Map of states.
     */
    private Map<String, String> map;

    /**
     * Method for creating object State.
     */
    State() {
        this.map = new HashMap<String, String>();
        this.map.put("*multiLineComment", "afterAsterisk");
        this.map.put("*afterSlash", "multiLineComment");
        this.map.put("/default", "afterSlash");
        this.map.put("/newLineDone", "afterSlash");
        this.map.put("/afterSlash", "lineComment");
        this.map.put("/afterAsterisk", "default");
        this.map.put("\nlineComment", "newLineDone");
        this.map.put(";default", "newLineDone");
        this.map.put("}default", "newLineDone");
        this.map.put("\ndefault", "newLineDone");
        this.map.put("{default", "newLineDone");
        this.map.put(";newLineDone", "newLineDone");
        this.map.put("}newLineDone", "newLineDone");
        this.map.put("\nnewLineDone", "newLineDone");
        this.map.put("{newLineDone", "newLineDone");
        this.map.put("\"default", "string");
        this.map.put("\"string", "default");
        this.map.put("\\string", "escapeSequence");

        this.map.put("afterSlash", "default");
        this.map.put("afterAsterisk", "default");
        this.map.put("newLineDone", "default");
        this.map.put("escapeSequence", "string");

        this.currentState = "default";
    }

    /**
     * Function of setting new state.
     * @param symbol symbol from the source
     */
    public final void updateState(final char symbol) {
        String neededKey = symbol + this.currentState;
        if (this.map.containsKey(neededKey)) {
                this.currentState = this.map.get(neededKey);
            } else {
                if (this.map.containsKey(this.currentState)) {
                    this.currentState = this.map.get(this.currentState);
                }
            }
    }

    /**
     * Getting current state.
     * @return current state
     */
    public final String getCurrentState() {
        return this.currentState;
    }

    /**
     * Current state.
     */
    private String currentState;
}
