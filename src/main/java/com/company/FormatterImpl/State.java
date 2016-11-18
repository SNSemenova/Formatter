package com.company.FormatterImpl;

/**
 * State of formatter.
 */
public class State {
    public char previous = 0;
    public int level = 0;
    public boolean lineComment;
    public boolean multiLineComment;

    public char getPrevious() {
        return previous;
    }

    public int getLevel() {
        return level;
    }

    public void incrementLevel() {
        level++;
    }

    public void decrementLevel() {
        level--;
    }

    public void setPrevious(char previous) {
        this.previous = previous;
    }

    public boolean isLineComment() {
        return lineComment;
    }

    public void setLineComment(boolean lineComment) {
        this.lineComment = lineComment;
    }

    public boolean isMultiLineComment() {
        return multiLineComment;
    }

    public void setMultiLineComment(boolean multiLineComment) {
        this.multiLineComment = multiLineComment;
    }
}
