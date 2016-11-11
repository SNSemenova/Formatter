package com.company.source;
/**
 * Implements ISource with string.
 */
public class StringSource implements ISource {
    /**
     * The string of source.
     */
    private String source = null;
    /**
     * Number of current symbol.
     */
    private int current = 0;

    /**
     * Takes string from the source.
     * @param src code for formatting
     */
    public StringSource(final String src) {
        this.source = src;
    }

    @Override
    public final boolean hasNext() {
        return (this.current < this.source.length());
    }

    @Override
    public final char read() throws ReadException {
        try {
            return this.source.charAt(this.current++);
        } catch (Exception e) {
            throw new ReadException(e);
        }
    }

    @Override
    public void close() {
        // Should be empty for Strings
    }
}
