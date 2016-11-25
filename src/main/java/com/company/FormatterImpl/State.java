package com.company.FormatterImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * State of formatter.
 */

public class State {
    /**
     * Previous symbol.
     */
    private char previous = 0;
    /**
     * Level of nesting.
     */
    private int level = 0;

    /**
     * To get previous symbol.
     * @return previous symbol
     */
    public final char getPrevious() {
        return previous;
    }

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
     * To set previous symbol.
     * @param previous previous symbol
     */
    public final void setPrevious(final char previous) {
        this.previous = previous;
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
        this.map.put("/afterSlash", "lineComment");
        this.map.put("/afterAsterisk", "default");
        this.map.put("\nlineComment", "default");

        this.currentState = "default";
    }

    /**
     * Function of setting new state.
     * @param symbol symbol from the source
     */
    public final void updateState(final char symbol) {
        String neededKey = symbol + this.currentState;
        if (this.map.containsKey(neededKey)) {
            if ((this.currentState == "afterSlash")
                    && (this.currentState == "afterAsterisk")) {
                this.currentState = "default";
            } else {
                this.currentState = this.map.get(neededKey);
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
