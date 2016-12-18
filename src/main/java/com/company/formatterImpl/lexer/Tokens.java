package com.company.formatterImpl.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Tokens.
 */
public class Tokens {
    /**
     * Map for special tokens.
     */
    private Map<String, IToken> map = null;

    /**
     * Initialisation of exemplar.
     */
    public Tokens() {
        this.map = new HashMap<String, IToken>();
        this.map.put("{", new Token("{"));
        this.map.put("}", new Token("}"));
        this.map.put(";", new Token(";"));
        this.map.put("//", new Token("//"));
        this.map.put("/*", new Token("/*"));
        this.map.put("*/", new Token("*/"));
        this.map.put("\n", new Token("\n"));
        this.map.put("\"", new Token("\""));
        this.map.put("for", new Token("for"));
        this.map.put(")", new Token(")"));
    }

    /**
     * Checks if gotten string is a special lexeme.
     * @param s string of lexeme
     * @return true if gotten string is a special lexeme
     */
    public final boolean hasLexeme(final String s) {
        return this.map.containsKey(s);
    }

    /**
     * Gets token.
     * @param s string of lexeme
     * @return token
     */
    public final IToken getToken(final String s) {
        return this.map.get(s);
    }
}
