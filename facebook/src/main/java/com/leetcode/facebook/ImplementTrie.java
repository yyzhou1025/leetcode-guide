package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 */

public class ImplementTrie {

    class TriNode {
        TriNode[] nodes = new TriNode[26];
        String word;
    }

    TriNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TriNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TriNode node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TriNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TriNode node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                return false;
            }
            node = node.nodes[c - 'a'];
        }
        return word.equals(node.word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TriNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                return false;
            }
            node = node.nodes[c - 'a'];
        }
        return true;
    }
}
