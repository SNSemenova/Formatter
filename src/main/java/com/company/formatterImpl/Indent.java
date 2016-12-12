package com.company.formatterImpl;

/**
 * Class for indents counting.
 */
public class Indent {
    /**
     * Level of nesting.
     */
    private int level = 0;

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
     * Returns the string of spaces for indent.
     * @return string containing spaces
     */
    public final String doIndent() {
        String ind = "";
        for (int i = 0; i < this.level; i++) {
            ind = ind + ("    ");
        }
        return ind;
    }
}
