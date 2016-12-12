package com.company.formatterImpl.state;

/**
 * Implementation of IState.
 */
public class SimpleState implements IState {
    /**
     * Name of the current state.
     */
    private String currentState;

    /**
     * Initialises a newly created {@code SimpleState}
     * object so that it represents
     * the same sequence of characters as the argument.
     * @param curSt name of state,
     *                     that will be created
     */
    public SimpleState(final String curSt) {
        this.currentState = curSt;
    }

    /**
     * Overrides method in java.lang.Object.
     * @return a string representation of the object.
     */
    public final String toString() {
        return this.currentState;
    }
}
