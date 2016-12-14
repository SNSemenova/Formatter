package com.company.formatterImpl.lexer;

/**
 * Implementation of IToken.
 */
public class Token implements IToken {
    /**
     * String of lexeme.
     */
    private String lexeme;

    /**
     * Initialization of token.
     * @param string string of lexeme
     */
    public Token(final String string) {
        this.lexeme = string;
    }

    /**
     * Gets lexeme.
     * @return string of lexeme
     */
    public final String getLexeme() {
        return lexeme;
    }
}
