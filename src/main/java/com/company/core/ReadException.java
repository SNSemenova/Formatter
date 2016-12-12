package com.company.core;

/**
 * Throws exceptions associated with the reading.
 */
public class ReadException extends Exception {
    /**
     *Throws exceptions without arguments.
     */
    public ReadException() {
    }
    /**
     * Throws exceptions with message.
     * @param message message that exception send
     */
    public ReadException(final String message) {
        super(message);
    }
    /**
     * Throws exceptions with message and cause.
     * @param message message that exception send
     * @param cause cause of exception
     */
    public ReadException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * Throws exceptions with cause.
     * @param cause cause of exception
     */
    public ReadException(final Throwable cause) {
        super(cause);
    }
}
