package com.tree;

public class Trie {
    private Trie[] leaves;
    private char character;

    public Trie[] getLeaves() {
        return leaves;
    }

    public void setLeaves(Trie[] leaves) {
        this.leaves = leaves;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Trie() {
    }

    public Trie(char character) {
        this.character = character;
    }

    public Trie(Trie[] leaves, char character) {
        this.leaves = leaves;
        this.character = character;
    }
}
