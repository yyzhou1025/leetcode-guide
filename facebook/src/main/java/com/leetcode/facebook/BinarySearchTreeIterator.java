package com.leetcode.facebook;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by liwentian on 17/8/18.
 */

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    TreeNode node;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (hasNext()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                int val = node.val;
                node = node.right;
                return val;
            }
        }
        throw new IllegalStateException();
    }
}
