package com.company.formatterImpl.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Tokens.
 */
public class Tokens {
    private Map<String, IToken> map = null;

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

    public boolean hasLexeme(String s) {
        return this.map.containsKey(s);
    }

    public IToken getToken(String s) {
        return this.map.get(s);
    }
}
