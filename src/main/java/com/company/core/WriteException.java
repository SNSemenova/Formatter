package com.company.core;

/**
 * Exceptions of writing.
 */
public class WriteException extends Exception {
    /**
     *Throws exceptions without arguments.
     */
    public WriteException() {
    }
    /**
     * Throws exceptions with message.
     * @param message message that exception send
     */
    public WriteException(final String message) {
        super(message);
    }
    /**
     * Throws exceptions with message and cause.
     * @param message message that exception send
     * @param cause cause of exception
     */
    public WriteException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * Throws exceptions with cause.
     * @param cause cause of exception
     */
    public WriteException(final Throwable cause) {
        super(cause);
    }
}
