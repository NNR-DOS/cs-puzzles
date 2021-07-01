package algorithms;

import java.util.HashMap;

public class Trie {
    final TrieNode root;

    private static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean enoOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.enoOfWord = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, 0, this.root);
    }

    private void insert(String word, int index, TrieNode currentTrieNode) {
        if (index == word.length()) {
            currentTrieNode.enoOfWord = true;
            return;
        }
        TrieNode child = currentTrieNode.children.get(word.charAt(index));
        if (child == null) {
            child = new TrieNode();
            currentTrieNode.children.put(word.charAt(index), child);
        }
        insert(word, index + 1, child);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, 0, this.root);
    }

    private boolean search(String word, int index, TrieNode currentTrieNode) {
        if (index == word.length()) {
            return currentTrieNode.enoOfWord;
        }
        TrieNode child = currentTrieNode.children.get(word.charAt(index));
        if (child == null) {
            return false;
        }
        return search(word, index + 1, child);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0, this.root);
    }

    private boolean startsWith(String prefix, int index, TrieNode currentTrieNode) {
        if (index == prefix.length()) {
            return true;
        }
        TrieNode child = currentTrieNode.children.get(prefix.charAt(index));
        if (child == null) {
            return false;
        }
        return startsWith(prefix, index + 1, child);
    }


    public static void main(String[] args) {

        /*
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
         */

        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

}

