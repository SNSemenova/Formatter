package com.company.source;

public class StringSource implements ISource {

    private String source;
    private int current = 0;

    public StringSource(String source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return (this.current < this.source.length());
    }

    @Override
    public char read() throws ReadException {
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
