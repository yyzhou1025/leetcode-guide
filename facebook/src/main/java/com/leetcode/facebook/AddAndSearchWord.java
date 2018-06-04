package com.leetcode.facebook;

/**
 * Created by liwentian on 17/8/18.
 */

public class AddAndSearchWord {

    TriNode root;

    public AddAndSearchWord() {
        root = new TriNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TriNode node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TriNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.word = word;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TriNode node, String word) {
        if (node == null) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c != '.') {
                if (node.nodes[c - 'a'] == null) {
                    return false;
                }
                node = node.nodes[c - 'a'];
            } else {
                String s = word.substring(i + 1);
                for (char cc = 'a'; cc <= 'z'; cc++) {
                    if (search(node.nodes[cc - 'a'], s)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return node.word != null;
    }

    class TriNode {
        TriNode[] nodes = new TriNode[26];
        String word;
    }
}
