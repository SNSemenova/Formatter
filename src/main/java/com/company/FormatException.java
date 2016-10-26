package com.company;

/**
 * Throws exceptions associated with the format.
 */
public class FormatException extends Exception {
    /**
     *Throws exceptions without arguments.
     */
    public FormatException() {
    }

    /**
     * Throws exceptions with message.
     * @param message message that exception send
     */
    public FormatException(final String message) {
        super(message);
    }

    /**
     * Throws exceptions with message and cause.
     * @param message message that exception send
     * @param cause cause of exception
     */
    public FormatException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Throws exceptions with cause.
     * @param cause cause of exception
     */
    public FormatException(final Throwable cause) {
        super(cause);
    }
}
